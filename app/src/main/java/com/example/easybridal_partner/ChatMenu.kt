package com.example.easybridal_partner

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatMenu : AppCompatActivity() {

    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
//    private lateinit var chatLayout: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_cs)

        messageInput = findViewById(R.id.message_input)
        sendButton = findViewById(R.id.send_button)
//        chatLayout = findViewById(R.id.chat_layout)
//
//        chatLayout.layoutManager = LinearLayoutManager(this)

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