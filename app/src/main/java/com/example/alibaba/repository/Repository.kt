package com.example.test.repository

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.alibaba.*
import com.example.alibaba.model.*
import com.example.alibaba.view.*
import com.example.test.util.Constants

class Repository(private val url: String, var state: String) {
    //    var adapter: CitiesAdapter? = null
    var recyclerView: RecyclerView? = null
    var liveData: MutableLiveData<MutableList<Cities>> = MutableLiveData()

    interface Iconnect {
        fun set()
    }

    suspend fun getBusStations(activity: Activity): MutableList<Cities> {
        var list: MutableList<Cities> = arrayListOf()
        try {
            val path =
                Constants.BASE_URL + url
            val queue = Volley.newRequestQueue(activity)
            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
                    val citiesJsonParser = CitiesJsonParser()
                    list = arrayListOf()
                    list = citiesJsonParser.parseJson(response)

                    Constants.citiesList = list
                    liveData.value = list

                    val adapter = CitiesAdapter(list, activity, state)
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    val layoutManager: RecyclerView.LayoutManager =
                        LinearLayoutManager(activity)
                    recyclerView!!.layoutManager = layoutManager
                    recyclerView!!.adapter = adapter

                },
                Response.ErrorListener { error ->
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                    Log.i("error ====>: ", error.toString())
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG).show()

                }
            ) {}
            queue.add(request)
        } catch (e: Exception) {
            Toast.makeText(activity.baseContext, e.message.toString(), Toast.LENGTH_LONG).show()
        }
        return Constants.citiesList
    }

    suspend fun getTrainStations(activity: Activity): MutableList<TrainStations> {
        var list: MutableList<TrainStations> = arrayListOf()
        try {
            val path =
                Constants.BASE_URL + url
            val queue = Volley.newRequestQueue(activity)
            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
                    val trainStationJsonParser = TrainStationJsonParser()
                    list = arrayListOf()
                    list = trainStationJsonParser.parseJson(response)


                    val adapter = TrainStationAdapter(list, activity, state)
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    val layoutManager: RecyclerView.LayoutManager =
                        LinearLayoutManager(activity)
                    recyclerView!!.layoutManager = layoutManager
                    recyclerView!!.adapter = adapter

                },
                Response.ErrorListener { error ->
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                    Log.i("error ====>: ", error.toString())
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG).show()

                }
            ) {}
            queue.add(request)
        } catch (e: Exception) {
            Toast.makeText(activity.baseContext, e.message.toString(), Toast.LENGTH_LONG).show()
        }
        return list
    }

    suspend fun getDomesticFlyCities(activity: Activity): MutableList<DomesticFly> {
        var list: MutableList<DomesticFly> = arrayListOf()
        try {
            val path =
                Constants.BASE_URL + url
            val queue = Volley.newRequestQueue(activity)
            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
                    Toast.makeText(activity.baseContext, "res", Toast.LENGTH_LONG).show()
                    val domesticFlyJsonParser = DomesticFlyJsonParser()
                    list = arrayListOf()
                    list = domesticFlyJsonParser.parseJson(response)


                    val adapter = DomesticFlyAdapter(list, activity, state)
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    val layoutManager: RecyclerView.LayoutManager =
                        LinearLayoutManager(activity)
                    recyclerView!!.layoutManager = layoutManager
                    recyclerView!!.adapter = adapter

                },
                Response.ErrorListener { error ->
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                    Log.i("error ====>: ", error.toString())
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG).show()

                }
            ) {}
            queue.add(request)
        } catch (e: Exception) {
            Toast.makeText(activity.baseContext, e.message.toString(), Toast.LENGTH_LONG).show()
        }
        return list
    }

    suspend fun getInternationalFlyCities(activity: Activity): MutableList<InternationalFly> {
        var list: MutableList<InternationalFly> = arrayListOf()
        try {
            val path =
                Constants.BASE_URL + url
            val queue = Volley.newRequestQueue(activity)
            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
                    Log.d("fly ", response.toString())
                    val internationalFlyJsonParser = InternationalFlyJsonParser()
                    list = arrayListOf()
                    list = internationalFlyJsonParser.parseJson(response)


                    val adapter = InternationalFlyAdapter(list, activity, state)
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    val layoutManager: RecyclerView.LayoutManager =
                        LinearLayoutManager(activity)
                    recyclerView!!.layoutManager = layoutManager
                    recyclerView!!.adapter = adapter

                },
                Response.ErrorListener { error ->
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                    Log.i("error ====>: ", error.toString())
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG).show()

                }
            ) {}
            queue.add(request)
        } catch (e: Exception) {
            Toast.makeText(activity.baseContext, e.message.toString(), Toast.LENGTH_LONG).show()
        }
        return list
    }

    suspend fun getMainDetails(activity: Activity): MutableList<MainHead> {
        var list: MutableList<MainHead> = arrayListOf()
        try {
            val path =
                Constants.BASE_URL + url
            val queue = Volley.newRequestQueue(activity)
            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
                    Log.d("fly ", response.toString())
                    Constants.a = response
                    (activity as? Iconnect)?.set()


                },
                Response.ErrorListener { error ->
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                    Log.i("error ====>: ", error.toString())
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG).show()

                }
            ) {}
            queue.add(request)
        } catch (e: Exception) {
            Toast.makeText(activity.baseContext, e.message.toString(), Toast.LENGTH_LONG).show()
        }
        return list
    }


    suspend fun sendTicketRequest(activity: Activity): MutableList<Tickets> {
        var list: MutableList<Tickets> = arrayListOf()
        try {
            val queue = Volley.newRequestQueue(activity)

            val path =
                Constants.BASE_URL + url

            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
                    Log.d("sown", response.toString())
//                    Toast.makeText(activity.baseContext, response.toString().substring(10 , 20), Toast.LENGTH_LONG).show()

                    val ticketsJsonParser = TicketsJsonParser()
                    list = ticketsJsonParser.parseJson(response)

//                    Constants.citiesList = list
//                    liveData.value = list

                    val adapter = TicketsAdapter(list)
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    val layoutManager: RecyclerView.LayoutManager =
                        LinearLayoutManager(activity)
                    recyclerView!!.layoutManager = layoutManager
                    recyclerView!!.adapter = adapter

                },
                Response.ErrorListener { error ->
                    Toast.makeText(activity.baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                    Log.i("error ====>: ", error.toString())
                }
            ) {}
            queue.add(request)
        } catch (e: Exception) {
            Toast.makeText(activity.baseContext, e.message.toString(), Toast.LENGTH_LONG).show()
        }
        return list
    }


}