package com.example.easybridal_partner

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AdvertisementMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)

        // Initialize the back button
        val backArrow: ImageView = findViewById(R.id.backArrow)

        // Set an onClickListener to handle the back button click
        backArrow.setOnClickListener {
            // Close the current activity and go back to the previous activity
            finish()
        }
    }
}