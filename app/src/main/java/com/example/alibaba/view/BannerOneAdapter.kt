package com.example.alibaba.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import com.example.alibaba.R
import com.example.alibaba.model.BannerCollection
import com.example.alibaba.model.DomesticFly
import com.example.test.util.Constants

class BannerOneAdapter (
    private val dataSet: MutableList<BannerCollection>, var activity: Activity) :
    RecyclerView.Adapter<BannerOneAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val title: TextView

        init {
            image = view.findViewById(R.id.banner_item_image)
            title = view.findViewById(R.id.banner_item_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_one_item, parent, false)
        return BannerOneAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.title.text = dataSet[position].title
            val url = dataSet[position].background
            val queue = Volley.newRequestQueue(activity)
            val imageRequest = ImageRequest(
                url,

                Response.Listener { response ->

                    holder.image.setImageBitmap(response)
                },
                holder.image.width,
                holder.image.height,
                ImageView.ScaleType.FIT_XY,
                null,
                Response.ErrorListener { })
            queue.add(imageRequest)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}