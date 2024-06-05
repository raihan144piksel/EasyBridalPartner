package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpMenu : AppCompatActivity() {

    private lateinit var daftartombol: Button
    private lateinit var login: TextView
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var repasswordField: EditText


    private fun initcomponents() {
        daftartombol = findViewById(R.id.daftartombol)
        login = findViewById(R.id.loginTextView)
        emailField = findViewById(R.id.emailEditText)
        passwordField = findViewById(R.id.passwordEditText)
        repasswordField = findViewById(R.id.repasswordEditText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        initcomponents()

        daftartombol.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val repassword = repasswordField.text.toString()

            if (validateInput(email, password, repassword)) {
                val user = User(
                    email = email,
                    password = password,
                )

                PusatDataLogin.addUser(user)

                val intent = Intent(this@SignUpMenu, LoginMenu::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateInput(email: String, password: String, repassword: String): Boolean {
        if (email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != repassword) {
            Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}