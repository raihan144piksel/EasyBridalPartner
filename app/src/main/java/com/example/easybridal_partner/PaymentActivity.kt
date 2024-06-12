package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    private lateinit var confirmButton: TextView

    private fun initComponents() {
        confirmButton = findViewById(R.id.confirm_button)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_payment_setting)

        initComponents()

        confirmButton.setOnClickListener {
            val intent = Intent(this@PaymentActivity, WithdrawSuccessMenu::class.java)
            startActivity(intent)
        }

        val backArrow: ImageView = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }
    }
}
