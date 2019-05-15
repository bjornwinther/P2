package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import static com.example.p2.CustomAdapter.setID;


public class InitAnswer extends AppCompatActivity {

    TextView editAnswer;
    TextView inputError;
    Button postAnswer;
    Date date;
    String dateString;

    static int indexAnswerData = 0;
    static int maxIndexAnswerData = 10;
    static AnswerData [] answerData = new AnswerData[maxIndexAnswerData];
    static int questionLoaded;
    private final int minEntryLength = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_answer);

        editAnswer = findViewById(R.id.editAnswer);
        postAnswer = findViewById(R.id.postAnswer);
        inputError = findViewById(R.id.answerMissingInput);

        questionLoaded = setID;

        postAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editAnswer.getText().toString().length() < minEntryLength) {
                    inputError.setVisibility(View.VISIBLE);
                } else {

                    inputError.setVisibility(View.GONE);
                    date = new java.util.Date();
                    //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
                    dateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);

                    answerData[indexAnswerData] = new AnswerData(
                            editAnswer.getText().toString(),
                            dateString,
                            setID,
                            questionLoaded,
                            0
                    );

                    indexAnswerData++;

                    Intent intent = new Intent(InitAnswer.this, Answers.class);
                    startActivity(intent);

                }

            }
        });



    }
    //MENU NEW
    public void showMenu(View view){
        Intent intent = new Intent(InitAnswer.this, menu.class );
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void backButt(View view){
        finish();
    }
}
