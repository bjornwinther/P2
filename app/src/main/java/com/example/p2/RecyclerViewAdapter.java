package com.example.p2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
/*
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    /////////////// https://www.youtube.com/watch?v=Vyqz_-sJGFk ///////////////

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> imageNames = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> imageNames, ArrayList<String> images, Context mContext) {
        this.imageNames = imageNames;
        this.images = images;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //log - good for debugging info
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(images.get(position))
                .into(holder.image);

             holder.title.setText(imageNames.get(position));
             holder.recyclerConstraintLayout.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View view){
                     Log.d(TAG, "OnClick: clicked on " + imageNames.get(position));
                     Toast.makeText(mContext, imageNames.get(position), Toast.LENGTH_SHORT).show();
                 }
             });



    }

    @Override
    public int getItemCount() {
        //how many list items are in the list
        return imageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//view holder holds each of the widgets in memory

        ImageView image;
        TextView title;
        TextView question;
        TextView date;
        TextView profile;
        ConstraintLayout recyclerConstraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);


            title = itemView.findViewById(R.id.title);
            question = itemView.findViewById(R.id.question);
            date = itemView.findViewById(R.id.date);
            profile = itemView.findViewById(R.id.profile);

            recyclerConstraintLayout = itemView.findViewById(R.id.recyclerConstraintLayout);

        }
    }


}
*/