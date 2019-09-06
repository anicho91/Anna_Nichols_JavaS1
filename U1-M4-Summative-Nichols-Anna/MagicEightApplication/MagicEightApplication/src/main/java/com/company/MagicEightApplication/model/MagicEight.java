package com.company.MagicEightApplication.model;

public class MagicEight {

    private String Question;
    private String Answer;

    MagicEight(){

    }

    public MagicEight(String question, String answer) {
        Question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
