package com.example.easybridal_partner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easybridal_partner.OrderAdapter
import com.example.easybridal_partner.R

class OrderMenu : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var orders: MutableList<Order>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_order)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize orders list and adapter
        orders = mutableListOf(
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Completed",
                rating = "5.0/5.0",
                date = "03-01-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.green // Replace with your status color
            ),
            Order(
                title = "Regular Western Catering",
                price = "$122.00",
                status = "Cancelled",
                rating = "5.0/5.0",
                date = "02-21-2024",
                imageResId = R.drawable.ellipse_4, // Replace with your image drawable
                statusColorResId = R.color.red // Replace with your status color
            ),
            Order(
                title = "Regular Western Catering",
                price = "$122.00",
                status = "Completed",
                rating = "5.0/5.0",
                date = "02-11-2024",
                imageResId = R.drawable.ellipse_4, // Replace with your image drawable
                statusColorResId = R.color.green // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            Order(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            )
            // Add more orders as needed
        )
        // Add orders to the list here
        orderAdapter = OrderAdapter(orders)
        recyclerView.adapter = orderAdapter
    }
}