package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Delay for 2 seconds before transitioning to loginmenu
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, LoginMenu::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2000 milliseconds = 2 seconds
    }
}
