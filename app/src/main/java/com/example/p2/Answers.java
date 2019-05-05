package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Answers extends AppCompatActivity {

    int questionID;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        textView = findViewById(R.id.textView);
/*
        Bundle extras = getIntent().getExtras();
        questionID = extras.getInt("ID");
        textView.setText(questionID);
*/
    }
}
