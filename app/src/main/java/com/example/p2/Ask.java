package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Ask extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    static int indexQuestionData = 0;
    static private int maxIndexQuestionData = 10;
    static QuestionData [] questionData = new QuestionData[maxIndexQuestionData];
    private String questionTopicSelected;
    private TextView askMissingInput;
    private EditText questionDescription;
    private EditText questionTitle;
    public String questionDate;
    private Button back;
    private Button options;
    private Button post;
    Date date;
    private int minEntryLength = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        askMissingInput = findViewById(R.id.askMissingInput);
        askMissingInput.setVisibility(View.GONE);

        back = findViewById(R.id.questionBack);
        options = findViewById(R.id.questionOptions);
        post = findViewById(R.id.askPost);


//define spinner
        final Spinner topicSpinner = (Spinner) findViewById(R.id.topicSpinner);
        topicSpinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.topics_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        topicSpinner.setAdapter(adapter);

        date = new java.util.Date();
        questionTitle = findViewById(R.id.askQuestionTitle);
        questionDescription = findViewById(R.id.askQuestionDescription);
        //questionDate = new java.util.Date().toString();
        //questionDate = DateFormat.getDateInstance().format(myDate);
        //
        //questionDate = String.format(questionDate, df);

        //android.text.format.DateFormat dateFormat = new android.text.format.DateFormat();
        //android.text.format.DateFormat.format("yyyy-MM-dd a", new java.util.Date());
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
        questionDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);

        //questionDate = android.text.format.DateFormat.format("dd-MM-yyyy - hh:mm:ss", new java.util.Date()).toString();


        post.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (questionTitle.getText().toString().length() < minEntryLength){
                    askMissingInput.setVisibility(View.VISIBLE);
                    askMissingInput.setText("Please write your question");
                }
                else if (questionTopicSelected.equals("Choose topic")) {
                    askMissingInput.setVisibility(View.VISIBLE);
                    askMissingInput.setText("Please choose a topic");
                }
                else if (questionDescription.length() < minEntryLength) {
                    askMissingInput.setVisibility(View.VISIBLE);
                    askMissingInput.setText("Please write a short description");
                } else {
                    askMissingInput.setVisibility(View.GONE);
                    Intent intent = new Intent(Ask.this, Question2.class);
                    startActivity(intent);

                    questionData[indexQuestionData] = new QuestionData(
                            questionTitle.getText().toString(),
                            questionDescription.getText().toString(),
                            questionTopicSelected,
                            questionDate
                    );
                    indexQuestionData++;
                }

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        questionTopicSelected = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
