package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginMenu : AppCompatActivity() {

    private lateinit var daftar: TextView
    private lateinit var logintombol: Button
    private lateinit var forgotPass: TextView
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText

    private fun initComponents() {
        daftar = findViewById(R.id.daftarTextView)
        logintombol = findViewById(R.id.loginButton)
        forgotPass = findViewById(R.id.forgotPassTextView)
        emailField = findViewById(R.id.emailEditText)
        passwordField = findViewById(R.id.passwordEditText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        initComponents()

        daftar.setOnClickListener {
            val intent = Intent(this@LoginMenu, SignUpMenu::class.java)
            startActivity(intent)
        }

        logintombol.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (validateLogin(email, password)) {
                val intent = Intent(this@LoginMenu, Home::class.java)
                startActivity(intent)
            }
        }

        forgotPass.setOnClickListener {
            val intent = Intent(this@LoginMenu, ForgotPassMenu::class.java)
            startActivity(intent)
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        val user = PusatDataLogin.getUserByEmailAndPassword(email, password)
        return if (user != null) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
