package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ForgotPassMenu : AppCompatActivity() {

    private lateinit var send: Button

    private fun initcomponents() {
        send = findViewById(R.id.sendButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_pass)

        initcomponents()

        send.setOnClickListener {
            val intent = Intent(this@ForgotPassMenu, MainActivity::class.java)
            startActivity(intent)
        }
    }
}