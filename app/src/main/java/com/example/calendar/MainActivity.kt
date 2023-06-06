package com.example.calendar

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for text view and calendar view
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    lateinit var moonShape : TextView
    lateinit var nextPage : Button
    var dateMessage: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing variables of
        // list view with their ids.
        var sendDate = "11/8/1999"
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)
        moonShape = findViewById(R.id.phaseView)
        nextPage = findViewById(R.id.moonDisplay)
        val monthMap = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
        val moonPhases = arrayOf("New Moon", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full Moon", "Waning Gibbous", "Last Quarter", "Waning Crescent")
        // on below line we are adding set on
        // date change listener for calendar view.
        calendarView
            .setOnDateChangeListener(
                OnDateChangeListener { view, year, month, dayOfMonth ->
                    // In this Listener we are getting values
                    // such as year, month and day of month
                    // on below line we are creating a variable
                    // in which we are adding all the variables in it.
                    val Date = (dayOfMonth.toString() + "-"
                            + monthMap[month] + "-" + year)
                    sendDate = Date
                    val sendDate = (dayOfMonth.toString() + "/"
                            + (month+1) + "/" + year)
                    numOfDays(sendDate, moonPhases)
                    // set this date in TextView for Display
                    dateTV.setText(Date)
                })

        nextPage.setOnClickListener({
            intent= Intent(this,moonDisplay::class.java)
            val bundle=Bundle()
            bundle.putString("date",sendDate)
            bundle.putString("phaseName",moonShape.text.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        })
    }

    fun numOfDays(sendDate: String, moonPhases: Array<String>){
        val baseDate = "11/8/1999"
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val startDate = sdf.parse(baseDate)
        val endDate = sdf.parse(sendDate)
        val timeGone = kotlin.math.abs(endDate.time - startDate.time)
        val daysGone = timeGone / (24 * 60 * 60 * 1000)
        val moonAge = daysGone % 29.53058770576
        moonShape.text = moonAge.toString()
        if((0 < moonAge && moonAge <= 1) || (28.530588 < moonAge && moonAge <= 29.530588))
            moonShape.text = moonPhases[0]
        else if(1 < moonAge && moonAge <= 6.382647)
            moonShape.text = moonPhases[1]
        else if(6.382647 < moonAge && moonAge <= 8.382647)
            moonShape.text = moonPhases[2]
        else if(8.382647  < moonAge && moonAge <= 13.765294)
            moonShape.text = moonPhases[3]
        else if(13.765294 < moonAge && moonAge <= 15.765294)
            moonShape.text = moonPhases[4]
        else if(15.765294 < moonAge && moonAge <= 21.147941)
            moonShape.text = moonPhases[5]
        else if(21.147941 < moonAge && moonAge <= 23.147941)
            moonShape.text = moonPhases[6]
        else if(23.147941 < moonAge && moonAge <= 28.530588)
            moonShape.text = moonPhases[7]
    }
}