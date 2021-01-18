package com.example.alibaba.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alibaba.databinding.FragmentTrainBinding
import com.example.test.util.Constants
import com.example.alibaba.R

class TrainFragment  : Fragment() {
    private lateinit var binding: FragmentTrainBinding
    var roundRound : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainBinding.inflate(layoutInflater)

        Constants.originTrainCity = null
        Constants.destinationTrainCity = null
        Constants.date = null


        binding.trainSelectOrigin.setOnClickListener {
            var intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "destination")
            intent.putExtra("type", "train")
            startActivity(intent)
        }
        binding.trainSelectDestination.setOnClickListener {
            var intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "origin")
            intent.putExtra("type", "train")
            startActivity(intent)
        }
        binding.trainSelectDate.setOnClickListener {
            val intent = Intent(activity!!.baseContext, CalendarActivity::class.java)
            var count = ""
            if (roundRound)count = "2"
            else if (!roundRound)count = "1"
            intent.putExtra("count", count)
            startActivity(intent)
        }



        binding.trainBtnWent.setOnClickListener {
            if (roundRound){
                binding.trainCalendar.text = "تاریخ رفت"
                binding.trainBtnReturn.setBackgroundResource(0)
                binding.trainBtnWent.setBackgroundResource(R.color.toolbarColor)
                roundRound = false
            }
        }
        binding.trainBtnReturn.setOnClickListener {
            if (!roundRound){
                binding.trainCalendar.text = "تاریخ رفت - تاریخ برگشت"
                binding.trainBtnWent.setBackgroundResource(0)
                binding.trainBtnReturn.setBackgroundResource(R.color.toolbarColor)
                roundRound = true
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (Constants.originTrainCity != null)
            binding.trainOrigin.text = Constants.originTrainCity!!.name
        if (Constants.destinationTrainCity != null)
            binding.trainDestination.text = Constants.destinationTrainCity!!.name
        if (Constants.date != null)
            binding.trainCalendar.text = Constants.date
    }
}