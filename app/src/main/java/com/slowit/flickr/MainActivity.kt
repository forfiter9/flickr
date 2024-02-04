package com.slowit.flickr

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.slowit.flickr.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}