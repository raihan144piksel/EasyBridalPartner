package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpMenu : AppCompatActivity() {

    private lateinit var daftartombol: Button
    private lateinit var login: TextView

    private fun initcomponents(){
        daftartombol = findViewById(R.id.daftartombol)
        login = findViewById(R.id.loginTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        initcomponents()

        daftartombol.setOnClickListener {
            val intent = Intent(this@SignUpMenu, LoginMenu::class.java)
            startActivity(intent)
        }

        login.setOnClickListener{
            val intent = Intent(this@SignUpMenu, LoginMenu::class.java)
            startActivity(intent)
        }

    }
}