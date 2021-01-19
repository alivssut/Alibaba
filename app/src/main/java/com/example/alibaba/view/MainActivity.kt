package com.example.alibaba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alibaba.MainHeadJsonParser
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityMainBinding
import com.example.alibaba.factory.HomeViewModelFactory
import com.example.alibaba.factory.MainViewModelFactory
import com.example.alibaba.viewModel.HomeViewModel
import com.example.alibaba.viewModel.MainViewModel
import com.example.test.repository.Repository
import com.example.test.util.Constants

class MainActivity : AppCompatActivity() ,Repository.Iconnect{
    private lateinit var binding: ActivityMainBinding
    var set = false
    lateinit var viewModel: MainViewModel


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
//        Toast.makeText(this , "connect" , Toast.LENGTH_LONG).show()
        Log.i("c " , set.toString())





        Constants.c = Constants.a
        val mainHeadJsonParser = MainHeadJsonParser()
        val b = mainHeadJsonParser.parseJson(Constants.a)

        Constants.mainPage = b
        if (set == false)setHome()

//        Log.i("b " , b!!.mainProducts[0].title.toString())


    }
}
