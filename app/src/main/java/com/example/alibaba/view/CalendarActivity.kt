package com.example.alibaba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityCalendarBinding
import com.example.alibaba.databinding.ActivityCitiesBinding

class CalendarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        binding = ActivityCalendarBinding.inflate(layoutInflater)

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

        }
    }
}
