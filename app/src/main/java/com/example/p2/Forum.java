package com.example.p2;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.Spinner;
import android.widget.TextView;


import static com.example.p2.Ask.indexQuestionData;

public class Forum extends FragmentActivity implements AdapterView.OnItemSelectedListener {

    ImageView logo;
    TextView noPosts;
    private Button ask;
    private String questionTopicSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        //Open help screen first time: https://stackoverflow.com/questions/7238532/how-to-launch-activity-only-once-when-app-is-opened-for-first-time

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(Forum.this, HelpOverlay.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();



        // look up enums for sorting through posts - implement it as interface

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragment fragment = new RecyclerViewFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }

        logo = findViewById(R.id.Logo);
        ask = findViewById(R.id.Ask);
        noPosts = findViewById(R.id.noPosts);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(Forum.class);
            }
        });

        ask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                changePageTo(Ask.class);
            }
        });

        if (indexQuestionData != 0) {
            noPosts.setVisibility(View.GONE);
        } else {
            noPosts.setVisibility(View.VISIBLE);
        }

        ImageButton goOptions = (ImageButton) findViewById(R.id.forumMenuButton);
        registerForContextMenu(goOptions);

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
    }

    //MENU NEW
    public void showMenu(View view){
        Intent intent = new Intent(Forum.this, menu.class );
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }


    private void changePageTo(Class page) {
        Intent intent = new Intent(Forum.this, page);
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
