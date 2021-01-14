package com.example.alibaba.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentTourBinding
import com.example.alibaba.databinding.FragmentTrainBinding

class TrainFragment  : Fragment() {
    private lateinit var binding: FragmentTrainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainBinding.inflate(layoutInflater)


        return binding.root
    }
}