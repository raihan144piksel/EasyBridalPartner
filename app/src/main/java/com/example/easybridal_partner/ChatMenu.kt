package com.example.easybridal_partner

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatMenu : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
//    private lateinit var chatLayout: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_cs)

        messageInput = findViewById(R.id.message_input)
        sendButton = findViewById(R.id.send_button)
        backArrow = findViewById(R.id.backArrow)
//        chatLayout = findViewById(R.id.chat_layout)
//
//        chatLayout.layoutManager = LinearLayoutManager(this)

        backArrow.setOnClickListener {
            val intent = Intent(this@ChatMenu, Home::class.java)
            startActivity(intent)
        }

        sendButton.setOnClickListener {
            val message = messageInput.text.toString()
            if (message.isNotBlank()) {
                // Add the message to the chat
                // This part would need additional implementation to update the chat layout
                messageInput.text.clear()
            }
        }
    }
}