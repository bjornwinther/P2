package com.example.p2;

import static com.example.p2.InitAnswer.answerData;
import static com.example.p2.InitAnswer.indexAnswerData;

public class AnswerData {

    private String answerDate;
    private String answerAnswer;
    private String answerUser;
    private int answerScore;
    static private int answerID;
    private int questLoaded;

    public AnswerData(String answerAnswer, String answerDate, int answerID, int questLoaded) {
        this.answerAnswer = answerAnswer;
        this.answerDate = answerDate;
        this.answerID = answerID;
        this.questLoaded = questLoaded;
    }

    public AnswerData(String answerDate, String answerAnswer, String answerUser, int answerScore, int answerID) {
        this.answerDate = answerDate;
        this.answerAnswer = answerAnswer;
        this.answerUser = answerUser;
        this.answerScore = answerScore;
        this.answerID = answerID;
    }


    public int getQuestLoaded() {
        return questLoaded;
    }

    public void setQuestLoaded(int questLoaded) {
        this.questLoaded = questLoaded;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public String getAnswerAnswer() {
        return answerAnswer;
    }

    public String getAnswerUser() {
        return answerUser;
    }

    public int getAnswerScore() {
        return answerScore;
    }

    public int getAnswerID() {
        return answerID;
    }
}
