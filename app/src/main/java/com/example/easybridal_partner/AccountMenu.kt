package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class AccountMenuFragment : Fragment() {

    private lateinit var changeLanguage: LinearLayout
    private lateinit var services: LinearLayout
    private lateinit var advertisement: LinearLayout
    private lateinit var payment: LinearLayout

    private fun initComponents(view: View) {
        changeLanguage = view.findViewById(R.id.languageButton)
        services = view.findViewById(R.id.serviceButton)
        advertisement = view.findViewById(R.id.advertisementButton)
        payment = view.findViewById(R.id.paymentButton)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account_menu, container, false)
        initComponents(view)

        changeLanguage.setOnClickListener {
            val intent = Intent(activity, ChangeLanguageMenu::class.java)
            startActivity(intent)
        }
        services.setOnClickListener {
            val intent = Intent(activity, ServiceActivity::class.java) // Assuming ServicesMenu is the class you want to navigate to
            startActivity(intent)
        }
        advertisement.setOnClickListener {
            val intent = Intent(activity, AdvertisementMenu::class.java) // Assuming AdvertisementMenu is the class you want to navigate to
            startActivity(intent)
        }
        payment.setOnClickListener {
            val intent = Intent(activity, PaymentActivity::class.java) // Assuming PaymentMenu is the class you want to navigate to
            startActivity(intent)
        }

        return view
    }
}
