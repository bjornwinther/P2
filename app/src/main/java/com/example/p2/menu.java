package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.p2.MainActivity.accounts;
import static com.example.p2.MainActivity.uniqueAccID;

public class menu extends AppCompatActivity {


    private TextView name;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        name = findViewById(R.id.menuName);
        email = findViewById(R.id.menuEmail);

        name.setText(accounts[uniqueAccID].getFirstName() + " " + accounts[uniqueAccID].getLastName());
        email.setText(accounts[uniqueAccID].getEmail());

    }


    public void close(View view){
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    public void profileGo(View view) {
        Intent goToProfile = new Intent(menu.this, Profile.class);
        startActivity(goToProfile);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public void forumGo(View view) {
        Intent goToForum = new Intent(menu.this, Forum.class);
        startActivity(goToForum);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public void settingsGo(View view) {
        Intent goToSettings = new Intent(menu.this, Settings.class);
        startActivity(goToSettings);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public void helpGo(View view) {
        Intent goToHelp = new Intent(menu.this, Help.class);
        startActivity(goToHelp);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public void chatGo(View view) {
        Intent goToChat = new Intent(menu.this, Chat.class);
        startActivity(goToChat);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public void logOutGo(View view) {
        Intent goToSignin = new Intent(menu.this, MainActivity.class);
        startActivity(goToSignin);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
