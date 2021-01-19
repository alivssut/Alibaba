package com.example.alibaba.view

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alibaba.MainHeadJsonParser
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityMainBinding
import com.example.alibaba.factory.MainViewModelFactory
import com.example.alibaba.viewModel.MainViewModel
import com.example.test.repository.Repository
import com.example.test.util.Constants

class MainActivity : AppCompatActivity() ,Repository.Iconnect{
    private lateinit var binding: ActivityMainBinding
    var set = false
    lateinit var viewModel: MainViewModel


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContentView(binding.root)

        binding.mainHomeAction.setOnClickListener {
            binding.mainHomeText.setTextColor(Color.parseColor("#FFC107"))
            binding.mainAccountText.setTextColor(R.color.colorPrimary)
            binding.mainMyTravelText.setTextColor(R.color.colorPrimary)
            setHome()
        }
        binding.mainMyTravelAction.setOnClickListener {
            binding.mainHomeText.setTextColor(R.color.colorPrimary)
            binding.mainAccountText.setTextColor(R.color.colorPrimary)
            binding.mainMyTravelText.setTextColor(Color.parseColor("#FFC107"))
            setMyTravel()
        }
        binding.mainAccountAction.setOnClickListener {
            binding.mainHomeText.setTextColor(R.color.colorPrimary)
            binding.mainAccountText.setTextColor(Color.parseColor("#FFC107"))
            binding.mainMyTravelText.setTextColor(R.color.colorPrimary)
            setAccount()
        }


        val repository = Repository("mobile/applications/159/page/home?headerVersion=0&bodyVersion=0&footerVersion=0", "")
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        viewModel.getDetails(this)

        viewModel.myResponse.observe(this, Observer { response ->


        })



    }

    override fun onResume() {
        super.onResume()

    }

    fun init(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.pageToolBar).apply {
            title = ""
        }
//        setHome()
    }

    fun setHome(){
        set = true
        var  homeFragment = HomeFragment(
            binding.pageToolBar,
            binding.toolbarTitle
        )
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_home_container, homeFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setMyTravel(){
        var  myTravelFragment = MyTravelFragment(
            binding.pageToolBar,
            binding.toolbarTitle
        )
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_home_container, myTravelFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setAccount(){
        var  accountFragment = AccountFragment(
            binding.pageToolBar,
            binding.toolbarTitle
        )
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_home_container, accountFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun set() {
        Constants.c = Constants.a
        val mainHeadJsonParser = MainHeadJsonParser()
        val b = mainHeadJsonParser.parseJson(Constants.a)

        Constants.mainPage = b
        if (set == false)setHome()

    }
}
