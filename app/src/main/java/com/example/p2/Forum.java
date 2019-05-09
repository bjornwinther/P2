package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;

public class Forum extends FragmentActivity implements AdapterView.OnItemSelectedListener, PopupMenu.OnMenuItemClickListener {

    TextView noPosts;
    private Button ask;
    private String questionTopicSelected;


    //int insertArrayIndexHere = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        // look up enums for sorting through posts - implement it as interface

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragment fragment = new RecyclerViewFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }

        ask = findViewById(R.id.Ask);
        noPosts = findViewById(R.id.noPosts);

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

        /*goOptions.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View view) {
                                             Intent intent = new Intent(Forum.this, Options.class);
                                             startActivity(intent);
                                         }
                                     }
        );*/

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
    }
//Popup Menu
    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.options_menu);
        popup.show();
    }
    //Popup Menu intents
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                Intent goToProfile = new Intent(Forum.this, Profile.class);
                startActivity(goToProfile);
                return true;
            case R.id.option_2:
                Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
                Intent goToChat = new Intent(Forum.this, Profile.class);
                startActivity(goToChat);
                return true;
            case R.id.option_3:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Intent goToSettings = new Intent(Forum.this, Settings.class);
                startActivity(goToSettings);
                return true;
            case R.id.option_4:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                Intent goToHelp = new Intent(Forum.this, Help.class);
                startActivity(goToHelp);
                return true;
            case R.id.option_5:
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
                Intent logOut = new Intent(Forum.this, MainActivity.class);
                startActivity(logOut);
                return true;

            default:
                return false;
        }
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
