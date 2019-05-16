package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ImageButton backButton = (ImageButton) findViewById(R.id.forumBackButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Help.this, Forum.class);
                startActivity(intent);
            }
        });
    }

    public void helpOpen(View view){
        //Help overlay reset
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", true).commit();
        Intent intent1 = new Intent(Help.this, Forum.class);
        startActivity(intent1);

    }
}
