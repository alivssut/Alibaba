package com.example.alibaba.view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alibaba.R
import com.example.alibaba.model.Cities
import com.example.alibaba.model.Tickets
import com.example.test.util.Constants

class TicketsAdapter(
    private val dataSet: MutableList<Tickets>) :
    RecyclerView.Adapter<TicketsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val busType: TextView
        val orginCityName: TextView
        val destinationCityName: TextView
        val price: TextView
        val availableSeats: TextView
        val orginTerminal: TextView

        init {
            busType = view.findViewById(R.id.ticket_item_bus_type)
            orginCityName = view.findViewById(R.id.ticket_item_company_name)
            destinationCityName = view.findViewById(R.id.ticket_item_destination_city_name)
            price = view.findViewById(R.id.ticket_item_price)
            availableSeats = view.findViewById(R.id.ticket_item_available_seats)
            orginTerminal = view.findViewById(R.id.ticket_item_origin_terminal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_list_item, parent, false)
        return TicketsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.busType.text = dataSet[position].busType
        holder.orginCityName.text = dataSet[position].orginCityName
        holder.destinationCityName.text = dataSet[position].destinationCityName
        holder.price.text = dataSet[position].price
        holder.availableSeats.text = dataSet[position].availableSeats
        holder.orginTerminal.text = dataSet[position].orginTerminal
    }

}