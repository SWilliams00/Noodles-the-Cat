package com.example.noodlesthecat.rooms.livingroom.clickables;

public class CathuluQuestionClass {

    private String question, answer, alternateAnswer1, alternateAnswer2;

    public CathuluQuestionClass(String question, String answer, String alternateAnswer1, String alternateAnswer2) {
        this.question = question;
        this.answer = answer;
        this.alternateAnswer1 = alternateAnswer1;
        this.alternateAnswer2 = alternateAnswer2;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAlternateAnswer1() {
        return alternateAnswer1;
    }

    public String getAlternateAnswer2() {
        return alternateAnswer2;
    }
}
