package com.mont.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishQuiz extends AppCompatActivity {

    private TextView tvCongratulations, tvCorrects;
    private Button btnBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_quiz);

        tvCongratulations = findViewById(R.id.end);
        tvCorrects = findViewById(R.id.corrects);
        btnBack = findViewById(R.id.btn_back);

        Intent intent = getIntent();
        int score = intent.getIntExtra(QuizGame.SCORE_POINTS, 0);
        int totalQuestions = QuestionsAnswers.question.length;

        if (score < totalQuestions * 0.6){
            tvCongratulations.setText("Que pena!");
        }

        tvCorrects.setText("Você acertou " + Integer.toString(score) + " de " +
                Integer.toString(totalQuestions) + ".");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}