package com.example.easybridal_partner

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class FragmentAddServices : Fragment() {

    private lateinit var backArrow: ImageView
    private lateinit var addPhotosButton: LinearLayout
    private lateinit var publishButton: Button

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_add_services, container, false)

        backArrow = view.findViewById(R.id.backArrow)
        addPhotosButton = view.findViewById(R.id.addPhotosButton)
        publishButton = view.findViewById(R.id.publishButton)

        backArrow.setOnClickListener {
            activity?.onBackPressed()
        }

        addPhotosButton.setOnClickListener {
            openGallery()
        }

        publishButton.setOnClickListener {
            // Handle publish action here
        }

        return view
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
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
