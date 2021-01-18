package com.example.test.util

import com.example.alibaba.model.*

class Constants {
    companion object{
        const val BASE_URL = "https://ws.alibaba.ir/api/v1/"
        var citiesList : MutableList<Cities> = arrayListOf()

        val orogin : String? = null
        val destination : String? = null

        var originTrainCity : TrainStations? = null
        var destinationTrainCity : TrainStations? = null

        var originDomesticCity : DomesticFly? = null
        var destinationDomesticCity : DomesticFly? = null

        var originInternationalCity : InternationalFly? = null
        var destinationInternationalCity : InternationalFly? = null

        var originCity : Cities? = null
        var destinationCity : Cities? = null
        var date : String? = null

        var requesForData : TicketRequest? = null
    }
}