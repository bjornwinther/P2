package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.p2.Ask.questionData;
import static com.example.p2.SignUp.accounts;
import static com.example.p2.SignUp.indexOfAcc;


public class Forum extends AppCompatActivity {

    private Button ask;

    private Class page;

    private TextView question1;
    private TextView profile1;
    private TextView date1;
    private TextView hashtag1;
    private TextView answers1;

    private TextView question2;
    private TextView profile2;
    private TextView date2;
    private TextView hashtag2;
    private TextView answers2;

    private TextView question3;
    private TextView profile3;
    private TextView date3;
    private TextView hashtag3;
    private TextView answers3;

    private TextView question4;
    private TextView profile4;
    private TextView date4;
    private TextView hashtag4;
    private TextView answers4;

    private TextView question5;
    private TextView profile5;
    private TextView date5;
    private TextView hashtag5;
    private TextView answers5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        ask = findViewById(R.id.Ask);
/*
        question1 = findViewById(R.id.question1);
        profile1 = findViewById(R.id.profile1);
        date1 = findViewById(R.id.date1);
        hashtag1 = findViewById(R.id.hashtag1);
        answers1 = findViewById(R.id.answers1);

        question2 = findViewById(R.id.question2);
        profile2 = findViewById(R.id.profile2);
        date2 = findViewById(R.id.date2);
        hashtag2 = findViewById(R.id.hashtag2);
        answers2 = findViewById(R.id.answers2);

        question3 = findViewById(R.id.question3);
        profile3 = findViewById(R.id.profile3);
        date3 = findViewById(R.id.date3);
        hashtag3 = findViewById(R.id.hashtag3);
        answers3 = findViewById(R.id.answers3);

        question4 = findViewById(R.id.question4);
        profile4 = findViewById(R.id.profile4);
        date4 = findViewById(R.id.date4);
        hashtag4 = findViewById(R.id.hashtag4);
        answers4 = findViewById(R.id.answers4);

        question5 = findViewById(R.id.question5);
        profile5 = findViewById(R.id.profile5);
        date5 = findViewById(R.id.date5);
        hashtag5 = findViewById(R.id.hashtag5);
        answers5 = findViewById(R.id.answers5);
*/


    ask.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            changePageTo(Ask.class);
        }
    });

    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(Forum.this, page);
        startActivity(intent);
    }

}
