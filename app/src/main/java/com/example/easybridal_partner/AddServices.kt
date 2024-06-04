package com.example.easybridal_partner

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AddServices : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var addPhotosButton: LinearLayout
    private lateinit var publishButton: Button
    private lateinit var selectedImageView: ImageView

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_services)

        backArrow = findViewById(R.id.backArrow)
        addPhotosButton = findViewById(R.id.addPhotosButton)
        publishButton = findViewById(R.id.publishButton)

        backArrow.setOnClickListener {
            onBackPressed()
        }

        addPhotosButton.setOnClickListener {
            openGallery()
        }

        publishButton.setOnClickListener {
            // Handle publish action here
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                handleImageSelected(uri)
            }
        }
    }

    private fun handleImageSelected(uri: Uri) {
        selectedImageView.setImageURI(uri)  // Display the selected image
    }
}