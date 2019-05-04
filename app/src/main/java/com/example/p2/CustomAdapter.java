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

    private String[] mtitleDataSet;
    private String[] mdateDataSet;
    private String[] mtopicDataSet;
    private int[] midDataset;


    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView topicView;
        private final TextView dateView;
        private final ConstraintLayout constraintLayout;
       // private final ImageView forwardView;
        //private final TextView textView;
        //private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Answers.class);
                    v.getContext().startActivity(intent);
                    //intent.putExtra("Id", questionID);
                    Toast.makeText(v.getContext(), "id", Toast.LENGTH_SHORT).show();
                }
            });

            topicView = (TextView) v.findViewById(R.id.topicView);
            dateView = (TextView) v.findViewById(R.id.dateView);
            titleView = (TextView) v.findViewById(R.id.titleView);
            constraintLayout = (ConstraintLayout) v.findViewById(R.id.rowConstraint);



           //forwardView = (ImageView) v.findViewById(R.id.imageView);
        }




        /*
        public TextView getTextView() {
            return textView;
        }
        */
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
    public CustomAdapter(String[] titleDataSet, String[] topicDataSet, String[] dateDataSet) {
        //, int[]id
        mtitleDataSet = titleDataSet;
        mtopicDataSet = topicDataSet;
        mdateDataSet = dateDataSet;
        //midDataset = id;
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
        viewHolder.getDateView().setText(mdateDataSet[position]);
        viewHolder.getTitleView().setText(mtitleDataSet[position]);
        viewHolder.getTopicView().setText(mtopicDataSet[position]);


    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mtitleDataSet.length;
    }
}
