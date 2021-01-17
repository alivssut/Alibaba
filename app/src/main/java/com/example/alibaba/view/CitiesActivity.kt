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
import com.example.alibaba.model.Cities
import com.example.alibaba.viewModel.CitiesActivityViewModel
import com.example.test.repository.Repository


class CitiesActivity : AppCompatActivity() {

    val busCitiesUrl = "basic-info/bus/stations?filter=q%3D%7Bct%3A%22%22%7D&page_no=1&page_size=50"
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


        val repository  = Repository(busCitiesUrl)
        repository.recyclerView = recyclerView

        val viewModelFactory = CitiesActivityViewModelFactory(repository)

        viewModel = ViewModelProvider(this , viewModelFactory).get(CitiesActivityViewModel::class.java)

        var l : MutableList<Cities> = arrayListOf()
        l.add(Cities("name" , "sd"))

        viewModel.listOfcities(this)
        viewModel.myResponse.observe(this , Observer { response ->

            Toast.makeText(this , response.toString() , Toast.LENGTH_LONG).show()

        })
    }
}
