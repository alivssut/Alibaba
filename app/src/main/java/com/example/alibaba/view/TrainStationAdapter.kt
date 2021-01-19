package com.example.alibaba.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alibaba.R
import com.example.alibaba.model.Cities
import com.example.alibaba.model.TrainStations
import com.example.test.util.Constants

class TrainStationAdapter  (private val dataSet: MutableList<TrainStations>,
var activity: Activity,
var travelState: String
) :
RecyclerView.Adapter<TrainStationAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityName: TextView
        val cityIndex: TextView
        val itemLayout: RelativeLayout

        init {
            cityName = view.findViewById(R.id.cities_item_name)
            cityIndex = view.findViewById(R.id.cities_index)
            itemLayout = view.findViewById(R.id.cities_item_layout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cities_item_list, parent, false)
        return TrainStationAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text = dataSet[position].name
        holder.cityIndex.text = position.toString()
        holder.itemLayout.setOnClickListener {
            if (travelState == "destination")
                Constants.originTrainCity = dataSet[position]
            else if (travelState == "origin")
                Constants.destinationTrainCity = dataSet[position]
            activity.onBackPressed()

        }
    }
}