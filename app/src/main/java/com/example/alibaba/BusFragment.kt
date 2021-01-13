package com.example.alibaba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentBusBinding

class BusFragment : Fragment(){
    private lateinit var binding: FragmentBusBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusBinding.inflate(layoutInflater)


        return binding.root
    }
}