package com.example.alibaba

import com.example.alibaba.model.Cities
import com.example.alibaba.model.Tickets
import com.example.alibaba.util.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class TicketsJsonParser {
    fun parseJson(input: InputStream?): List<Tickets> {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MutableList<Tickets> {
        try {
            jsonObject = JSONObject(jsonString)
            jsonArray = jsonObject.getJSONArray("result")
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val news = Tickets(jsonObject.getString("departureDate") ,
                    jsonObject.getString("busType"),
                    jsonObject.getString("orginCityName"),
                    jsonObject.getString("destinationCityName"),
                    jsonObject.getString("price"),
                    jsonObject.getString("availableSeats"),
                    jsonObject.getString("orginTerminal")
                )
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
        var namesList: MutableList<Tickets> = arrayListOf()
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}