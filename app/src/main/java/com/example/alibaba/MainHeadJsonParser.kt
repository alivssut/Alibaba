package com.example.alibaba

import android.util.Log
import com.example.alibaba.model.*
import com.example.alibaba.util.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class MainHeadJsonParser {
    fun parseJson(input: InputStream?): MainHead? {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MainHead? {
        var headers: MainHead? = null
        try {
            Log.d("ss " , jsonString)
            var mainProductItem: MutableList<MainProducts> = arrayListOf()
            var sliderCollections1: MutableList<SliderCollections> = arrayListOf()
            var secondaryProducts: SecondaryProducts? = null
            var bannerCollection: MutableList<BannerCollection> = arrayListOf()
            var sliderCollections2: MutableList<SliderCollections> = arrayListOf()
            jsonObject = JSONObject(jsonString)
            jsonObject = jsonObject.getJSONObject("result")
            jsonObject = jsonObject.getJSONObject("header")
            jsonArray = jsonObject.getJSONArray("items")


            for (i in 0 until jsonArray.length()) {
                if (i == 0) {
                    val jsObject = jsonArray.getJSONObject(i).getJSONObject("mainProducts")
                    val jsProductArray = jsObject.getJSONArray("mainProductItem")

                    for (j in 0 until 2) {
                        val jsPRow = jsProductArray.getJSONArray(j)
                        for (k in 0 until jsPRow.length()) {
                            mainProductItem.add(
                                MainProducts(
                                    jsPRow.getJSONObject(k).getString("icon"),
                                    jsPRow.getJSONObject(k).getString("title")
                                )
                            )
                        }


                    }

                }else if (i == 1) {
                    val jsonSlider1Object = jsonArray.getJSONObject(i).getJSONObject("sliderCollection")
                    val jsonSlider1Array = jsonSlider1Object.getJSONArray("sliderItem")

                    for (j in 0 until jsonSlider1Array.length()) {
                        sliderCollections1.add(SliderCollections(
                                jsonSlider1Array.getJSONObject(j).getString("background"),
                                jsonSlider1Array.getJSONObject(j).getString("action")
                            )
                        )
                    }

                }else if (i == 2) {
                    val jsonsecondary1Object = jsonArray.getJSONObject(i).getJSONObject("secondaryProductItem")

                    secondaryProducts = SecondaryProducts(
                        jsonsecondary1Object.getString("icon"),
                        jsonsecondary1Object.getString("title"),
                        jsonsecondary1Object.getString("subtitle"),
                        jsonsecondary1Object.getString("action")
                    )
                }else if (i == 3) {
                    var bannerObject = jsonArray.getJSONObject(i).getJSONObject("bannerCollection")
                    var bannerArray = bannerObject.getJSONArray("bannerItem2")

                    for (j in 0 until bannerArray.length()) {
                        bannerCollection.add(
                            BannerCollection(
                                bannerArray.getJSONObject(j).getString("title"),
                                bannerArray.getJSONObject(j).getString("background")
                            )
                        )
                    }
                }else if (i == 4){
                    var sliderCollections2Object = jsonArray.getJSONObject(i).getJSONObject("sliderCollection")
                    var slider2Array = sliderCollections2Object.getJSONArray("sliderItem")

                    for (j in 0 until slider2Array.length()){
                        sliderCollections2.add(
                            SliderCollections(
                                slider2Array.getJSONObject(j).getString("background"),
                                slider2Array.getJSONObject(j).getString("action")
                        )
                        )
                    }

                }

            }

            headers = MainHead(mainProductItem , sliderCollections1 , secondaryProducts!! , bannerCollection , sliderCollections2)

            return headers
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return headers
    }

    companion object {
        lateinit var jsonArray: JSONArray
        lateinit var jsonObject: JSONObject
        var namesList: MainHead? = null
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}
