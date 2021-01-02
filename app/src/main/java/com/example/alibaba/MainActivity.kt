package com.example.alibaba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    fun init(){
        toolbar = findViewById(R.id.page_tool_bar)
        setSupportActionBar(toolbar).apply {
            title = ""
        }
    }
}
