package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;

public class Forum extends AppCompatActivity {

    private Button ask;
    ListView listView;
    //int insertArrayIndexHere = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        ask = findViewById(R.id.Ask);


    ask.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            changePageTo(Ask.class);
        }
    });


        // Initializing list view with the custom adapter
        ArrayList<Item> itemList = new ArrayList<Item>();
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(this, R.layout.list_item, itemList);
        listView = (ListView) findViewById(R.id.item_list);
        listView.setAdapter(itemArrayAdapter);

        // Populating list items
        for(int i=0; i<indexQuestionData; i++) {
            itemList.add(new Item("Item " + i));
        }

        // Set up list item onclick listener
        setUpListItemClickListener();


    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(Forum.this, page);
        startActivity(intent);
    }

    private void setUpListItemClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "item " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
