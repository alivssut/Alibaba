package com.example.alibaba.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivitySearchTicketBinding
import com.example.alibaba.factory.CitiesActivityViewModelFactory
import com.example.alibaba.factory.SearchTicketActivityViewModelFactory
import com.example.alibaba.viewModel.CitiesActivityViewModel
import com.example.alibaba.viewModel.SearchTicketActivityViewModel
import com.example.test.repository.Repository
import com.example.test.util.Constants

class SearchTicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchTicketBinding
    lateinit var viewModel: SearchTicketActivityViewModel
    lateinit var recyclerView: RecyclerView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_ticket)
        binding = ActivitySearchTicketBinding.inflate(layoutInflater)
        recyclerView = findViewById(R.id.search_ticket_recycler_list)

        val type = intent.getStringExtra("type")


        if (type == "bus") {
            val url =
                "Bus/available?orginCityCode=${Constants.requesForData!!.originId}&destinationCityCode=${Constants.requesForData!!.destinationId}&requestDate=${Constants.requesForData!!.requestDate}&passengerCount=${Constants.requesForData!!.passengerCount}"
            val repository = Repository(url, "none")
            repository.recyclerView = recyclerView

            binding.searchTicketToolbarTitle.text = Constants.originCity!!.name+">"+Constants.destinationCity!!.name

            val viewModelFactory = SearchTicketActivityViewModelFactory(repository)

            viewModel =
                ViewModelProvider(
                    this,
                    viewModelFactory
                ).get(SearchTicketActivityViewModel::class.java)

            viewModel.listOfTickets(this)
            viewModel.myResponse.observe(this, Observer { response ->

            })
        }else if (type == "train") {
            val requestUrl = Constants.BASE_URL + "train/available"
            val repository = Repository(requestUrl, "none")
            repository.recyclerView = recyclerView

            val viewModelFactory = SearchTicketActivityViewModelFactory(repository)

            viewModel =
                ViewModelProvider(
                    this,
                    viewModelFactory
                ).get(SearchTicketActivityViewModel::class.java)

            viewModel.trainParametersRequest(this)
            viewModel.myResponse.observe(this, Observer { response ->

            })
        }

    }
}
