package com.example.alibaba

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.alibaba.databinding.ActivityMainBinding
import com.example.alibaba.databinding.FragmentHomeBinding

class HomeFragment(val toolbar: androidx.appcompat.widget.Toolbar, val title: TextView) :
    Fragment() {
    private lateinit var binding: FragmentHomeBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        toolbar.setBackgroundResource(R.color.toolbarColor)
        title.setText(R.string.homTitle)

        setRegisterFragment()

        binding.homeScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            when {
                scrollY in 360..530 -> {
                    binding.homeTicketItemDrawer.translationY = (scrollY - 530).toFloat()
                }
                scrollY > 530 -> {
                    binding.homeTicketItemDrawer.translationY = 0F
                }
                scrollY < 360 -> {
                    binding.homeTicketItemDrawer.translationY = (-180).toFloat()
                }
            }

            when {
                scrollY < 80 -> {
                    toolbar.setBackgroundResource(R.color.actionbarFirst)
                    binding.homeBackgroundChange.setBackgroundResource(R.color.actionbarFirst)
                }
                scrollY < 160 -> {
                    toolbar.setBackgroundResource(R.color.actionbarSecond)
                    binding.homeBackgroundChange.setBackgroundResource(R.color.actionbarSecond)
                }
                scrollY < 240 -> {
                    toolbar.setBackgroundResource(R.color.actionbarThird)
                    binding.homeBackgroundChange.setBackgroundResource(R.color.actionbarThird)
                }
                scrollY < 300 -> {
                    toolbar.setBackgroundResource(R.color.actionbarForth)
                    binding.homeBackgroundChange.setBackgroundResource(R.color.actionbarForth)
                }
                scrollY < 360 -> {
                    toolbar.setBackgroundResource(R.color.actionbarFifth)
                    binding.homeBackgroundChange.setBackgroundResource(R.color.actionbarFifth)
                }
            }
        }

        binding.homeBusAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }
        binding.homeBusDrawerAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }

        binding.homeFlyAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }
        binding.homeFlyDrawerAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }

        binding.homeTrainAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }
        binding.homeTrainDrawerAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }

        binding.homeTourAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }
        binding.homeTourDrawerAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }

        binding.homeHotelAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }
        binding.homeHotelDrawerAction.setOnClickListener {
            startActivity(Intent(activity!!.baseContext , TicketActivity::class.java))
        }

        return binding.root
    }

    fun setRegisterFragment() {
        var registerFragment = RegisterFragment()
        val fragmentManager: FragmentManager = getFragmentManager()!!
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_register_container, registerFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}