package com.mont.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnNova, btnConf, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNova = findViewById(R.id.btn_nova);
        btnConf = findViewById(R.id.btn_conf);
        btnSair = findViewById(R.id.btn_sair);

        btnNova.setOnClickListener(this);
        btnConf.setOnClickListener(this);
        btnSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btn_nova): novaPartida(); break;
            case (R.id.btn_conf): break;
            case (R.id.btn_sair): super.onBackPressed(); break;
        }
    }
    public void novaPartida(){
        Intent intent = new Intent(this, QuizGame.class);
        startActivity(intent);
    }
}