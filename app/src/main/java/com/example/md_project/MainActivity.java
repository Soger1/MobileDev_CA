package com.example.md_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView gameTimer;
    private Button startTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameTimer = findViewById(R.id.TV_Timer);
        startTimer = findViewById(R.id.BTN_StartTimer);

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(50000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        NumberFormat TimerFormat = new DecimalFormat("00");
                        long hour = (millisUntilFinished / 3600000) % 24;
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        gameTimer.setText(TimerFormat.format(hour) + ":" + TimerFormat.format(min) + ":" + TimerFormat.format(sec));
                    }

                    public void onFinish() {
                        gameTimer.setText("00:00:00");
                    }
                }.start();
            }
        });
        }


    }
