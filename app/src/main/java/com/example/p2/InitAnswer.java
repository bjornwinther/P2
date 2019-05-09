package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;


public class InitAnswer extends AppCompatActivity {

    TextView editAnswer;
    Button postAnswer;
    Date date;
    String dateString;

    static int indexAnswerData = 0;
    static int maxIndexAnswerData = 10;
    static AnswerData [] answerData = new AnswerData[maxIndexAnswerData];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_answer);

        editAnswer = findViewById(R.id.editAnswer);
        postAnswer = findViewById(R.id.postAnswer);

        postAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                date = new java.util.Date();
                //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
                dateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);

                answerData[indexAnswerData] = new AnswerData(
                        editAnswer.getText().toString(),
                        dateString

                );

                indexAnswerData++;

                Intent intent = new Intent(InitAnswer.this, Answers.class);
                startActivity(intent);



            }
        });



    }
}
