package com.example.p2;

import java.util.Date;
import java.io.Serializable;

public class QuestionData implements Serializable{

    public String username;
    public String questionTitle;
    public String questionDescription;
    public String questionAnswers;
    public String questionTopic;
    public Date questionDate;

    public QuestionData(String questionTitle, String questionDescription, String questionTopic){
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.questionTopic = questionTopic;

    }

    public QuestionData(String username, String questionTitle, String questionDescription, String questionAnswers, Date questionDate){
        this.username = username;
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.questionAnswers = questionAnswers;
        this.questionDate = questionDate;
    }

    public String getUsername(){
        return username;
    }
    public String getQuestionTitle(){
        return questionTitle;
    }
    public String getQuestionDescription(){
        return questionDescription;
    }
    public String getQuestionAnswers(){
        return questionAnswers;
    }
    public Date getQuestionDate(){
        return questionDate;
    }
    public String getQuestionTopic() {
        return questionTopic;
    }
}
