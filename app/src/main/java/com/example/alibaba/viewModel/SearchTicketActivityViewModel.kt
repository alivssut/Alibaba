package com.example.alibaba.viewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alibaba.model.Tickets
import com.example.test.repository.Repository
import kotlinx.coroutines.launch

class SearchTicketActivityViewModel (private val repository: Repository): ViewModel(){
    val myResponse : MutableLiveData<MutableList<Tickets>> = MutableLiveData()

    fun listOfTickets(activity : Activity){
        viewModelScope.launch {
            val response = repository.sendTicketRequest(activity)
            myResponse.value = response
        }
    }
    fun trainParametersRequest(activity : Activity){
        viewModelScope.launch {
            val response = repository.sendTicketRequest(activity)
            myResponse.value = response
        }
    }

}