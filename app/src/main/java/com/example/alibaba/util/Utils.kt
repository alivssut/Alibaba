package com.example.alibaba.util

import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream


object Utils {
    fun convert(input: InputStream?): String {
        val builder = StringBuilder()
        val bis = BufferedInputStream(input)
        try {
            while (bis.available() != 0) {
                builder.append(bis.read().toChar())
            }
            bis.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return builder.toString()
    }
}