package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WithdrawSuccessMenu : AppCompatActivity() {

    private lateinit var done: Button

    private fun initComponents() {
        done = findViewById(R.id.doneButton)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_withdraw_success)

        initComponents()

        done.setOnClickListener {
            val intent = Intent(this@WithdrawSuccessMenu, PaymentActivity::class.java)
            startActivity(intent)
        }
    }
}