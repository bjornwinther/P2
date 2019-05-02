package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;

public class Question2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        ImageButton backButton = (ImageButton)findViewById(R.id.questionBackButton);
        ImageButton menuButton = (ImageButton)findViewById(R.id.questionForumButton);


        TextView title = (TextView)findViewById(R.id.questionTitle);
        TextView description = (TextView)findViewById(R.id.questionDescription);
        TextView date = (TextView)findViewById(R.id.questionDate);
        TextView user = (TextView)findViewById(R.id.questionUser);
        TextView topic = (TextView)findViewById(R.id.questionTopic);

        title.setText(questionData[indexQuestionData].getQuestionTitle());
        description.setText(questionData[indexQuestionData].getQuestionDescription());
        topic.setText(questionData[indexQuestionData].getQuestionTopic());
        date.setText(questionData[indexQuestionData].getQuestionDate());

        indexQuestionData++;


        // Username or name / education / semester?
        //user.setText(accounts[indexOfAcc].getUsername());
/*
        user.setText(
                          accounts[indexOfAcc].getFirstName() + ", "
                        //+ accounts[indexOfAcc].getLastName() + ", "
                        + accounts[indexOfAcc].getSemester() + ", "
                        + accounts[indexOfAcc].getUniveristy()
        );
*/

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(Forum.class);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changePageTo();
            }
        });
    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(Question2.this, page);
        startActivity(intent);
    }
}
