package com.example.easybridal_partner

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class AddServicesActivity : AppCompatActivity() {

    private lateinit var addPhotosButton: LinearLayout
    private lateinit var publishButton: Button
    private lateinit var titleEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var locationEditText: EditText

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_services)  // Make sure this matches your XML filename

        addPhotosButton = findViewById(R.id.addPhotosButton)
        publishButton = findViewById(R.id.publishButton)
        titleEditText = findViewById(R.id.titleEditText)
        priceEditText = findViewById(R.id.priceEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        locationEditText = findViewById(R.id.locationEditText)

        addPhotosButton.setOnClickListener {
            openGallery()
        }

        publishButton.setOnClickListener {
            saveService()
            // Intent to go back to ServiceActivity
            val intent = Intent(this, ServiceActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    private fun saveService() {
        val title = titleEditText.text.toString()
        val price = priceEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val location = locationEditText.text.toString()

        val service = Service(
            owner = "by Java Bride - Wedding Planner", // Ubah sesuai kebutuhan
            title = title,
            price = price,
            description = description,
            location = location
        )

        PusatDataService.saveService(this, service)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                // Handle the selected image URI as needed
                // For example, you might upload it to a server or save it locally
            }
        }
    }
}
