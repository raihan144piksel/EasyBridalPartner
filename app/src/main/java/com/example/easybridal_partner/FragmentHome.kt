package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentHome : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var pusatData: MutableList<PusatData>
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialize orders list and adapter
        pusatData = mutableListOf(
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Completed",
                rating = "5.0/5.0",
                date = "03-01-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.green // Replace with your status color
            ),
            PusatData(
                title = "Regular Western Catering",
                price = "$122.00",
                status = "Cancelled",
                rating = "5.0/5.0",
                date = "02-21-2024",
                imageResId = R.drawable.ellipse_4, // Replace with your image drawable
                statusColorResId = R.color.red // Replace with your status color
            ),
            PusatData(
                title = "Regular Western Catering",
                price = "$122.00",
                status = "Completed",
                rating = "5.0/5.0",
                date = "02-11-2024",
                imageResId = R.drawable.ellipse_4, // Replace with your image drawable
                statusColorResId = R.color.green // Replace with your status color
            ),
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Booked",
                rating = "5.0/5.0",
                date = "02-14-2024",
                imageResId = R.drawable.ellipse_2, // Replace with your image drawable
                statusColorResId = R.color.light_brown // Replace with your status color
            ),
            PusatData(
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
        orderAdapter = OrderAdapter(pusatData)
        recyclerView.adapter = orderAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val chat: ImageView = view.findViewById(R.id.chat_icon)
        chat.setOnClickListener {
            val intent = Intent(activity, ChatMenu::class.java)
            startActivity(intent)
        }
    }
}
