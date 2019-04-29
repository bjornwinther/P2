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

public class Forum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        TextView question1 = (TextView)findViewById(R.id.question1);
        TextView profile1 = (TextView)findViewById(R.id.profile1);
        TextView date1 = (TextView)findViewById(R.id.date1);
        TextView hashtag1 = (TextView)findViewById(R.id.hashtag1);

        question1.setText(questionData[0].getQuestionTitle());
        profile1.setText(accounts[0].getUsername());

/*
    EditText search = (EditText)findViewById(R.id.SearchForQuestion);
    Button options = (Button)findViewById(R.id.OptionsButton);
    Button ask = (Button)findViewById(R.id.BackButton);
*/

    Button back = (Button)findViewById(R.id.questionBack);
    back.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Intent intent = new Intent(Forum.this, MainActivity.class);
            startActivity(intent);
        }
    }
    );

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
