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
import com.example.alibaba.model.TrainTicket

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
        Constants.trainTicket = null


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
                binding.trainBtnReturn.setBackgroundResource(R.color.toolbarWhite)
                binding.trainBtnWent.setBackgroundResource(R.color.toolbarColor)
                binding.trainOrigin.text = "مبدا"
                binding.trainDestination.text = "مقصد"
                Constants.originTrainCity = null
                Constants.destinationTrainCity = null
                Constants.date = null
                Constants.trainTicket = null
                roundRound = false
            }
        }
        binding.trainBtnReturn.setOnClickListener {
            if (!roundRound){
                binding.trainCalendar.text = "تاریخ رفت - تاریخ برگشت"
                binding.trainBtnWent.setBackgroundResource(R.color.toolbarWhite)
                binding.trainBtnReturn.setBackgroundResource(R.color.toolbarColor)
                binding.trainOrigin.text = "مبدا"
                binding.trainDestination.text = "مقصد"
                Constants.originTrainCity = null
                Constants.destinationTrainCity = null
                Constants.date = null
                Constants.trainTicket = null
                roundRound = true
            }
        }

        binding.trainBtnSearch.setOnClickListener {
            if (Constants.originTrainCity != null && Constants.destinationTrainCity != null && Constants.date != null) {
               var countP = Constants.trainChild + Constants.trainAdult + Constants.trainInfant
                Constants.trainTicket = TrainTicket(
                    Constants.trainAdult ,
                    Constants.trainChild ,
                    Constants.date!! ,
                    Constants.destinationTrainCity!!.domainCode ,
                    Constants.trainInfant ,
                    Constants.trainIsExclusiveCompartment ,
                    Constants.originTrainCity!!.domainCode ,
                    countP,
                    "family"
                )
                val intent = Intent(activity!!.baseContext, SearchTicketActivity::class.java)
                intent.putExtra("type", "train")
                startActivity(intent)
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