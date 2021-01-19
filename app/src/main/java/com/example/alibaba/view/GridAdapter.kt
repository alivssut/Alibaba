package com.example.alibaba.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.alibaba.R
import com.example.alibaba.model.CardCollection
import com.example.alibaba.model.GridCollection

class GridAdapter (private val dataSet: MutableList<GridCollection>, var activity: Activity) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val title: TextView

        init {
            image = view.findViewById(R.id.grid_item_image)
            title = view.findViewById(R.id.grid_item_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)
        return GridAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.title.text = dataSet[position].title
            val url = dataSet[position].image
            Glide.with(activity).load(url).into(holder.image)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}