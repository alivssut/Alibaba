package com.example.alibaba.model

class BusStations(
    private val code : String,
    private val name : String ,
    private val displayName: Array<Array<String>> = Array(2){Array(2){""}}
) {
}