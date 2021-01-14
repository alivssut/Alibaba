package com.example.alibaba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityTicketBinding

class TicketActivity : AppCompatActivity() {
    lateinit var binding : ActivityTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.ticketToolBar).apply {
            title = ""
        }

        setFragmwnt()
    }

    fun setFragmwnt(){
        val fragmentName: String? = intent.getStringExtra("name")

        when (fragmentName) {
            "bus" -> {
                setBusFragment()
                binding.ticketToolbarTitle.setText(R.string.busTitle)
            }
            "train" -> {
                setTrainFragment()
                binding.ticketToolbarTitle.setText(R.string.trainTitle)
            }
            "fly" -> {
                setFlyFragment()
                binding.ticketToolbarTitle.setText(R.string.flyTitle)
            }
            "tour" -> {
                setTourFragment()
                binding.ticketToolbarTitle.setText(R.string.tourTitle)
            }
            "hotel" -> {
                setHotelFragment()
                binding.ticketToolbarTitle.setText(R.string.hotelTitle)
            }
        }
    }

    fun setBusFragment() {
        val busFragment = BusFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ticket_container, busFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setTourFragment() {
        val tourFragment = TourFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ticket_container, tourFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setFlyFragment() {
        val flyFragment = FlyFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ticket_container, flyFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setHotelFragment() {
        val hotelFragment = HotelFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ticket_container, hotelFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setTrainFragment() {
        val trainFragment = TrainFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ticket_container, trainFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
