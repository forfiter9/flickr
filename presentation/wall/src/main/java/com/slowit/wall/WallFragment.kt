package com.slowit.wall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.slowit.wall.databinding.FragmentWallBinding

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

        viewModel.state.collectInLifeCycle(this){renderState(it)}
        viewModel.events.collectInLifeCycle(this){renderEvent(it)}
    }

    private fun renderEvent(wallEvents: WallEvents) {
        when(wallEvents) {
            is WallEvents.OpenExternalLink -> {}
        }
    }

    private fun renderState(wallState: WallState) {

    }
}