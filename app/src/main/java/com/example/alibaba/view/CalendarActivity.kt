package com.example.alibaba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityCalendarBinding
import com.example.test.util.Constants

class CalendarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        binding = ActivityCalendarBinding.inflate(layoutInflater)

        findViewById<CalendarView>(R.id.calendarView).setOnDateChangeListener { view, year, month, dayOfMonth ->
            var m = month + 1
            Constants.date = "$year-$m-$dayOfMonth"

            Toast.makeText(this , "$year $month $dayOfMonth" , Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.calendar_btn_select).setOnClickListener {
            onBackPressed()
        }
    }
}
