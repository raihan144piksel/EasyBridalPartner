package com.example.easybridal_partner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val pusatData: List<PusatData>) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_order_layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = pusatData[position]
        holder.bind(order)
    }

    override fun getItemCount() = pusatData.size

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        private val priceTextView: TextView = itemView.findViewById(R.id.price_text_view)
        private val statusTextView: TextView = itemView.findViewById(R.id.status_text_view)
        private val ratingTextView: TextView = itemView.findViewById(R.id.rating_text_view)
//        private val dateTextView: TextView = itemView.findViewById(R.id.date_text_view)
        private val imageView: ImageView = itemView.findViewById(R.id.image_view)

        fun bind(pusatData: PusatData) {
            titleTextView.text = pusatData.title
            priceTextView.text = pusatData.price
            statusTextView.text = pusatData.status
            statusTextView.setBackgroundResource(pusatData.statusColorResId)
            ratingTextView.text = pusatData.rating
//            dateTextView.text = order.date
            imageView.setImageResource(pusatData.imageResId)
        }
    }
}