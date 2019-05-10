package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;
import static com.example.p2.CustomAdapter.setID;

public class Answers extends FragmentActivity {

    ImageButton backButton;
    ImageButton menuBtn;
    TextView questionTitle;
    TextView questionTopic;
    TextView questionDate;
    TextView questionDescription;
    Button answer;
    int ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        //ID = setID;
        Log.d("ID", "ID: "+ID);

        questionTitle = findViewById(R.id.questionTitle);
        questionTopic = findViewById(R.id.questionTopic);
        questionDate = findViewById(R.id.questionDate);
        questionDescription = findViewById(R.id.questionDescription);
        answer = findViewById(R.id.answerButton);
        menuBtn = findViewById(R.id.answersMenuBtn);

        backButton = findViewById(R.id.answersBackButton);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Answers.this, menu.class);
                startActivity(intent);
            }
        });

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragmentAnswers fragmentAnswers = new RecyclerViewFragmentAnswers();
            transaction.replace(R.id.answers_sample_content_fragment, fragmentAnswers);
            transaction.commit();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Answers.this, Forum.class);
                startActivity(intent);
            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Answers.this, InitAnswer.class);
                startActivity(intent);
            }
        });
/*
        Intent intent = getIntent();
        intent.getIntExtra("ID", 0);
        ID = getIntent().getIntExtra("ID", 0);
*/


        questionTitle.setText(questionData[setID].getQuestionTitle());
        questionTopic.setText(questionData[setID].getQuestionTopic());
        questionDescription.setText(questionData[setID].getQuestionDescription());
        questionDate.setText(questionData[setID].getQuestionDate());

    }
}
