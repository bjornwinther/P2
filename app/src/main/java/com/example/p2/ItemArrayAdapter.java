package com.example.p2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;

public class ItemArrayAdapter extends ArrayAdapter<Item> {

    private int listItemLayout;
    Bitmap arrowImage = BitmapFactory.decodeResource(getContext().getResources(),
            R.drawable.forward);

    private ArrayList<String> topicText = new ArrayList<>();

    public ItemArrayAdapter(Context context, int layoutId, ArrayList<Item> itemList) {
        super(context, layoutId, itemList);
        listItemLayout = layoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(listItemLayout, parent, false);

            viewHolder.topicView = (TextView) convertView.findViewById(R.id.topicView);
            viewHolder.questionView = (TextView) convertView.findViewById(R.id.questionView);
            viewHolder.dateView = (TextView) convertView.findViewById(R.id.dateView);
            viewHolder.answersView=(TextView)convertView.findViewById(R.id.answersView);
            viewHolder.userView=(TextView)convertView.findViewById(R.id.userView);
            viewHolder.arrowView=(ImageView)convertView.findViewById(R.id.arrowView);

            convertView.setTag(viewHolder); // view lookup cache stored in tag
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.topicView.setText(questionData[0].getQuestionTopic());
        viewHolder.questionView.setText(questionData[0].getQuestionTitle());
        viewHolder.dateView.setText(questionData[0].getQuestionDate());
        viewHolder.answersView.setText("Answers View");
        viewHolder.arrowView.setImageBitmap(arrowImage);




        // Return the completed view to render on screen
        return convertView;
    }

    private static class ViewHolder // extends RecyclerView.ViewHolder
    {

        TextView topicView;
        TextView questionView;
        TextView answersView;
        TextView userView;
        TextView dateView;
        ImageView arrowView;
/*
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            topicView = itemView.findViewById(R.id.topicView);

        }
*/
    }
/*
    private void initCardsData(){
        //Log.d(TAG, "initCards: preparing cards.");

        topicText.add("you");

        topicText.add("what");

        topicText.add("mate");

        //initRecyclerView();

    }
    */
}