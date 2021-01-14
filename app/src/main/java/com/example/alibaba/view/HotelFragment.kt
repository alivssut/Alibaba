package com.example.alibaba.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentHomeBinding
import com.example.alibaba.databinding.FragmentHotelBinding
import com.example.alibaba.databinding.FragmentTourBinding

class HotelFragment  : Fragment() {
    private lateinit var binding: FragmentHotelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelBinding.inflate(layoutInflater)


        return binding.root
    }
}