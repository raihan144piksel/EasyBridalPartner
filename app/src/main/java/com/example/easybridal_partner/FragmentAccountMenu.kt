package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

// Konstanta privat untuk parameter inisialisasi fragmen
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentAccountMenu : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account_menu, container, false)

        // Temukan LinearLayout berdasarkan ID-nya dan atur OnClickListener
        val serviceButton: Button = view.findViewById(R.id.serviceButton)
        serviceButton.setOnClickListener {
            // Tangani peristiwa klik dan navigasi ke aktivitas yang diinginkan
            val intent = Intent(activity, ServiceActivity::class.java) // Ganti ServiceActivity dengan aktivitas target Anda
            startActivity(intent)
        }

        // Ulangi untuk tombol lainnya
        val advertisementButton: Button = view.findViewById(R.id.advertisementButton)
        advertisementButton.setOnClickListener {
            val intent = Intent(activity, AdvertisementActivity::class.java) // Ganti AdvertisementActivity dengan aktivitas target Anda
            startActivity(intent)
        }

        val paymentButton: Button = view.findViewById(R.id.paymentButton)
        paymentButton.setOnClickListener {
            val intent = Intent(activity, PaymentActivity::class.java) // Ganti PaymentActivity dengan aktivitas target Anda
            startActivity(intent)
        }

        val languageButton: Button = view.findViewById(R.id.languageButton)
        languageButton.setOnClickListener {
            val intent = Intent(activity, LanguageActivity::class.java) // Ganti LanguageActivity dengan aktivitas target Anda
            startActivity(intent)
        }

        val editProfileImageView: ImageView = view.findViewById(R.id.editProfileImageView)
        editProfileImageView.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java) // Ganti LanguageActivity dengan aktivitas target Anda
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentAccountMenu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
