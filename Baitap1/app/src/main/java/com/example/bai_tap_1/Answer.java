package com.example.bai_tap_1;

public class Answer {
    private String content;
    private Boolean isCorrect;
    public Answer(String content, boolean isCorrect){
        this.setContent(content);
        this.setCorrect(isCorrect);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
