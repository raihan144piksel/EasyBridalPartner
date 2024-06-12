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

data class Service(
    val owner: String,
    val title: String,
    val price: String,
    val description: String,
    val location: String
)

object PusatDataService {
    private const val PREFS_NAME = "services_prefs"
    private const val SERVICES_KEY = "services"

    fun saveService(context: Context, service: Service) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val services = getServices(context).toMutableList()
        services.add(service)

        val serializedServices = services.joinToString("|") { serializeService(it) }
        editor.putString(SERVICES_KEY, serializedServices)
        editor.apply()
    }

    fun getServices(context: Context): List<Service> {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val serializedServices = sharedPreferences.getString(SERVICES_KEY, null) ?: return emptyList()
        return serializedServices.split("|").mapNotNull { deserializeService(it) }
    }

    private fun serializeService(service: Service): String {
        return "${service.owner};${service.title};${service.price};${service.description};${service.location}"
    }

    private fun deserializeService(serializedService: String): Service? {
        val parts = serializedService.split(";")
        return if (parts.size == 5) {
            Service(parts[0], parts[1], parts[2], parts[3], parts[4])
        } else {
            null
        }
    }

    fun removeService(context: Context, index: Int) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val services = getServices(context).toMutableList()
        if (index >= 0 && index < services.size) {
            services.removeAt(index)
            val editor = sharedPreferences.edit()
            val serializedServices = services.joinToString("|") { serializeService(it) }
            editor.putString(SERVICES_KEY, serializedServices)
            editor.apply()
        }
    }
}




// DATA CUSTOMER
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
