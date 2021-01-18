package com.example.alibaba

import com.example.alibaba.model.Cities
import com.example.alibaba.model.DomesticFly
import com.example.alibaba.util.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class DomesticFlyJsonParser {
    fun parseJson(input: InputStream?): List<DomesticFly> {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MutableList<DomesticFly> {
        try {
            jsonObject = JSONObject(jsonString)
            jsonArray = jsonObject.getJSONArray("result")
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                var isPopular = false
                if (jsonObject.getString("isPopular") == "true")isPopular = true
                val news = DomesticFly(jsonObject.getString("name") , jsonObject.getString("domainCode") , isPopular )
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
        var namesList: MutableList<DomesticFly> = arrayListOf()
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}