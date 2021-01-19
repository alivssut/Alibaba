package com.example.alibaba.view

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import com.example.alibaba.R
import com.example.alibaba.model.SliderCollections

class ViewPagerSliderOneAdapter (var dataset: MutableList<SliderCollections>, var activity: Activity) :
    RecyclerView.Adapter<ViewPagerSliderOneAdapter.PagerViewModel>() {

    inner class PagerViewModel(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView

        init {
            image = itemView.findViewById(R.id.view_pager_one_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewModel {
        return PagerViewModel(LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item_one_xml  ,parent , false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: PagerViewModel, position: Int) {
        try {
            val url = dataset[position].background
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