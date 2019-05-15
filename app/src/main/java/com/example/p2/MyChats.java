package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyChats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_chats);
    }

    public void chats(View view){
        Intent intent = new Intent(MyChats.this, Chat.class);
        startActivity(intent);
    }
    public void back(View view){
        finish();
    }
    public void menus(View view){
        Intent intent = new Intent(MyChats.this, menu.class);
        startActivity(intent);
    }
}
