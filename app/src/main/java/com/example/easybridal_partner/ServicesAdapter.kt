package com.example.easybridal_partner

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicesAdapter(private var services: List<Service>, private val context: Context) :
    RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title_service_TextView)
        val ownerTextView: TextView = itemView.findViewById(R.id.owner_services_TextView)
        val priceTextView: TextView = itemView.findViewById(R.id.price_TextView)
        val menuOptions: ImageView = itemView.findViewById(R.id.menu_options)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_services, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = services[position]
        holder.titleTextView.text = service.title
        holder.ownerTextView.text = service.owner
        holder.priceTextView.text = "Rp${service.price}"

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailServiceActivity::class.java).apply {
                putExtra("title", service.title)
                putExtra("price", service.price)
                putExtra("description", service.description)
                putExtra("vendor", service.owner)
                putExtra("location", service.location)
            }
            context.startActivity(intent)
        }

        holder.menuOptions.setOnClickListener {
            val popupMenu = PopupMenu(context, holder.menuOptions)
            popupMenu.menuInflater.inflate(R.menu.popup_delete_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_delete -> {
                        PusatDataService.removeService(context, position)
                        updateServices(PusatDataService.getServices(context))
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }

    override fun getItemCount() = services.size

    fun updateServices(newServices: List<Service>) {
        services = newServices
        notifyDataSetChanged()
    }
}
