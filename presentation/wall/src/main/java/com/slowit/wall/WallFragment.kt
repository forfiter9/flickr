package com.slowit.wall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slowit.wall.databinding.FragmentWallBinding

class WallFragment : Fragment() {

    private var _binding: FragmentWallBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWallBinding.inflate(inflater, container, false)
        return binding.root
    }
}