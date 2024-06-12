package com.example.easybridal_partner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.easybridal_partner.databinding.ActivityDetailServiceBinding
import java.text.DecimalFormat

class DetailServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")
        val description = intent.getStringExtra("description")
        val vendor = intent.getStringExtra("vendor")
        val location = intent.getStringExtra("location")

        binding.judulservice.text = title
        binding.totalharga.text = "Rp${price}"
        binding.deskripsi.text = description
        binding.namavendor.text = vendor

        binding.back.setOnClickListener {
            finish()
        }
    }
}
