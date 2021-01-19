package com.example.alibaba.viewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alibaba.model.Cities
import com.example.test.repository.Repository
import kotlinx.coroutines.launch

class HotelViewModel (private val repository: Repository): ViewModel(){
    val myResponse : MutableLiveData<MutableList<Cities>> = MutableLiveData()

    fun listOfBusStations(activity : Activity){
        viewModelScope.launch {
            val response = repository.getHotelsDomestic(activity)
            myResponse.value = response
        }
    }

}