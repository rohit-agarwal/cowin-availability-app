package com.ragarwal.cowinavailabilityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phone_number = R.id.phone_number_text

        if(phone_number.toString() == ""){
            //do something here. some more comment text.
        }
    }
}