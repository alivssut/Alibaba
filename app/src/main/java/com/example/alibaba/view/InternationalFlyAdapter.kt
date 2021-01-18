package com.example.alibaba.view

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alibaba.R
import com.example.alibaba.model.DomesticFly
import com.example.alibaba.model.InternationalFly
import com.example.test.util.Constants

class InternationalFlyAdapter (
    private val dataSet: MutableList<InternationalFly>, var activity: Activity,
    var travelState: String
) :
    RecyclerView.Adapter<InternationalFlyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityName: TextView
        val countryName: TextView
        val itemLayout: LinearLayout

        init {
            cityName = view.findViewById(R.id.international_fly_city_name)
            countryName = view.findViewById(R.id.international_fly_country)
            itemLayout = view.findViewById(R.id.international_fly_layout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.international_fly_list_item, parent, false)
        return InternationalFlyAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text = "${dataSet[position].name}, ${dataSet[position].countryName} - ${dataSet[position].airportName}"
        holder.countryName.text = dataSet[position].countryName
        holder.itemLayout.setOnClickListener {
            if (travelState == "origin")
                Constants.originInternationalCity = dataSet[position]
            else if (travelState == "destination")
                Constants.destinationInternationalCity = dataSet[position]
            activity.onBackPressed()

        }
    }
}