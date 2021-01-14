package com.example.alibaba.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentBusBinding
import com.example.alibaba.databinding.FragmentTourBinding

class TourFragment : Fragment() {
    private lateinit var binding: FragmentTourBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTourBinding.inflate(layoutInflater)


        return binding.root
    }
}