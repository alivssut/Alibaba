package com.example.alibaba.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.alibaba.R
import com.example.alibaba.databinding.FragmentHomeBinding
import com.example.alibaba.factory.BusViewModeFactory
import com.example.alibaba.factory.HomeViewModelFactory
import com.example.alibaba.model.BannerCollection
import com.example.alibaba.model.SliderCollections
import com.example.alibaba.viewModel.BusViewModel
import com.example.alibaba.viewModel.HomeViewModel
import com.example.test.repository.Repository
import com.example.test.util.Constants
import kotlinx.android.synthetic.*

class HomeFragment(val toolbar: androidx.appcompat.widget.Toolbar, val title: TextView) :
    Fragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var recyclerSliderOne: ViewPager2

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val rootView: View =
//            inflater.inflate(R.layout.fragment_home, container, false)
//        recyclerSliderOne = rootView.findViewById(R.id.recycler_slider_one)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        toolbar.setBackgroundResource(R.color.toolbarColor)
        title.setText(R.string.homTitle)

        setRegisterFragment()

        setSliderOne()
        setBanner()


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
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "bus")
            startActivity(intent)
        }
        binding.homeBusDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "bus")
            startActivity(intent)
        }

        binding.homeFlyAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "fly")
            startActivity(intent)
        }
        binding.homeFlyDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "fly")
            startActivity(intent)
        }

        binding.homeTrainAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "train")
            startActivity(intent)
        }
        binding.homeTrainDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "train")
            startActivity(intent)
        }

        binding.homeTourAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "tour")
            startActivity(intent)
        }
        binding.homeTourDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "tour")
            startActivity(intent)
        }

        binding.homeHotelAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "hotel")
            startActivity(intent)
        }
        binding.homeHotelDrawerAction.setOnClickListener {
            val intent = Intent(activity!!.baseContext, TicketActivity::class.java)
            intent.putExtra("name", "hotel")
            startActivity(intent)
        }


//        Toast.makeText(activity!!.baseContext, Constants.c, Toast.LENGTH_LONG).show()

//        val repository = Repository("mobile/applications/159/page/home?headerVersion=0&bodyVersion=0&footerVersion=0", "")
//        val viewModelFactory = HomeViewModelFactory(repository)
//
//        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
//
//
//        viewModel.getDetails(activity!!)
//
//        viewModel.myResponse.observe(activity!!, Observer { response ->
//
//
//        })

        return binding.root
    }

    fun setIcon(){

    }

    fun setBanner(){

        var items : MutableList<BannerCollection> = arrayListOf()
        items = Constants.mainPage!!.mainHead.bannerCollection
        val adapter  = BannerOneAdapter(items , activity!!)
        binding.homeRecyclerBanner.setItemAnimator(DefaultItemAnimator())
        val layoutManager = LinearLayoutManager(activity!!.baseContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.homeRecyclerBanner.layoutManager = layoutManager
        binding.homeRecyclerBanner.adapter = adapter
    }

    fun setSliderOne() {
        var items: MutableList<SliderCollections> = arrayListOf()
        items = Constants.mainPage!!.mainHead.sliderCollections

        val adapter = ViewPagerSliderOneAdapter(items, activity!!)

        binding.recyclerSliderOne.adapter = adapter
//        circleIndicator3.setViewPager(viewPager)
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