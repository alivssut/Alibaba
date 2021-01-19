package com.example.alibaba.view

import android.annotation.SuppressLint
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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.alibaba.R
import com.example.alibaba.databinding.FragmentHomeBinding
import com.example.alibaba.factory.BusViewModeFactory
import com.example.alibaba.factory.HomeViewModelFactory
import com.example.alibaba.model.*
import com.example.alibaba.viewModel.BusViewModel
import com.example.alibaba.viewModel.HomeViewModel
import com.example.test.repository.Repository
import com.example.test.util.Constants
import kotlinx.android.synthetic.*

class HomeFragment(val toolbar: androidx.appcompat.widget.Toolbar, val title: TextView) :
    Fragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    @SuppressLint("ResourceAsColor")
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

        setIcon()
        setFooter()
        setSliderOne()
        setBanner()
        setSliderTwo()
        setCardCollection()
        setGridCollection()
        setBanner2()
        setHeadSecondary()


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
                scrollY > 360 ->{
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


        return binding.root
    }

    fun setIcon(){
        val item = Constants.mainPage!!.mainHead.mainProducts
        for (i in 0 until item.size){
            when (item[i].title) {
                "اتوبوس" -> {
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeBusAction)
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeBusDrawerAction)
                }
                "قطار" -> {
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeTrainAction)
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeTrainDrawerAction)
                }
                "پرواز" -> {
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeFlyAction)
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeFlyDrawerAction)
                }
                "هتل" -> {
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeHotelAction)
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeHotelDrawerAction)
                }
                "تور" -> {
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeTourAction)
                    Glide.with(activity!!).load(item[i].icon).into(binding.homeTourDrawerAction)
                }
            }
        }
    }

    fun setHeadSecondary(){
       val item = Constants.mainPage!!.mainHead.secondaryProducts
        Glide.with(activity!!).load(item.icon).into(binding.homeIconSpeaker)

    }

    fun setFooter(){
        val item = Constants.mainPage!!.mainFooter.uspCollectionItem
        Glide.with(activity!!).load(item[0].icon).into(binding.homeFooter1Icon)
        binding.homeFooter1Text.text = item[0].title
        Glide.with(activity!!).load(item[1].icon).into(binding.homeFooter2Icon)
        binding.homeFooter2Text.text = item[1].title
        Glide.with(activity!!).load(item[2].icon).into(binding.homeFooter3Icon)
        binding.homeFooter3Text.text = item[2].title
    }

    fun setBanner(){

        var items : MutableList<BannerCollection> = arrayListOf()
        items = Constants.mainPage!!.mainHead.bannerCollection
        val adapter  = BannerOneAdapter(items , activity!!)
        binding.homeRecyclerBanner.setItemAnimator(DefaultItemAnimator())
        val layoutManager = LinearLayoutManager(activity!!.baseContext)
        layoutManager.reverseLayout = true
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

    fun setSliderTwo(){
        var items: MutableList<SliderCollections> = arrayListOf()
        items = Constants.mainPage!!.mainHead.sliderCollections2

        val adapter = ViewPagerSliderOneAdapter(items, activity!!)

        binding.recyclerSliderTwo.adapter = adapter
    }

    fun setCardCollection(){
        var items : MutableList<CardCollection> = arrayListOf()
        items = Constants.mainPage!!.mainBody.cardCollectionItem
        val adapter  = CardOneAdapter(items , activity!!)
        binding.homeRecyclerBanner.setItemAnimator(DefaultItemAnimator())
        val layoutManager = LinearLayoutManager(activity!!.baseContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.reverseLayout = true
        binding.homeRecyclerCard.layoutManager = layoutManager
        binding.homeRecyclerCard.adapter = adapter
    }

    fun setGridCollection(){
        var items : MutableList<GridCollection> = arrayListOf()
        items = Constants.mainPage!!.mainBody.GridCollectionItem
        val adapter  = GridAdapter(items , activity!!)
        binding.homeRecyclerBanner.setItemAnimator(DefaultItemAnimator())
        val layoutManager = GridLayoutManager(activity!!.baseContext , 2)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.homeRecyclerGrid.layoutManager = layoutManager
        binding.homeRecyclerGrid.adapter = adapter
    }

    fun setBanner2(){
        var items : MutableList<BannerCollection2> = arrayListOf()
        items = Constants.mainPage!!.mainBody.BannerCollection2Item
        Log.i("items ",items.size.toString())
        val adapter  = Banner2Adapter(items , activity!!)
        binding.homeRecyclerBanner.setItemAnimator(DefaultItemAnimator())
        val layoutManager = LinearLayoutManager(activity!!.baseContext)
        layoutManager.reverseLayout = true
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.homeRecyclerBanner2.layoutManager = layoutManager
        binding.homeRecyclerBanner2.adapter = adapter
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