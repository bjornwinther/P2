package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.p2.MainActivity.accounts;
import static com.example.p2.MainActivity.uniqueAccID;

public class Profile extends AppCompatActivity {

    private TextView name;
    private ImageButton profilePicture;
    private TextView semesterAndUni;
    private TextView major;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.profileName);
        profilePicture = (ImageButton) findViewById(R.id.profilePic);
        semesterAndUni = findViewById(R.id.profileSemUni);
        major = findViewById(R.id.profileMajor);
        age = findViewById(R.id.profileAge);


                name.setText(accounts[uniqueAccID].getFirstName() + " " + accounts[uniqueAccID].getLastName()); // set name
                semesterAndUni.setText(accounts[uniqueAccID].getSemester() + " - " + accounts[uniqueAccID].getUniveristy());
                major.setText(accounts[uniqueAccID].getMajor());
                age.setText(accounts[uniqueAccID].getAge() + " years old");


        profilePicture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Onclick listener for profile picture - Method for changing profil pic.
            }
        });

    }

}
