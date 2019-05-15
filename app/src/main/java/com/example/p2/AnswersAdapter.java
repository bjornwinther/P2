package com.example.p2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import static com.example.p2.CustomAdapter.setID;
import static com.example.p2.InitAnswer.answerData;
import static com.example.p2.InitAnswer.indexAnswerData;
import static com.example.p2.InitAnswer.questionLoaded;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private static String[] answerAnswerDataSet;
    private String[] answerUpDataSet;
    private String[] answerDownDataSet;
    private String[] answerDateDataSet;
    private String[] answerUserDataset;
    private int[] answerScoreDataSet;
    private int[] answerIDDataset;
    private static int answerID;


    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView userView;
        private final TextView answerView;
        private final TextView dateView;
        private final TextView scoreView;
        private final ImageButton upView;
        private final ImageButton downView;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            userView = v.findViewById(R.id.userView);
            dateView = v.findViewById(R.id.answerdateView);
            answerView = v.findViewById(R.id.answeranswerView);
            scoreView = v.findViewById(R.id.scoreView);

            upView = v.findViewById(R.id.upVote);
            downView = v.findViewById(R.id.downVote);


            upView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    upView.setImageResource(R.drawable.up_peach);
                    downView.setImageResource(R.drawable.down);

                    answerData[setID].setAnswerScore(answerData[getAdapterPosition()].getAnswerScore()+1);

                }
            });
            downView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    upView.setImageResource(R.drawable.up);
                    downView.setImageResource(R.drawable.down_peach);

                    answerData[setID].setAnswerScore(answerData[getAdapterPosition()].getAnswerScore()-1);
                }
            });
            userView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Profile.class);
                    v.getContext().startActivity(intent);
                }
            });
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

        public TextView getScoreView() {
            return scoreView;
        }


    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param //dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public AnswersAdapter(String[] answerDataSetA, String[] dateDataSetA, int [] answerIDDatasetA, String [] answerUserDatasetA, int [] answerScoreDataSetA) {

        answerAnswerDataSet = answerDataSetA;
        answerDateDataSet = dateDataSetA;
        answerIDDataset = answerIDDatasetA;
        answerUserDataset = answerUserDatasetA;
        answerScoreDataSet = answerScoreDataSetA;

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
        viewHolder.getDateView().setText(answerDateDataSet[position]);
        viewHolder.getUserView().setText(answerUserDataset[position]);
        viewHolder.getScoreView().setText(Integer.toString(answerScoreDataSet[position]));

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)


    @Override
    public int getItemCount() {

                return answerAnswerDataSet.length;

    }


}
