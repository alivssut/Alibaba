package com.example.alibaba.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.alibaba.R
import com.example.alibaba.databinding.FragmentAccountBinding

class AccountFragment (val toolbar: androidx.appcompat.widget.Toolbar , val title : TextView): Fragment(){
    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(layoutInflater)
        toolbar.setBackgroundResource(R.color.toolbarWhite)
        title.setText(R.string.accountTitle)


        return binding.root
    }

}