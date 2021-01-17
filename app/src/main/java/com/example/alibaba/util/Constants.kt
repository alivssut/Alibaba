package com.example.test.util

import com.example.alibaba.model.Cities
import com.example.alibaba.model.TicketRequest

class Constants {
    companion object{
        const val BASE_URL = "https://ws.alibaba.ir/api/v1/"
        var citiesList : MutableList<Cities> = arrayListOf()

        val orogin : String? = null
        val destination : String? = null

        var originCity : Cities? = null
        var destinationCity : Cities? = null
        var date : String? = null

        var requesForData : TicketRequest? = null
    }
}