package com.example.p2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private String[] answerAnswerDataSet;
    private String[] answerUserDataSet;
    private String[] answerUpDataSet;
    private String[] answerDownDataSet;
    private String[] answerDateDataSet;



    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView userView;
        private final TextView answerView;
        private final TextView dateView;
        private final TextView upView;
        private final TextView downView;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            userView = v.findViewById(R.id.answeruserView);
            dateView = v.findViewById(R.id.answerdateView);
            answerView = v.findViewById(R.id.answeranswerView);
            upView = v.findViewById(R.id.answerupView);
            downView = v.findViewById(R.id.answerdownView);



        }

        public TextView getUserView() {
            return userView;
        }

        public TextView getAnswerView() {
            return answerView;
        }

        public TextView getDateView() {
            return dateView;
        }

        public TextView getUpView() {
            return upView;
        }

        public TextView getDownView() {
            return downView;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public AnswersAdapter(String[] answerDataSet) {
        /*
        String[] userDataSet
        String[] upDataSet
        String[] downDataSet
        String[] dateDataSet

        */



        answerAnswerDataSet = answerDataSet;

    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.answer_card, viewGroup, false);

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

        viewHolder.getAnswerView().setText(answerAnswerDataSet[position]);

        /*
viewHolder.getDateView().setText(dataset[position]);
viewHolder.getDownView().setText(dataset[position]);
viewHolder.getUpView().setText(dataset[position]);
viewHolder.getUserView().setText(dataset[position]);
        */

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return answerAnswerDataSet.length;
    }
}
