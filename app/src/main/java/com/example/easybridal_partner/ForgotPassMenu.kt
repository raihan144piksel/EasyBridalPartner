package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ForgotPassMenu : AppCompatActivity() {

    private lateinit var send: Button
    private lateinit var login: TextView

    private fun initcomponents() {
        send = findViewById(R.id.sendButton)
        login = findViewById(R.id.loginTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_forgot_pass)

        initcomponents()

        send.setOnClickListener {
            val intent = Intent(this@ForgotPassMenu, LoadingApp::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val intent = Intent(this@ForgotPassMenu, LoginMenu::class.java)
            startActivity(intent)
        }
    }
}