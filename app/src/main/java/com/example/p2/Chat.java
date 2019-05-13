package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chat extends AppCompatActivity {

    private Button sendButton;
    private EditText chatbox;
    private TextView sentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        sendButton = findViewById(R.id.button_chatbox_send);
        chatbox = findViewById(R.id.edittext_chatbox);
        sentMessage = findViewById(R.id.messageSent);

        sentMessage.setVisibility(View.GONE);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentMessage.setText(chatbox.getText().toString());
                sentMessage.setVisibility(View.VISIBLE);
                chatbox.clearAnimation();
                chatbox.setText(String.valueOf("")); // deletes message after sending it
            }
            });

    }
    //MENU NEW
    public void showMenu(View view){
        Intent intent = new Intent(Chat.this, menu.class );
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
    public void backbutt(View view){
        finish();
    }
}
