package com.example.alibaba.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentFlyBinding

class FlyFragment : Fragment() {
    private lateinit var binding: FragmentFlyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlyBinding.inflate(layoutInflater)


        return binding.root
    }
}