package com.example.test.repository

//import com.example.test.api.RetrofitInstance
//import com.example.test.model.Post
import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.alibaba.view.CitiesAdapter
import com.example.alibaba.CitiesJsonParser
import com.example.alibaba.model.Cities
import com.example.test.util.Constants

class Repository (private val url: String){
//    var adapter: CitiesAdapter? = null
    var recyclerView : RecyclerView? = null

    suspend fun getBusStations(activity: Activity): MutableList<Cities> {
        var list: MutableList<Cities> = arrayListOf()
        var liveData : MutableLiveData<MutableList<Cities>> = MutableLiveData()
        try {
            val path =
                Constants.BASE_URL + url
            val queue = Volley.newRequestQueue(activity.baseContext)
            val request: StringRequest = object : StringRequest(
                Method.GET,
                path,
                Response.Listener { response ->
//                    list =
                    Log.i("response", "download is success")
                    val citiesJsonParser = CitiesJsonParser()
                    list = citiesJsonParser.parseJson(response)

                    Constants.citiesList = list
                    liveData.value =  list

                    val adapter = CitiesAdapter(list)
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    val layoutManager: RecyclerView.LayoutManager =
                        LinearLayoutManager(activity)
                    recyclerView!!.layoutManager = layoutManager
                    recyclerView!!.adapter = adapter

                    Log.d("data : " , list.size.toString())
                    Log.d("data : " , response.toString())

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
}