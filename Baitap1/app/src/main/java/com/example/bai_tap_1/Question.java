package com.example.bai_tap_1;
import java.util.List;
public class Question {
    private  int number;
    private String content;
    private List<Answer> ListAnswer;
    Question(int number, String content, List<Answer> listAnswer){
        this.setNumber(number);
        this.setContent(content);
        this.setListAnswer(listAnswer);

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getListAnswer() {
        return ListAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        ListAnswer = listAnswer;
    }
}
