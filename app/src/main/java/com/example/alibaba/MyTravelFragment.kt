package com.example.alibaba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentAccountBinding
import com.example.alibaba.databinding.FragmentHomeBinding
import com.example.alibaba.databinding.FragmentMyTravelBinding

class MyTravelFragment (val toolbar: androidx.appcompat.widget.Toolbar , val title : TextView): Fragment(){
    private lateinit var binding: FragmentMyTravelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyTravelBinding.inflate(layoutInflater)
        toolbar.setBackgroundResource(R.color.toolbarWhite)
        title.setText(R.string.myTravelTitle)

        return binding.root
    }

}