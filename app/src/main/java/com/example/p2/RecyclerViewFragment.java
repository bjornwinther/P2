package com.example.p2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.p2.CustomAdapter.setID;
import static com.example.p2.InitAnswer.answerData;
import static com.example.p2.Ask.indexQuestionData;
import static com.example.p2.Ask.questionData;
import static com.example.p2.InitAnswer.indexLength;
import static com.example.p2.MainActivity.accounts;
import static com.example.p2.MainActivity.uniqueAccID;
import static com.example.p2.AnswersAdapter.answerAnswerDataSet;

public class RecyclerViewFragment extends Fragment {

    private static final String KEY_LAYOUT_MANAGER = "layoutManager";

    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] forumTitleDataset;
    protected String[] forumTopicDataset;
    protected String[] forumDateDataset;
    protected String[] forumUserDataset;
    protected String[] forumAnswersDataset;
    protected int[] forumIDDataset;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatasetTitle();
        initDatasetDate();
        initDatasetTopic();
        initDatasetID();
        initDatasetUser();
        initDatasetAnswers();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }

        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        mAdapter = new CustomAdapter(forumTitleDataset, forumTopicDataset, forumDateDataset,
                forumIDDataset, forumUserDataset, forumAnswersDataset);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */


    private void initDatasetTitle() {
        forumTitleDataset = new String[indexQuestionData];
        for (int i = 0; i < indexQuestionData; i++) {

            forumTitleDataset[i] = questionData[i].getQuestionTitle();
        }
    }

    private void initDatasetTopic() {
        forumTopicDataset = new String[indexQuestionData];
        for (int i = 0; i < indexQuestionData; i++) {

            forumTopicDataset[i] = questionData[i].getQuestionTopic();
        }
    }

    private void initDatasetDate() {
        forumDateDataset = new String[indexQuestionData];
        for (int i = 0; i < indexQuestionData; i++) {

            forumDateDataset[i] = questionData[i].getQuestionDate();
        }
    }

    private void initDatasetID() {
        forumIDDataset = new int[indexQuestionData];
        for (int i = 0; i < indexQuestionData; i++) {

            forumIDDataset[i] = questionData[i].getQuestionID();
        }
    }

    private void initDatasetUser() {
        forumUserDataset = new String[indexQuestionData];
        for (int i = 0; i < indexQuestionData; i++) {

            forumUserDataset[i] = accounts[uniqueAccID].getUsername();
        }
    }

    private void initDatasetAnswers() {
        forumAnswersDataset = new String[indexQuestionData];
        for (int i = 0; i < indexQuestionData; i++) {

            if (answerData[i] != null){
                    forumAnswersDataset[i] = ""+indexLength[i]+" Answers";
            } else forumAnswersDataset[i] = "0 Answers";

        }
    }
}
