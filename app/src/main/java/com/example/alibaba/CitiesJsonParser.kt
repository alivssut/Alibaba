package com.example.alibaba

import android.util.Log
import com.example.alibaba.model.BusStations
import com.example.alibaba.model.Cities
import com.example.alibaba.util.Utils
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class CitiesJsonParser {
    fun parseJson(input: InputStream?): List<Cities> {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MutableList<Cities> {
        try {
            jsonObject = JSONObject(jsonString)
            jsonObject = jsonObject.getJSONObject("result")
            jsonArray = jsonObject.getJSONArray("items")
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val news = Cities(jsonObject.getString("code") , jsonObject.getString("name"))
                namesList.add(news)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return namesList
    }

    companion object {
        lateinit var jsonArray: JSONArray
        lateinit var jsonObject: JSONObject
        var namesList: MutableList<Cities> = arrayListOf()
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}