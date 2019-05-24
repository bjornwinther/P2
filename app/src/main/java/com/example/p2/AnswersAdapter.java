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

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    protected static String[] answerAnswerDataSet;
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

                    answerData[setID][indexAnswerData].setAnswerScore(answerData[setID][getAdapterPosition()].getAnswerScore()+1);

                }
            });

            downView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    upView.setImageResource(R.drawable.up);
                    downView.setImageResource(R.drawable.down_peach);

                    answerData[setID][indexAnswerData].setAnswerScore(answerData[setID][getAdapterPosition()].getAnswerScore()-1);
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

                View v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.answer_card, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getAnswerView().setText(answerAnswerDataSet[position]);
        viewHolder.getDateView().setText(answerDateDataSet[position]);
        viewHolder.getUserView().setText(answerUserDataset[position]);
        viewHolder.getScoreView().setText(Integer.toString(answerScoreDataSet[position]));

    }

    @Override
    public int getItemCount() {
                return answerAnswerDataSet.length;
    }


}
