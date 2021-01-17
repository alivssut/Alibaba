package com.example.alibaba.view

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alibaba.databinding.FragmentBusBinding
import com.example.alibaba.factory.BusViewModeFactory
import com.example.alibaba.model.TicketRequest
import com.example.alibaba.viewModel.BusViewModel
import com.example.test.repository.Repository
import com.example.test.util.Constants

class BusFragment : Fragment() {
    private lateinit var binding: FragmentBusBinding
    lateinit var viewModel: BusViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusBinding.inflate(layoutInflater)


        Constants.originCity = null
        Constants.destinationCity = null
        Constants.date = null

        val repository = Repository("s", "")
        val viewModelFactory = BusViewModeFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(BusViewModel::class.java)


//        viewModel.listOfBusStations(activity!!)
//        viewModel.myResponse.observe(activity!! , Observer {response->
//
//
//        })

        binding.busSelectDestination.setOnClickListener {
            var intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "destination")
            startActivity(intent)
        }
        binding.busSelectOrigin.setOnClickListener {
            var intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "origin")
            startActivity(intent)
        }
        binding.busSelectDate.setOnClickListener {
            startActivity(Intent(activity!!.baseContext, CalendarActivity::class.java))
        }


        binding.busBtnSearch.setOnClickListener {
            if (Constants.originCity != null && Constants.destinationCity != null && Constants.date != null) {
                Constants.requesForData = TicketRequest(
                    Constants.originCity!!.code,
                    Constants.destinationCity!!.code,
                    Constants.date!!,
                    "1"
                )
                startActivity(Intent(activity!!.baseContext, SearchTicketActivity::class.java))
            }
        }


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (Constants.originCity != null)
            binding.busOrigin.text = Constants.originCity!!.name
        if (Constants.destinationCity != null)
            binding.busDestination.text = Constants.destinationCity!!.name
        if (Constants.date != null)
            binding.busDate.text = Constants.date

    }
}