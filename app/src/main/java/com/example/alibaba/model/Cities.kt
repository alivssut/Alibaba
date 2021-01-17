package com.example.alibaba.model

class Cities(
    val code : String,
    val name : String ,
    val displayName: Array<Array<String>> = Array(2){Array(2){""}}
)