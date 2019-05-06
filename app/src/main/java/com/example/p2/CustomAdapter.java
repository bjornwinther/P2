package com.example.p2;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] forumTitleDataSet;
    private String[] forumDateDataSet;
    private String[] forumTopicDataSet;
    private static int[] forumIDDataset;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView topicView;
        private final TextView dateView;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Answers.class);
                    intent.putExtra("ID", forumIDDataset[getAdapterPosition()]);
                    //intent.putExtra("Forum", 0);
                    v.getContext().startActivity(intent);

                    //Toast.makeText(v.getContext(), ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            topicView = (TextView) v.findViewById(R.id.topicView);
            dateView = (TextView) v.findViewById(R.id.dateView);
            titleView = (TextView) v.findViewById(R.id.titleView);


        }

        public TextView getTitleView() {
            return titleView;
        }
        public TextView getTopicView() {
            return topicView;
        }
        public TextView getDateView() {
            return dateView;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(String[] titleDataSet, String[] topicDataSet, String[] dateDataSet, int[]IDDataset) {

        forumTitleDataSet = titleDataSet;
        forumTopicDataSet = topicDataSet;
        forumDateDataSet = dateDataSet;
        forumIDDataset = IDDataset;

    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getDateView().setText(forumDateDataSet[position]);
        viewHolder.getTitleView().setText(forumTitleDataSet[position]);
        viewHolder.getTopicView().setText(forumTopicDataSet[position]);


    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return forumTitleDataSet.length;
    }
}
