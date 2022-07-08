package com.mont.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizGame extends AppCompatActivity implements View.OnClickListener{

    private TextView tvquestion;
    private Button btn1, btn2, btn3, btn4, btnsub;

    private int indexQuest = 0, score = 0;
    private final int totalQuestion = QuestionsAnswers.question.length;
    private String choicedAnswer = "";

    public static final String SCORE_POINTS = "SCORE_POINTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvquestion = findViewById(R.id.question);
        btn1 = findViewById(R.id.btn_op1);
        btn2 = findViewById(R.id.btn_op2);
        btn3 = findViewById(R.id.btn_op3);
        btn4 = findViewById(R.id.btn_op4);
        btnsub = findViewById(R.id.btn_sub);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnsub.setOnClickListener(this);

        orgInfor();
    }

    @Override
    public void onClick(View v) {
        btn1.setBackgroundColor(Color.WHITE);
        btn2.setBackgroundColor(Color.WHITE);
        btn3.setBackgroundColor(Color.WHITE);
        btn4.setBackgroundColor(Color.WHITE);

        Button ClickedButton = (Button) v;
        if (v.getId() == R.id.btn_sub){
            if (choicedAnswer.equals(QuestionsAnswers.correctAnswers[indexQuest])){
                score++;
            }

            indexQuest++;
            orgInfor();

        } else{
            choicedAnswer = ClickedButton.getText().toString();
            ClickedButton.setBackgroundColor(Color.YELLOW);
        }
    }

    public void orgInfor(){
        if (indexQuest == totalQuestion){
            finishQuiz();
            return;
        }else{
            tvquestion.setText(QuestionsAnswers.question[indexQuest]);
            btn1.setText(QuestionsAnswers.choices[indexQuest][0]);
            btn2.setText(QuestionsAnswers.choices[indexQuest][1]);
            btn3.setText(QuestionsAnswers.choices[indexQuest][2]);
            btn4.setText(QuestionsAnswers.choices[indexQuest][3]);
        }
    }

    public void finishQuiz(){
        Intent intent = new Intent(this, FinishQuiz.class);
        intent.putExtra(SCORE_POINTS, score);
        startActivity(intent);
    }
}