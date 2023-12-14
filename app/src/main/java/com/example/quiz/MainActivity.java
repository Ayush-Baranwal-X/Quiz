package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"Is Java a person?", "Was Java introduced in 1823?", "Was Java created using python?", "Does Java has abstract classes?", "Does Java support inheritance?"};
    private boolean[] answers = {false,false,false,true,true};
    private  int score = 0;
    private int index = 0;
    private int n = 0;
    Button yes;
    Button no;
    Button restart;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        restart = findViewById(R.id.restart);
        question = findViewById(R.id.question);
        restart.setVisibility(View.INVISIBLE);
        question.setText(questions[index]);
        n = questions.length;
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index] == true)
                {
                    score++;
                }
                if(index == n-1)
                {
                    question.setText("Your score is " + score + "/" + n);
                    yes.setVisibility(View.INVISIBLE);
                    no.setVisibility(View.INVISIBLE);
                    restart.setVisibility(View.VISIBLE);
                }
                else
                {
                    index++;
                    question.setText(questions[index]);
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answers[index] == false)
                {
                    score++;
                }
                if(index == n-1)
                {
                    question.setText("Your score is " + score + "/" + n);
                    yes.setVisibility(View.INVISIBLE);
                    no.setVisibility(View.INVISIBLE);
                    restart.setVisibility(View.VISIBLE);
                }
                else
                {
                    index++;
                    question.setText(questions[index]);
                }
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh = new Intent(MainActivity.this , MainActivity.class);
                startActivity(refresh);
            }
        });
    }
}