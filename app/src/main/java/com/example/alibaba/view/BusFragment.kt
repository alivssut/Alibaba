package com.example.alibaba.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alibaba.databinding.FragmentBusBinding
import com.example.alibaba.factory.BusViewModeFactory
import com.example.alibaba.viewModel.BusViewModel
import com.example.test.repository.Repository

class BusFragment : Fragment(){
    private lateinit var binding: FragmentBusBinding
    lateinit var viewModel: BusViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusBinding.inflate(layoutInflater)

        val repository  = Repository("s")
        val viewModelFactory = BusViewModeFactory(repository)

        viewModel = ViewModelProvider(this , viewModelFactory).get(BusViewModel::class.java)


//        viewModel.listOfBusStations(activity!!)
//        viewModel.myResponse.observe(activity!! , Observer {response->
//
//
//        })

        binding.busSelectDestination.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , CitiesActivity::class.java))
        }
        binding.busSelectOrigin.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , CitiesActivity::class.java))
        }
        binding.busSelectDate.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , CalendarActivity::class.java))
        }


        return binding.root
    }
}