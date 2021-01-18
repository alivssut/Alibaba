package com.example.alibaba.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alibaba.R
import com.example.alibaba.databinding.ActivityCalendarBinding
import com.example.test.util.Constants
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        binding = ActivityCalendarBinding.inflate(layoutInflater)

        val calendar: Calendar = Calendar.getInstance()
        val date: Int = calendar.getActualMinimum(Calendar.DATE)
        findViewById<CalendarView>(R.id.calendarView).minDate = date.toLong()

        val count = intent.getStringExtra("count")!!

        findViewById<CalendarView>(R.id.calendarView).setOnDateChangeListener { view, year, month, dayOfMonth ->
            val m = month + 1
            Constants.date = "$year-$m-$dayOfMonth"



//            view.setBackgroundColor(R.color.toolbarColor)
            Toast.makeText(this , "$year $month $dayOfMonth" , Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.calendar_btn_select).setOnClickListener {
            onBackPressed()
        }
    }
}
