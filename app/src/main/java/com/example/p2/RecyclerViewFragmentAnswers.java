package com.example.p2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;
import static com.example.p2.CustomAdapter.setID;

import static com.example.p2.InitAnswer.answerData;
import static com.example.p2.InitAnswer.indexAnswerData;
import static com.example.p2.InitAnswer.maxIndexAnswerData;


public class RecyclerViewFragmentAnswers extends Fragment {

    private static final String KEY_LAYOUT_MANAGER = "layoutManager";

    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected AnswersAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    protected String[] answerDateDataset;
    protected String[] answerAnswerDataset;
    protected int[] answerScoreDataset;
    protected int[] answerIDDataset;
    protected String[] forumDateDataset;
    protected int[] forumIDDataset;

    protected int[] answerArray;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.

        initDatasetDate();
        initDatasetID();
        initDatasetAnswer();

        /*
        for (int indexLoop = 0; indexLoop <= indexAnswerData; indexLoop++) {
            if (answerData[indexLoop].getAnswerID() == setID) {

            }
        }
*/



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.answers_recycler_view_frag, container, false);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewAnswers);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new AnswersAdapter(answerAnswerDataset, answerDateDataset, answerIDDataset);

        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }


    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(RecyclerViewFragmentAnswers.LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */


//get the data from data arrays
    private void initDatasetAnswer() {
/*
        for (int indexLoop = 0; indexLoop <= indexAnswerData; indexLoop++) {
            if (answerData[indexLoop].getAnswerID() == setID) {

            }
        }
  */

        answerAnswerDataset = new String[indexAnswerData];
        for (int i = 0; i < indexAnswerData; i++) {

            answerAnswerDataset[i] = answerData[i].getAnswerAnswer();

        }



    }


            private void initDatasetDate() {
        answerDateDataset = new String[indexAnswerData]; //remember to change to indexAnswerData
        for (int i = 0; i < indexAnswerData; i++) {

            answerDateDataset[i] = answerData[i].getAnswerDate();

        }
    }

        private void initDatasetID(){
            answerIDDataset = new int[indexAnswerData];

                    for (int i = 0; i < indexAnswerData; i++) {
                        answerIDDataset[i] = answerData[i].getAnswerID();

            }
        }

            /*
    for(int indexLoop = 0; indexLoop <= indexOfAcc; indexLoop ++) {
        if (username.equals(accounts[indexLoop].getUsername()) && password.equals(accounts[indexLoop].getConfirmPass())) {
            uniqueAccID = indexLoop;
            Intent intent = new Intent(MainActivity.this, Forum.class); // correct so it directs to the correct class (not Forum?)
            startActivity(intent);
*/


/*
    private void initDatasetScore() {
        answerScoreDataset = new int[indexAnswerData]; //remember to change to indexAnswerData
        for (int i = 0; i < maxIndexAnswerData; i++) {

            //answerAnswerDataset[i] = 2;

        }
    }
*/


}
