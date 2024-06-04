package com.example.bai_tap_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import android.widget.Toast;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtnumber, txtContent;
    int Count = 0;
    private Button btn1, btn2, btn3, btn4, btnsubmit;
    private Question mQuestion;
    private int currentQuestion = 0;
    private List<Question> mListQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        mListQuestion = getQuestion();
        if (mListQuestion.isEmpty()) {
            return;
        }
        setDataQuestion(mListQuestion.get(currentQuestion));
    }

    private void setDataQuestion(Question question) {
        if (question == null) {
            return;
        }
        mQuestion = question;

        // Sử dụng StringBuilder để xây dựng nội dung câu hỏi
        StringBuilder questionText = new StringBuilder();
        questionText.append("Question ").append(question.getNumber()).append(": ").append(question.getContent());

        // Hiển thị nội dung câu hỏi trong txtContent
        txtContent.setText(questionText.toString());
        String titleQuestion = "Question" + question.getNumber() +"/3";
        txtnumber.setText(titleQuestion);
        btn1.setText(question.getListAnswer().get(0).getContent());
        btn2.setText(question.getListAnswer().get(1).getContent());
        btn3.setText(question.getListAnswer().get(2).getContent());
        btn4.setText(question.getListAnswer().get(3).getContent());
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    private void initUi() {
        txtnumber = findViewById(R.id.txtnumber);
        txtContent = findViewById(R.id.txtContent);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnsubmit = findViewById(R.id.btnsubmit);

        // Thêm sự kiện lắng nghe cho nút submit
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra câu trả lời ở đây và tăng Count nếu đúng
                checkAnswer(mQuestion, mQuestion.getListAnswer().get(0));
            }
        });
        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }

            private void goBack() {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    setDataQuestion(mListQuestion.get(currentQuestion));
                } else {
                    // Nếu bạn đang ở câu hỏi đầu tiên, có thể hiển thị một thông báo hoặc thực hiện hành động khác.
                    Toast.makeText(MainActivity.this, "Bạn đang ở câu hỏi đầu tiên", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private List<Question> getQuestion() {
        List<Question> list = new ArrayList<>();
        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Đông", true));
        answerList1.add(new Answer("Tây", false));
        answerList1.add(new Answer("Nam", false));
        answerList1.add(new Answer("Bắc", false));
        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Thợ sắt", false));
        answerList2.add(new Answer("Thợ mỏ", true));
        answerList2.add(new Answer("Thợ săn", false));
        answerList2.add(new Answer("Thợ rèn", false));
        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Củ cải", false));
        answerList3.add(new Answer("Củ kiệu", false));
        answerList3.add(new Answer("Củ cà chua", true));
        answerList3.add(new Answer("Củ cà rốt", false));
        list.add(new Question(1, "Đâu là một mùa trong năm", answerList1));
        list.add(new Question(2, "Bảy chú lùn trong truyện 'Bạch tuyết và bảy chú lùn làm nghề gì?", answerList2));
        list.add(new Question(3, "Thính được làm từ gì?", answerList3));

        return list;
    }

    @Override
    public void onClick(View v) {
        Answer selectedAnswer = null;

        if (v.getId() == R.id.btn1) {
            btn1.setBackgroundResource(R.drawable.bg_orange_corner_30);
            selectedAnswer = mQuestion.getListAnswer().get(0);
        } else if (v.getId() == R.id.btn2) {
            btn2.setBackgroundResource(R.drawable.bg_orange_corner_30);
            selectedAnswer = mQuestion.getListAnswer().get(1);
        } else if (v.getId() == R.id.btn3) {
            btn3.setBackgroundResource(R.drawable.bg_orange_corner_30);
            selectedAnswer = mQuestion.getListAnswer().get(2);
        } else if (v.getId() == R.id.btn4) {
            btn4.setBackgroundResource(R.drawable.bg_orange_corner_30);
            selectedAnswer = mQuestion.getListAnswer().get(3);
        }

        if (selectedAnswer != null) {
            if (currentQuestion < mListQuestion.size() - 1) {
                checkAnswer(mQuestion, selectedAnswer);
            } else {
                // Nếu đang ở câu hỏi cuối cùng, hiển thị thông báo số câu trả lời đúng
                Toast.makeText(MainActivity.this, "Số câu trả lời đúng: " + Count, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkAnswer(Question question, Answer selectedAnswer) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (selectedAnswer.getCorrect()) {
                    // Correct answer
                    nextQuestion();
                    Count++; // Increase the count for correct answers
                } else {
                    // Incorrect answer
                    showAnswerCorrect(question);
                    nextQuestion();
                }
            }
        }, 1000);
    }


    private void showAnswerCorrect(Question question1) {
        if (question1 == null || question1.getListAnswer() == null || question1.getListAnswer().isEmpty()) {
            return;
        }
        if (question1.getListAnswer().get(0).getCorrect()) {
            btn1.setBackgroundResource(R.drawable.bg_green_corner_30);
        } else if (question1.getListAnswer().get(1).getCorrect()) {
            btn2.setBackgroundResource(R.drawable.bg_green_corner_30);
        } else if (question1.getListAnswer().get(2).getCorrect()) {
            btn3.setBackgroundResource(R.drawable.bg_green_corner_30);
        } else if (question1.getListAnswer().get(3).getCorrect()) {
            btn4.setBackgroundResource(R.drawable.bg_green_corner_30);
        }
    }

    private void nextQuestion() {
        if (currentQuestion == mListQuestion.size() - 1) {
            showAnswerCorrect(mListQuestion.get(currentQuestion));
            // Hiển thị thông báo số câu trả lời đúng trong Android Studio
            Toast.makeText(MainActivity.this, "Số câu trả lời đúng: " + Count, Toast.LENGTH_SHORT).show();
        } else {
            currentQuestion++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setDataQuestion(mListQuestion.get(currentQuestion));
                }
            }, 1000);
        }
    }
}