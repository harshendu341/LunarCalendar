package com.example.calendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class moonDisplay : AppCompatActivity() {
    lateinit var moonPic : ImageView
    lateinit var heading : TextView
    lateinit var name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moon_display)
        val bundle:Bundle?=intent.extras
        val dateValue:String?=bundle?.getString("date")
        val phase:String?=bundle?.getString("phaseName")

        moonPic = findViewById(R.id.moonImage)
        heading = findViewById(R.id.headingPage2)
        name = findViewById(R.id.nameOfPhase)
        heading.setText(dateValue.toString())
        name.setText(phase.toString())
        if(phase == "First Quarter")
            moonPic.setImageResource(R.drawable.first_quarter);
        else if(phase == "Waxing Crescent")
            moonPic.setImageResource(R.drawable.waxing_crescent);
        else if(phase == "Full Moon")
            moonPic.setImageResource(R.drawable.full_moon);
        else if(phase == "Last Quarter")
            moonPic.setImageResource(R.drawable.third_quarter);
        else if(phase == "Waning Crescent")
            moonPic.setImageResource(R.drawable.waning_crescent);
        else if(phase == "Waning Gibbous")
            moonPic.setImageResource(R.drawable.waning_gibbous);
        else if(phase == "Waxing Gibbous")
            moonPic.setImageResource(R.drawable.waxing_gibbous);

    }
}