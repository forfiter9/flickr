package com.slowit.wall

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.slowit.wall.databinding.FragmentWallBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WallFragment : Fragment() {

    private var _binding: FragmentWallBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WallViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
        viewModel.state.collectInLifeCycle(this){renderState(it)}
        viewModel.getPosts()
    }

    private fun configureView() {
        with(binding.postRecyclerView) {
            layoutManager = if (context.isTablet()) GridLayoutManager(context, SPAN_COUNT_TABLET) else GridLayoutManager(context, SPAN_COUNT_PHONE)
            adapter = WallAdapter().apply {
                onPostClickListener = WallAdapter.OnPostClickListener {
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(it.link))
                    startActivity(browserIntent)
                }
            }
        }
    }

    private fun renderState(wallState: WallState) {
        (binding.postRecyclerView.adapter as WallAdapter).submitList(wallState.posts)
    }

    companion object {
        const val SPAN_COUNT_TABLET = 3
        const val SPAN_COUNT_PHONE = 1
    }
}