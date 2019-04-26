package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
/*
    EditText search = (EditText)findViewById(R.id.SearchForQuestion);

    Button options = (Button)findViewById(R.id.OptionsButton);
    Button ask = (Button)findViewById(R.id.BackButton);
    */
    Button back = (Button)findViewById(R.id.askBack);
    back.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Intent intent = new Intent(Forum.this, MainActivity.class);
            startActivity(intent);
        }
    }

    );


    Button ask = (Button)findViewById(R.id.Ask);
    ask.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Intent intent = new Intent(Forum.this, Ask.class);
            startActivity(intent);
        }
    }
    );
    }
}
