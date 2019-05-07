package com.example.p2;

public class AnswerData {

    private String answerDate;
    private String answerAnswer;
    private String answerUser;
    private int answerScore;
    private int answerID;

    public AnswerData(String answerAnswer) {
        this.answerAnswer = answerAnswer;
    }

    public AnswerData(String answerDate, String answerAnswer, String answerUser, int answerScore, int answerID) {
        this.answerDate = answerDate;
        this.answerAnswer = answerAnswer;
        this.answerUser = answerUser;
        this.answerScore = answerScore;
        this.answerID = answerID;
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
