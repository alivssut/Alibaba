package com.example.test.util

import com.example.alibaba.model.Cities

class Constants {
    companion object{
        const val BASE_URL = "https://ws.alibaba.ir/api/v1/"
        var citiesList : MutableList<Cities> = arrayListOf()

        val orogin : String? = null
        val destination : String? = null

        val originCity : Cities? = null
        val destinationCity : Cities? = null
        val date : String? = null
    }
}