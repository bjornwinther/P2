package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Forum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

    EditText search = (EditText)findViewById(R.id.SearchForQuestion);
    Button back = (Button)findViewById(R.id.BackButton);
    Button options = (Button)findViewById(R.id.OptionsButton);
    Button ask = (Button)findViewById(R.id.BackButton);

    }
}
