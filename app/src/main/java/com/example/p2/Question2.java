package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static com.example.p2.Ask.questionData;
import static com.example.p2.SignUp.accounts;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Button backButton = (Button)findViewById(R.id.questionBack);

        TextView title = (TextView)findViewById(R.id.questionTitle);
        TextView description = (TextView)findViewById(R.id.questionDescription);
        TextView date = (TextView)findViewById(R.id.questionDate);
        TextView profile = (TextView)findViewById(R.id.questionProfile);

        title.setText(questionData[0].getQuestionTitle());
        description.setText(questionData[0].getQuestionDescription());

        //profile.setText(accounts[0].getUsername());



    }
}
