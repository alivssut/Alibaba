package com.example.alibaba.viewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alibaba.model.Cities
import com.example.alibaba.model.MainHead
import com.example.test.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: Repository): ViewModel(){
    val myResponse : MutableLiveData<MutableList<MainHead>> = MutableLiveData()

    fun getDetails(activity : Activity){
        viewModelScope.launch {
            val response = repository.getMainDetails(activity)
            myResponse.value = response
        }
    }

}