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
import com.example.alibaba.model.BannerCollection
import com.example.alibaba.model.CardCollection

class CardOneAdapter (private val dataSet: MutableList<CardCollection>, var activity: Activity) :
RecyclerView.Adapter<CardOneAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val title: TextView
        val subTitle: TextView
        val priceLabel: TextView

        init {
            image = view.findViewById(R.id.card_view_recycler_image)
            title = view.findViewById(R.id.card_view_recycler_title)
            subTitle = view.findViewById(R.id.card_view_recycler_sub_title)
            priceLabel = view.findViewById(R.id.card_view_recycler_price_label)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_one_item, parent, false)
        return CardOneAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.title.text = dataSet[position].title
            holder.subTitle.text = dataSet[position].subTitle
            holder.priceLabel.text = dataSet[position].priceLabel
            val url = dataSet[position].image
            Glide.with(activity).load(url).into(holder.image)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}