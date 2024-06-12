package com.example.easybridal_partner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class OrderListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var pusatData: List<PusatData>

    companion object {
        private const val ARG_STATUS = "status"

        fun newInstance(status: String): OrderListFragment {
            val fragment = OrderListFragment()
            val args = Bundle()
            args.putString(ARG_STATUS, status)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order_list, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Get status from arguments
        val status = arguments?.getString(ARG_STATUS) ?: "All Orders"

        // Initialize orders list and adapter
        pusatData = getOrderList(status)
        orderAdapter = OrderAdapter(pusatData)
        recyclerView.adapter = orderAdapter

        return view
    }

    private fun getOrderList(status: String): List<PusatData> {
        val allOrders = listOf(
            PusatData(
                title = "Premium Western Catering",
                price = "$252.00",
                status = "Completed",
                rating = "5.0/5.0",
                date = "03-01-2024",
                imageResId = R.drawable.ellipse_2,
                statusColorResId = R.color.green
            ),
            PusatData(
                title = "Regular Western Catering",
                price = "$122.00",
                status = "Cancelled",
                rating = "5.0/5.0",
                date = "02-21-2024",
                imageResId = R.drawable.ellipse_4,
                statusColorResId = R.color.red
            ),
            // Tambahkan data lainnya di sini...
        )

        return when (status) {
            "Booked" -> allOrders.filter { it.status == "Booked" }
            "Cancelled" -> allOrders.filter { it.status == "Cancelled" }
            "Completed" -> allOrders.filter { it.status == "Completed" }
            else -> allOrders
        }
    }
}
