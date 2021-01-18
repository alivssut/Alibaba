package com.example.alibaba

import com.example.alibaba.model.Tickets
import com.example.alibaba.model.TrainStations
import com.example.alibaba.util.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class TrainStationJsonParser {
    fun parseJson(input: InputStream?): List<TrainStations> {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MutableList<TrainStations> {
        try {
            jsonObject = JSONObject(jsonString)
            jsonObject = jsonObject.getJSONObject("result")
            jsonArray = jsonObject.getJSONArray("items")
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val news = TrainStations(
                    jsonObject.getString("code") ,
                    jsonObject.getString("name"),
                    jsonObject.getString("domainCode"),
                    jsonObject.getString("trainDomainCode")
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
        var namesList: MutableList<TrainStations> = arrayListOf()
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}