package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ask extends AppCompatActivity {


    public static String questionTitleString = "com.example.P2.questionTitleString";
    public static String questionDescriptionString = "com.example.P2.questionDescriptionString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        Button back = (Button)findViewById(R.id.questionBack);
        Button options = (Button)findViewById(R.id.questionOptions);
        Button post = (Button)findViewById(R.id.askPost);
        Button chooseTopic = (Button)findViewById(R.id.askChooseTopic);

        EditText questionTitle = (EditText)findViewById(R.id.askQuestionTitle);
        EditText questionDescription = (EditText)findViewById(R.id.askQuestionDescription);

        questionTitleString = questionTitle.getText().toString();
        questionDescriptionString = questionDescription.getText().toString();




        post.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(Ask.this, Question.class);
                startActivity(intent);
        }
        }
        );

    }



}
