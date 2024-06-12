package com.example.easybridal_partner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentview)
        bottomNavigationView.setupWithNavController(navController)

        // Set icon and text color
        bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.bottom_nav_color)
        bottomNavigationView.itemTextColor = ContextCompat.getColorStateList(this, R.color.bottom_nav_color)
    }
}
