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

    static String questionTitleString;
    static String questionDescriptionString;
    static String topicString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        Button back = (Button)findViewById(R.id.questionBack);
        Button options = (Button)findViewById(R.id.questionOptions);


        Button post = (Button)findViewById(R.id.askPost);
        Button chooseTopic = (Button)findViewById(R.id.askChooseTopic);



        post.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText questionTitle = (EditText)findViewById(R.id.askQuestionTitle);
                EditText questionDescription = (EditText)findViewById(R.id.askQuestionDescription);
                TextView topicView = (TextView) findViewById(R.id.askTopicView);
/*
                TextView hashtag1 = (TextView)findViewById(R.id.hashtag1);
                TextView question1 = (TextView)findViewById(R.id.question1);
                TextView profile1 = (TextView)findViewById(R.id.profile1);
                TextView answers1 = (TextView)findViewById(R.id.answers1);
                TextView date1 = (TextView)findViewById(R.id.date1);
*/
                TextView title = (TextView)findViewById(R.id.questionTitle);
                TextView description = (TextView)findViewById(R.id.questionDescription);

                questionTitleString = questionTitle.getText().toString();
                questionDescriptionString = questionDescription.getText().toString();
                topicString = topicView.getText().toString();

                title.setText(questionTitleString);
                description.setText(questionDescriptionString);


/*
                hashtag1.setText(questionTitleString);
                question1.setText(questionDescriptionString);
*/


                Intent intent = new Intent(Ask.this, Question.class);
                startActivity(intent);
        }
        }
        );

    }



}
