package com.example.alibaba.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.alibaba.R
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
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "bus")
            startActivity(intent)
        }
        binding.homeBusDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "bus")
            startActivity(intent)
        }

        binding.homeFlyAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "fly")
            startActivity(intent)
        }
        binding.homeFlyDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "fly")
            startActivity(intent)
        }

        binding.homeTrainAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "train")
            startActivity(intent)
        }
        binding.homeTrainDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "train")
            startActivity(intent)
        }

        binding.homeTourAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "tour")
            startActivity(intent)
        }
        binding.homeTourDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "tour")
            startActivity(intent)
        }

        binding.homeHotelAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "hotel")
            startActivity(intent)
        }
        binding.homeHotelDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext , TicketActivity::class.java)
            intent.putExtra("name" , "hotel")
            startActivity(intent)
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