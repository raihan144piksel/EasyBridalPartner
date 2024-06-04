package com.example.easybridal_partner

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView

class EditProfileActivity : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var profilePicture: ShapeableImageView
    private lateinit var editProfileTextView: TextView
    private lateinit var doneButton: Button

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Initialize UI components
        backArrow = findViewById(R.id.backArrow)
        profilePicture = findViewById(R.id.profilePicture)
        editProfileTextView = findViewById(R.id.TextViewEditProfile)
        doneButton = findViewById(R.id.button)

        // Handle back button click
        backArrow.setOnClickListener {
            finish() // Go back to the previous page
        }

        // Handle profile picture change
        profilePicture.setOnClickListener {
            openImageChooser()
        }

        // Handle "edit" text view click (assuming it should also open image chooser)
        editProfileTextView.setOnClickListener {
            openImageChooser()
        }

        // Handle done button click
        doneButton.setOnClickListener {
            finish() // Go back to the previous page
        }
    }

    // Function to open image chooser
    private fun openImageChooser() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Handle image selection result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            selectedImageUri?.let {
                profilePicture.setImageURI(it)
            }
        }
    }
}