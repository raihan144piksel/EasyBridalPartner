package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginMenu : AppCompatActivity() {

    private lateinit var daftar: TextView
    private lateinit var logintombol: Button

    private fun initComponents(){
        daftar = findViewById(R.id.daftarTextView)
        logintombol = findViewById(R.id.loginButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        initComponents()

        daftar.setOnClickListener {
            val intent = Intent(this@LoginMenu, SignUpMenu::class.java)
            startActivity(intent)
        }

        logintombol.setOnClickListener{
            val intent = Intent(this@LoginMenu, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
