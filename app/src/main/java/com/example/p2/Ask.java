package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ask extends AppCompatActivity {

    static String questionTitle;
    static String questionDescription;
    static String topic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        Button back = (Button)findViewById(R.id.askBack);
        Button options = (Button)findViewById(R.id.askOptions);

        EditText questionTitle = (EditText)findViewById(R.id.askQuestionTitle);
        EditText questionDescription = (EditText)findViewById(R.id.askQuestionDescription);
        TextView topicView = (TextView) findViewById(R.id.askTopicView);
        Button post = (Button)findViewById(R.id.askPost);
        Button chooseTopic = (Button)findViewById(R.id.askChooseTopic);

    }



}
