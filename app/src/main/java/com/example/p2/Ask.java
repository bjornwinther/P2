package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.p2.CustomAdapter.setID;

public class Ask extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static int indexQuestionData = 0;
    public static int maxIndexQuestionData = 5;
    static QuestionData [] questionData = new QuestionData[maxIndexQuestionData];


    private String questionTopicSelected;
    private TextView askMissingInput;
    private EditText questionDescription;
    private EditText questionTitle;
    public String questionDate;
    private ImageButton back;
    private ImageView options;
    private Button post;
    Date date;
    private int minEntryLength = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        askMissingInput = findViewById(R.id.askMissingInput);
        askMissingInput.setVisibility(View.GONE);

        back = findViewById(R.id.askBackButton);
        options = findViewById(R.id.askMenuButton);
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

        //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
        questionDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);


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
                    questionData[indexQuestionData] = new QuestionData(
                            questionTitle.getText().toString(),
                            questionDescription.getText().toString(),
                            questionTopicSelected,
                            questionDate,
                            indexQuestionData
                    );
                    setID = indexQuestionData;
                    indexQuestionData++;
                    Toast.makeText(getApplicationContext(),"Question Posted", Toast.LENGTH_SHORT).show();



                    Intent intent = new Intent(Ask.this, Answers.class);
                    //intent.putExtra("Ask", 0);
                    startActivity(intent);

                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(Forum.class);
            }
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changePageTo();
            }
        });
    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(Ask.this, page);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        questionTopicSelected = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
