package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        TextView title = (TextView)findViewById(R.id.questionTitle);
        TextView description = (TextView)findViewById(R.id.questionDescription);
        TextView date = (TextView)findViewById(R.id.questionDate);


    }
}
