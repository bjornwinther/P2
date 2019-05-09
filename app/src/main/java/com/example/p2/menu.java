package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void close(View view){
        finish();
    }
    public void profileGo(View view) {
        Intent goToProfile = new Intent(menu.this, Profile.class);
        startActivity(goToProfile);
    }
    public void forumGo(View view) {
        Intent goToProfile = new Intent(menu.this, Forum.class);
        startActivity(goToProfile);
    }
    public void settingsGo(View view) {
        Intent goToProfile = new Intent(menu.this, Settings.class);
        startActivity(goToProfile);
    }
    public void helpGo(View view) {
        Intent goToProfile = new Intent(menu.this, Help.class);
        startActivity(goToProfile);
    }
    public void chatGo(View view) {
        Intent goToProfile = new Intent(menu.this, Chat.class);
        startActivity(goToProfile);
    }
    public void logOutGo(View view) {
        Intent goToProfile = new Intent(menu.this, MainActivity.class);
        startActivity(goToProfile);
    }
}
