package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


    Button goProfile = (Button) findViewById(R.id.Profile);
    goProfile.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Intent intent = new Intent(Options.this, Profile.class);
            startActivity(intent);
        }
    }
    );
}



}
