package com.example.easybridal_partner

import android.content.Context
import android.content.SharedPreferences

data class PusatData(
    val title: String,
    val price: String,
    val status: String,
    val rating: String,
    val date: String,
    val imageResId: Int,
    val statusColorResId: Int
)

//DATA CUSTOMER
data class User(
    var email: String,
    var password: String
)


object PusatDataLogin {
    private val users: MutableList<User> = mutableListOf()

    // LOGIN DATA
    fun getUserByEmailAndPassword(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }

    // ADD USER
    fun addUser(user: User): User {
        users.add(user)
        return user
    }
}




