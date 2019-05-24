package com.example.p2;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.p2.InitAnswer.answerData;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] forumTitleDataSet;
    private String[] forumDateDataSet;
    private String[] forumTopicDataSet;
    private String[] forumUserDataSet;
    private String[] forumAnswersDataset;
    private static int[] forumIDDataset;
    protected static int setID;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView topicView;
        private final TextView dateView;
        private final TextView userView;
        private final TextView answersView;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Answers.class);

                    setID = forumIDDataset[getAdapterPosition()];
                    Log.d("questionID", ""+setID);

                    v.getContext().startActivity(intent);

                }
            });

            topicView = (TextView) v.findViewById(R.id.topicView);
            dateView = (TextView) v.findViewById(R.id.dateView);
            titleView = (TextView) v.findViewById(R.id.titleView);
            userView = (TextView) v.findViewById(R.id.userView);
            answersView = (TextView) v.findViewById(R.id.answersView);

            userView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Profile.class);
                    v.getContext().startActivity(intent);
                }
            });

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
        public TextView getUserView() {
            return userView;
        }

        public TextView getAnswersView() {
            return answersView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     // @param dataSe String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(String[] titleDataSet, String[] topicDataSet, String[] dateDataSet,
                         int[]IDDataset, String[] userDataset, String[] answersDataset) {

        forumTitleDataSet = titleDataSet;
        forumTopicDataSet = topicDataSet;
        forumDateDataSet = dateDataSet;
        forumIDDataset = IDDataset;
        forumUserDataSet = userDataset;
        forumAnswersDataset = answersDataset;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getDateView().setText(forumDateDataSet[position]);
        viewHolder.getTitleView().setText(forumTitleDataSet[position]);
        viewHolder.getTopicView().setText(forumTopicDataSet[position]);
        viewHolder.getUserView().setText(forumUserDataSet[position]);
        viewHolder.getAnswersView().setText(forumAnswersDataset[position]);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return forumTitleDataSet.length;
    }

}
