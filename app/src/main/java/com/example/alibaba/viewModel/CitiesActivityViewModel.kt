package com.example.alibaba.viewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alibaba.model.Cities
import com.example.alibaba.model.DomesticFly
import com.example.alibaba.model.InternationalFly
import com.example.alibaba.model.TrainStations
import com.example.test.repository.Repository
import kotlinx.coroutines.launch

class CitiesActivityViewModel (private val repository: Repository): ViewModel(){
    val myResponse : MutableLiveData<MutableList<Cities>> = MutableLiveData()
    val myResponseTrain : MutableLiveData<MutableList<TrainStations>> = MutableLiveData()
    val myResponseDomesticFly : MutableLiveData<MutableList<DomesticFly>> = MutableLiveData()
    val myResponseInternationalFly : MutableLiveData<MutableList<InternationalFly>> = MutableLiveData()

    fun listOfcities(activity : Activity){
        viewModelScope.launch {
            val response = repository.getBusStations(activity)
            myResponse.value = response
        }
    }
    fun trainCities(activity : Activity){
        viewModelScope.launch {
            val response = repository.getTrainStations(activity)
            myResponseTrain.value = response
        }
    }
    fun domesticCities(activity : Activity){
        viewModelScope.launch {
            val response = repository.getDomesticFlyCities(activity)
            myResponseDomesticFly.value = response
        }
    }
    fun internationalCities(activity : Activity){
        viewModelScope.launch {
            val response = repository.getInternationalFlyCities(activity)
            myResponseInternationalFly.value = response
        }
    }

    fun hotelDomestic(activity : Activity){
        viewModelScope.launch {
            val response = repository.getInternationalFlyCities(activity)
            myResponseInternationalFly.value = response
        }
    }


}