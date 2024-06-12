package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ServiceActivity : AppCompatActivity() {

    private lateinit var addServiceButton: Button
    private lateinit var servicesList: RecyclerView
    private lateinit var adapter: ServicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val backArrow: ImageView = findViewById(R.id.backArrow)
        backArrow.setOnClickListener{
            finish()
        }

        addServiceButton = findViewById(R.id.AddServiceButton)  // Make sure the ID matches your XML
        servicesList = findViewById(R.id.servicesList)

        addServiceButton.setOnClickListener {
            val intent = Intent(this@ServiceActivity, AddServicesActivity::class.java)
            startActivity(intent)
        }

        // Set up RecyclerView
        servicesList.layoutManager = LinearLayoutManager(this)
        adapter = ServicesAdapter(PusatDataService.getServices(this).toMutableList(), this)  // Pass context here
        servicesList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        // Reload data when returning to this activity
        adapter.updateServices(PusatDataService.getServices(this))
    }
}

