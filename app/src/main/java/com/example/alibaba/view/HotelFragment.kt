package com.example.alibaba.view

import android.content.Intent
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



        binding.hotelOrigin.setOnClickListener {
            val intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "origin")
            intent.putExtra("type", "hotel")
            startActivity(intent)
        }

        binding.hotelDateSelect.setOnClickListener {
            val intent = Intent(activity!!.baseContext, CalendarActivity::class.java)
            intent.putExtra("count", "1")
            startActivity(intent)
        }

        return binding.root
    }
}