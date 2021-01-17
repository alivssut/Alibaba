package com.example.alibaba.viewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alibaba.model.Cities
import com.example.test.repository.Repository
import kotlinx.coroutines.launch

class CitiesActivityViewModel (private val repository: Repository): ViewModel(){
    val myResponse : MutableLiveData<MutableList<Cities>> = MutableLiveData()

    fun listOfcities(activity : Activity){
        viewModelScope.launch {
            val response = repository.getBusStations(activity)
            myResponse.value = response
        }
    }

}