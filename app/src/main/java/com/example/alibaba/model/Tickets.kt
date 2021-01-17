package com.example.alibaba.model

class Tickets(

    var departureDate : String,
    var busType : String,
    var orginCityName : String,
    var destinationCityName : String,
    var price : String,
    var availableSeats : String,
    var orginTerminal : String


){
    var departureTime : String? = null
    var departureDateTime : String? = null
    var beforeDiscountPrice : String? = null
    var description : String? = null
    var proposalId: String? = null
    var companyName: String? = null
    var companyCode: String? = null
    var companyToken : String? = null
    var droppingPoints : String? = null
    var supplier : String? = null
    var distance : String? = null
    var originCityCode : String? = null
    var destinationCityCode : String ? = null
    var uniqueServiceToken : String? = null
    var hasSpecialOffer : String? = null
    var beforeSpecialOfferPrice : String? = null
    var isRefundable : String? = null
    var destinationTerminal : String? = null
}