package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AccountMenu : AppCompatActivity() {

    private lateinit var changeLanguage: Button


    private fun initComponents(){
changeLanguage = findViewById(R.id.changeLanguageButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_account)

        initComponents()

        changeLanguage.setOnClickListener{
            intent = Intent(this@AccountMenu, ChangeLanguageMenu::class.java)
            startActivity(intent)
        }


    }
}
