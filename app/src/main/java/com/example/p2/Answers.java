package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;

public class Answers extends FragmentActivity {

    ImageButton backButton;
    int ID;
    TextView questionTitle;
    TextView questionTopic;
    TextView questionDate;
    TextView questionDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        questionTitle = findViewById(R.id.questionTitle);
        questionTopic = findViewById(R.id.questionTopic);
        questionDate = findViewById(R.id.questionDate);
        questionDescription = findViewById(R.id.questionDescription);

        backButton = findViewById(R.id.answersBackButton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Answers.this, Forum.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        intent.getIntExtra("ID", 0);
        ID = getIntent().getIntExtra("ID", 0);

        questionTitle.setText(questionData[ID].getQuestionTitle());
        questionTopic.setText(questionData[ID].getQuestionTopic());
        questionDescription.setText(questionData[ID].getQuestionDescription());
        questionDate.setText(questionData[ID].getQuestionDate());



    }
}
