package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText info;
    private TextView saveInfo;
    private TextView editInfo;
    private TextView profileUni;
    private TextView rating;
    private TextView mentors;
    private TextView questAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.profileName);
        profilePicture = (ImageButton) findViewById(R.id.profilePic);
        semesterAndUni = findViewById(R.id.profileSemUni);
        major = findViewById(R.id.profileMajor);
        age = findViewById(R.id.profileAge);
        info = findViewById(R.id.profileInfo);
        saveInfo = findViewById(R.id.profileSave);
        editInfo = findViewById(R.id.profileEdit);
        profileUni = findViewById(R.id.profileUni);
        rating = findViewById(R.id.profileRating);
        mentors = findViewById(R.id.profileMentor);
        questAnswers = findViewById(R.id.profileQuestAnswer);



                name.setText(accounts[uniqueAccID].getFirstName() + " " + accounts[uniqueAccID].getLastName()); // set name
                semesterAndUni.setText(accounts[uniqueAccID].getSemester() + " - " + accounts[uniqueAccID].getUniveristy());
                major.setText(accounts[uniqueAccID].getMajor());
                age.setText(accounts[uniqueAccID].getAge() + " years old");
                profileUni.setText(accounts[uniqueAccID].getUniveristy());
                rating.setText(String.valueOf((accounts[uniqueAccID].getRating())));
                mentors.setText(String.valueOf(accounts[uniqueAccID].getMentorships()));
                questAnswers.setText(String.valueOf(accounts[uniqueAccID].getTotalAnswers()));



        profilePicture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Onclick listener for profile picture - Method for changing profil pic.
            }
        });

        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            info.setFocusable(false);
            info.setEnabled(false);
            saveInfo.setVisibility(View.GONE);
            saveInfo.setClickable(false);
            }
        });

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            info.setFocusable(true);
            info.setEnabled(true);
            saveInfo.setVisibility(View.VISIBLE);
            saveInfo.setClickable(true);
            //Find method for being able to edit the info again.
            }
        });


    }

}
