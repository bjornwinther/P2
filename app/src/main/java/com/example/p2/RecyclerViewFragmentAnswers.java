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

import static com.example.p2.MainActivity.accounts;
import static com.example.p2.InitAnswer.answerData;
import static com.example.p2.InitAnswer.indexAnswerData;
import static com.example.p2.InitAnswer.maxIndexAnswerData;
import static com.example.p2.MainActivity.uniqueAccID;


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
    protected String[] answerUserDataset;
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
                initDatasetUser();
                initDatasetScore();



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
        for (int i = 0; i < indexAnswerData; i++) {
            if (answerData[i].getQuestLoaded() == setID) {
                mAdapter = new AnswersAdapter(answerAnswerDataset, answerDateDataset, answerIDDataset, answerUserDataset, answerScoreDataset);
            }
        }
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



    private void initDatasetAnswer() { // int ID - take as parameter?
        answerAnswerDataset = new String[indexAnswerData]; // each time a new answer is posted - a new stringObject/recycleView will be created.
        for (int i = 0; i < indexAnswerData; i++) {
            if(answerData[i].getQuestLoaded() == setID) { // this only restricts the string.
                //change answerData[i] to answerData[setID] ?
                answerAnswerDataset[i] = answerData[i].getAnswerAnswer(); //answerData is an array of AnswerData with 10 objects
                //answerAnswerDataSet is a String array - that is initialized in the onCreate method every time this activity is accessed.
                //it is resizing each time according to indexAnswerData value. - as far as i know that can cause huge runtime problems.
            }
            //process:
            //indexAnswerData is increased by 1 for each initialized answer in initialization-activity. (indexAnswerData is a static variable, that is 0 upon initializing program)
            //answerAnswerDataSet string-array is initialized according to the size of indexAnswerData (illegal?) every time the onCreate of this class i called.
            //for-loop to loop from 0 - (value of indexAnswerData at current time)
            //EVERY loop iteration sets the object(s): answerAnswerDataset[i] (String-object) equal to answerData[i].getAnswerAnswer();

            //ergo what happens is:
            //from all answerData-objects it takes the answer by calling getAnswerAnswer and sets to a newly created string-object

            //questions:
            //when does the onCreate of this activity/class run (ergo answer to when this method runs).
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

    private void initDatasetUser(){
        answerUserDataset = new String[indexAnswerData];

        for (int i = 0; i < indexAnswerData; i++) {
            answerUserDataset[i] = accounts[uniqueAccID].getUsername();

        }
    }


    private void initDatasetScore() {
        answerScoreDataset = new int[indexAnswerData]; //remember to change to indexAnswerData
        for (int i = 0; i < indexAnswerData; i++) {

            answerScoreDataset[i] = answerData[i].getAnswerScore();

        }
    }



}