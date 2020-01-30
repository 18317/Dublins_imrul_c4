package com.dublin.dublins
//(MD .IMRUL MAHAMUD
//STUDENT ID:18317
//MD.ROKIBUL ISLAM
//STUDENT ID:18315

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_information.*

class Information : AppCompatActivity() {


    // to show details of station
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        // passing intent from the RV_dublin_adopter
        var number = intent.getStringExtra("number")
        var contract_name = intent.getStringExtra("contract_name")
        var name = intent.getStringExtra("name")
        var postion = intent.getStringExtra("postion")
        var bouns = intent.getStringExtra("bouns")
        var bike_stand = intent.getStringExtra("bike_stand")
        var available_bike_stand = intent.getStringExtra("available_bike_stand")
        var available_bikes = intent.getStringExtra("available_bikes")
        var address = intent.getStringExtra("address")
        var banking = intent.getStringExtra("banking")
        var status  = intent.getStringExtra("status")

        // To set the value of intent passing
        _number.setText(number)
        _contract_name.setText(contract_name)
        _name.setText(name)
        _postion.setText(postion)
        _bonus.setText(bouns)
        _bike_stand.setText(bike_stand)
        _avilable_bike_stand.setText(available_bike_stand)
        _avilable_bikes.setText(available_bikes)
        _address.setText(address)
        _banking.setText(banking)
        _status.setText(status)

    }
   

}
