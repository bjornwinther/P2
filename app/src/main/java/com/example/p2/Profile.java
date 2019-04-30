package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.p2.SignUp.accounts;
import static com.example.p2.SignUp.indexOfAcc;

public class Profile extends AppCompatActivity {

    private TextView name;
    private ImageButton profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.profileName);
        profilePicture = (ImageButton) findViewById(R.id.profilePic);

        name.setText(accounts[indexOfAcc].getFirstName() + " " + accounts[indexOfAcc].getLastName()); // set name

        profilePicture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Onclick listener for profile picture - Method for changing profil pic.
            }
        });

    }
}
