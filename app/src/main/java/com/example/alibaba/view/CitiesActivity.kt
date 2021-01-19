package com.example.alibaba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityCitiesBinding
import com.example.alibaba.factory.CitiesActivityViewModelFactory
import com.example.alibaba.viewModel.CitiesActivityViewModel
import com.example.test.repository.Repository


class CitiesActivity : AppCompatActivity() {

    val busCitiesUrl = "basic-info/bus/stations?filter=q%3D%7Bct%3A%22%22%7D&page_no=1&page_size=50"
    val trainCitiesUrl = "basic-info/train/stations?page_no=1&page_size=1000"
    val domesticCitiesUrl = "basic-info/airports/domestic"
    val internationalCitiesUrl =
        "basic-info/airports/international?filter=q%3D%7Bct%3A%22%20%22%7D"
    val airportsUrl = "flightInfo/airports"
    private lateinit var binding: ActivityCitiesBinding
    lateinit var viewModel: CitiesActivityViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        binding = ActivityCitiesBinding.inflate(layoutInflater)
        recyclerView = findViewById(R.id.cities_recycler_list)

        setSupportActionBar(binding.citiesToolBar).apply {
            title = ""
        }

        val state: String = intent.getStringExtra("state")!!
        val type: String = intent.getStringExtra("type")!!

        if (state == "origin")binding.citiesToolbarTitle.text = "انتخاب مبدا"
        if (state == "destination")binding.citiesToolbarTitle.text = "انتخاب مقصد"

        var url = ""
        if (type == "train") url = trainCitiesUrl
        else if (type == "bus") url = busCitiesUrl
        else if (type == "domestic") url = domesticCitiesUrl
        else if (type == "international") url = internationalCitiesUrl
        else if (type == "airport") url = airportsUrl

        val repository = Repository(url, state)
        repository.recyclerView = recyclerView

        val viewModelFactory = CitiesActivityViewModelFactory(repository)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(CitiesActivityViewModel::class.java)
//        Toast.makeText(this , Constants.citiesList.toString() , Toast.LENGTH_LONG).show()

        if (type == "bus") {
            viewModel.listOfcities(this)
        } else if (type == "train") {
            viewModel.trainCities(this)
        } else if (type == "domestic") {
            viewModel.domesticCities(this)
        }else if (type == "international") {
            viewModel.internationalCities(this)
        }else if (type == "hotel"){
            viewModel.hotelDomestic(this)
        }else if(type == "airport"){
            viewModel.domesticCities(this)
        }
        viewModel.myResponse.observe(this, Observer { response ->


        })
    }

}
