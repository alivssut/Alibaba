package com.example.test.repository

//import com.example.test.api.RetrofitInstance
//import com.example.test.model.Post
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.alibaba.CitiesJsonParser
import com.example.alibaba.TicketsJsonParser
import com.example.alibaba.model.Cities
import com.example.alibaba.model.Tickets
import com.example.alibaba.view.CitiesAdapter
import com.example.alibaba.view.TicketsAdapter
import com.example.test.util.Constants
import kotlinx.coroutines.channels.ticker
import org.json.JSONException
import org.json.JSONObject

class Repository(private val url: String, var state: String) {
    //    var adapter: CitiesAdapter? = null
    var recyclerView: RecyclerView? = null
    var liveData: MutableLiveData<MutableList<Cities>> = MutableLiveData()

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
                    Log.d("sown" , response.toString())
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