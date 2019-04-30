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
/*
    static int indexQuestionData = 0;
    static private int maxIndexQuestionData = 10;
    static QuestionData [] questionData = new QuestionData[maxIndexQuestionData];
    String topicSelected;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);



        TextView question1;
        TextView profile1;
        TextView date1;
        TextView hashtag1;
        TextView answers1;

        TextView question2;
        TextView profile2;
        TextView date2;
        TextView hashtag2;
        TextView answers2;

        TextView question3;
        TextView profile3;
        TextView date3;
        TextView hashtag3;
        TextView answers3;

        TextView question4;
        TextView profile4;
        TextView date4;
        TextView hashtag4;
        TextView answers4;

        TextView question5;
        TextView profile5;
        TextView date5;
        TextView hashtag5;
        TextView answers5;

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


        //TextView question


     //   if (questionData[0].getQuestionTitle() != null){
     //   question1.setText(questionData[0].getQuestionTitle());
     //   profile1.setText(accounts[0].getUsername());
     //   }

/*
    EditText search = (EditText)findViewById(R.id.SearchForQuestion);
    Button options = (Button)findViewById(R.id.OptionsButton);
    Button ask = (Button)findViewById(R.id.BackButton);
*/


    Button ask = (Button)findViewById(R.id.Ask);
    ask.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Intent intent = new Intent(Forum.this, Ask.class);
            startActivity(intent);
        }
    }
    );

    }
}
