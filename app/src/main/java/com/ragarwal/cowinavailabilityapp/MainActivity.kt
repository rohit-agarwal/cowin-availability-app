package com.ragarwal.cowinavailabilityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phone_number = R.id.phone_number_text

        if(!(phone_number.toString() == "" || phone_number.toString()=="Enter Phone number here")){
            //phone number found.
            //check if phone number is valid
            //check if phone number delivers OTP to app. if not, display message to user that OTP not found.
            //store phonenumber to a file.
        }

    }
}