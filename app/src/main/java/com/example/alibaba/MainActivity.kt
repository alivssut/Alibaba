package com.example.alibaba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        var  homeFragment = HomeFragment()

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_home_container, homeFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

    fun init(){
        toolbar = findViewById(R.id.page_tool_bar)
        setSupportActionBar(toolbar).apply {
            title = ""
        }
    }
}
