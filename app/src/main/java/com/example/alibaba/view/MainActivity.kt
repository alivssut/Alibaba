package com.example.alibaba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContentView(binding.root)

        binding.mainHomeAction.setOnClickListener {
            setHome()
        }
        binding.mainMyTravelAction.setOnClickListener {
            setMyTravel()
        }
        binding.mainAccountAction.setOnClickListener {
            setAccount()
        }
    }

    fun init(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.pageToolBar).apply {
            title = ""
        }
        setHome()
    }

    fun setHome(){
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
}
