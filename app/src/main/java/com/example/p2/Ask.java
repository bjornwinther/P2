package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ask extends AppCompatActivity {

    static int indexQuestionData = 0;
    static private int maxIndexQuestionData = 10;
    static QuestionData [] questionData = new QuestionData[maxIndexQuestionData];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        Button back = (Button)findViewById(R.id.questionBack);
        Button options = (Button)findViewById(R.id.questionOptions);
        Button post = (Button)findViewById(R.id.askPost);

//define spinner
        Spinner topicSpinner = (Spinner)findViewById(R.id.topicSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.topics_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        topicSpinner.setAdapter(adapter);

        final EditText questionTitle = (EditText)findViewById(R.id.askQuestionTitle);
        final EditText questionDescription = (EditText)findViewById(R.id.askQuestionDescription);

        post.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(Ask.this, Question2.class);
                startActivity(intent);


                questionData[indexQuestionData] = new QuestionData(
                        questionTitle.getText().toString(),
                        questionDescription.getText().toString()
                );
                indexQuestionData++;


            }
        });
    }



}
