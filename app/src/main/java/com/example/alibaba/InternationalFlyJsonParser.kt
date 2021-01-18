package com.example.alibaba

import com.example.alibaba.model.InternationalFly
import com.example.alibaba.util.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class InternationalFlyJsonParser {
    fun parseJson(input: InputStream?): List<InternationalFly> {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MutableList<InternationalFly> {
        try {
            jsonObject = JSONObject(jsonString)
            jsonObject = jsonObject.getJSONObject("result")
            jsonArray = jsonObject.getJSONArray("items")

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val jsCity = jsonObject.getJSONObject("city")
                val news = InternationalFly(
                    jsCity.getString("code"),
                    jsCity.getString("name"),
                    jsCity.getString("domainCode"),
                    jsCity.getJSONObject("country").getString("name"),
                    jsCity.getJSONObject("country").getString("code"),
                    jsCity.getJSONObject("country").getString("domainCode"),
                    jsonObject.getString("name")
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
        var namesList: MutableList<InternationalFly> = arrayListOf()
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}