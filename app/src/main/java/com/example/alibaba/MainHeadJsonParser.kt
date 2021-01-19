package com.example.alibaba

import android.util.Log
import com.example.alibaba.model.*
import com.example.alibaba.util.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class MainHeadJsonParser {
    fun parseJson(input: InputStream?): MainPage? {
        val content: String = Utils.convert(input)
        return parseJson(content)
    }

    fun parseJson(jsonString: String): MainPage? {
        var mainPage :MainPage? = null
        var headers: MainHead? = null
        var body: MainBody? = null
        var footer: MainFooter? = null
        try {
            Log.d("ss ", jsonString)
            var mainProductItem: MutableList<MainProducts> = arrayListOf()
            var sliderCollections1: MutableList<SliderCollections> = arrayListOf()
            var secondaryProducts: SecondaryProducts? = null
            var bannerCollection: MutableList<BannerCollection> = arrayListOf()
            var sliderCollections2: MutableList<SliderCollections> = arrayListOf()

            jsonObject = JSONObject(jsonString)
            jsonObject = jsonObject.getJSONObject("result")
            var jsonBody = jsonObject.getJSONObject("body")
            var jsonFooter = jsonObject.getJSONObject("footer")
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

                } else if (i == 1) {
                    val jsonSlider1Object =
                        jsonArray.getJSONObject(i).getJSONObject("sliderCollection")
                    val jsonSlider1Array = jsonSlider1Object.getJSONArray("sliderItem")

                    for (j in 0 until jsonSlider1Array.length()) {
                        sliderCollections1.add(
                            SliderCollections(
                                jsonSlider1Array.getJSONObject(j).getString("background"),
                                jsonSlider1Array.getJSONObject(j).getString("action")
                            )
                        )
                    }

                } else if (i == 2) {
                    val jsonsecondary1Object =
                        jsonArray.getJSONObject(i).getJSONObject("secondaryProductItem")

                    secondaryProducts = SecondaryProducts(
                        jsonsecondary1Object.getString("icon"),
                        jsonsecondary1Object.getString("title"),
                        jsonsecondary1Object.getString("subtitle"),
                        jsonsecondary1Object.getString("action")
                    )
                } else if (i == 3) {
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
                } else if (i == 4) {
                    var sliderCollections2Object =
                        jsonArray.getJSONObject(i).getJSONObject("sliderCollection")
                    var slider2Array = sliderCollections2Object.getJSONArray("sliderItem")

                    for (j in 0 until slider2Array.length()) {
                        sliderCollections2.add(
                            SliderCollections(
                                slider2Array.getJSONObject(j).getString("background"),
                                slider2Array.getJSONObject(j).getString("action")
                            )
                        )
                    }

                }

            }

            headers = MainHead(
                mainProductItem,
                sliderCollections1,
                secondaryProducts!!,
                bannerCollection,
                sliderCollections2
            )

            var bodyItem = jsonBody.getJSONArray("items")

            var actionCards: ActionCard? = null
            var cardCollectionItem: MutableList<CardCollection> = arrayListOf()
            var gridCollectionItem: MutableList<GridCollection> = arrayListOf()
            var bannerCollection2Item: MutableList<BannerCollection2> = arrayListOf()

            for (i in 0 until bodyItem.length()) {
                if (i == 0) {
                    val cardObject = bodyItem.getJSONObject(i).getJSONObject("actionCard")
                    actionCards = ActionCard(
                        cardObject.getString("icon"),
                        cardObject.getString("title"),
                        cardObject.getString("subtitle"),
                        cardObject.getString("ctaTitle")
                    )
                } else if (i == 1) {
                    val cardCollectionObject =
                        bodyItem.getJSONObject(i).getJSONObject("cardCollection")
                    var cardCollectionArray = cardCollectionObject.getJSONArray("cardItem")
                    for (j in 0 until cardCollectionArray.length()) {
                        var item = cardCollectionArray.getJSONObject(j)
                        cardCollectionItem.add(
                            CardCollection(
                                item.getString("title"),
                                item.getString("subtitle"),
                                item.getString("priceLabel"),
                                item.getString("image")
                            )
                        )
                    }
                } else if (i == 2) {
                    val gridObject = bodyItem.getJSONObject(i).getJSONObject("gridCollection")
                    var gridArray = gridObject.getJSONArray("gridItem")
                    for (j in 0 until gridArray.length()) {
                        var item = gridArray.getJSONObject(j)
                        gridCollectionItem.add(
                            GridCollection(
                                item.getString("title"),
                                item.getString("image"),
                                item.getString("action")
                            )
                        )
                    }
                } else if (i == 3) {
                    val bannerObject = bodyItem.getJSONObject(i).getJSONObject("bannerCollection")
                    var bennerArray = bannerObject.getJSONArray("bannerItem2")
                    for (j in 0 until bennerArray.length()) {
                        var item = bennerArray.getJSONObject(j)
                        bannerCollection2Item.add(
                            BannerCollection2(
                                item.getString("title"),
                                item.getString("background")
                            )
                        )
                    }
                }


            }

            body = MainBody(
                actionCards!!,
                cardCollectionItem,
                gridCollectionItem,
                bannerCollection2Item
            )

            val footerItems = jsonFooter.getJSONArray("items")

            val uspCollectionItem: MutableList<UspCollection> = arrayListOf()


            for (i in 0 until footerItems.length()) {
                if (i == 0) {
                    val obj = footerItems.getJSONObject(i).getJSONObject("uspCollection")
                    val arr = obj.getJSONArray("uspItem")
                    for (j in 0 until arr.length()) {
                        var itemObjF = arr.getJSONObject(j)
                        uspCollectionItem.add(
                            UspCollection(
                                itemObjF.getString("icon"),
                                itemObjF.getString("title")
                            )
                        )
                    }
                }
            }

            footer = MainFooter(uspCollectionItem)

            mainPage = MainPage(headers , body , footer)

            return mainPage
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return mainPage
    }

    companion object {
        lateinit var jsonArray: JSONArray
        lateinit var jsonObject: JSONObject
        var namesList: MainPage? = null
    }

    init {
        var input: InputStream
        jsonArray = JSONArray()
    }
}
