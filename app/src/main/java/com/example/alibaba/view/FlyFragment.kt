package com.example.alibaba.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.R
import com.example.alibaba.databinding.FragmentFlyBinding
import com.example.test.util.Constants

class FlyFragment : Fragment() {
    private lateinit var binding: FragmentFlyBinding
    var roundRound: Boolean = false
    var domestic: Boolean = true

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlyBinding.inflate(layoutInflater)


        Constants.originDomesticCity = null
        Constants.destinationDomesticCity = null
        Constants.date = null

        binding.plainSelectOrigin.setOnClickListener {
            var intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "origin")
            var flyTo = ""
            if (domestic) flyTo = "domestic"
            else flyTo = "international"
            intent.putExtra("type", flyTo)
            startActivity(intent)
        }
        binding.plainSelectDestination.setOnClickListener {
            var intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "destination")
            var flyTo = ""
            if (domestic) flyTo = "domestic"
            else flyTo = "international"
            intent.putExtra("type", flyTo)
            startActivity(intent)
        }
        binding.plainSelectDate.setOnClickListener {
            val intent = Intent(activity!!.baseContext, CalendarActivity::class.java)
            var count = ""
            if (roundRound) count = "2"
            else if (!roundRound) count = "1"
            intent.putExtra("count", count)
            startActivity(intent)
        }



        binding.plainBtnWent.setOnClickListener {
            if (roundRound) {
                binding.plainCalendar.text = "تاریخ رفت"
                binding.plainBtnReturn.setBackgroundResource(R.color.toolbarWhite)
                binding.plainBtnWent.setBackgroundResource(R.color.toolbarColor)
                roundRound = false
            }
        }
        binding.plainBtnReturn.setOnClickListener {
            if (!roundRound) {
                binding.plainCalendar.text = "تاریخ رفت - تاریخ برگشت"
                binding.plainBtnWent.setBackgroundResource(R.color.toolbarWhite)
                binding.plainBtnReturn.setBackgroundResource(R.color.toolbarColor)
                roundRound = true
            }
        }


        binding.plainDomestic.setOnClickListener {
            if (!domestic) {
                binding.plainDomesticText.setTextColor(Color.parseColor("#000000"))
                binding.plainInternationalText.setTextColor(Color.parseColor("#8F8F8F"))
                domestic = true
            }
        }
        binding.plainInternational.setOnClickListener {
            if (domestic) {
                binding.plainDomesticText.setTextColor(Color.parseColor("#8F8F8F"))
                binding.plainInternationalText.setTextColor(Color.parseColor("#000000"))
                domestic = false
            }
        }

        return binding.root
    }

    fun setValue(){

    }

    override fun onResume() {
        super.onResume()
        if (domestic) {
            if (Constants.originDomesticCity != null)
                binding.plainOrigin.text = Constants.originDomesticCity!!.name
            if (Constants.destinationDomesticCity != null)
                binding.plainDestination.text = Constants.destinationDomesticCity!!.name
            if (Constants.date != null)
                binding.plainCalendar.text = Constants.date
        }else{
            if (Constants.originInternationalCity != null)
                binding.plainOrigin.text = Constants.originInternationalCity!!.name
            if (Constants.destinationInternationalCity != null)
                binding.plainDestination.text = Constants.destinationInternationalCity!!.name
            if (Constants.date != null)
                binding.plainCalendar.text = Constants.date
        }
    }
}