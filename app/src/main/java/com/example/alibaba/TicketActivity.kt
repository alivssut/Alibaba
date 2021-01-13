package com.example.alibaba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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

        setBusFragment()
    }

    fun setBusFragment() {
        var busFragment = BusFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ticket_container, busFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
