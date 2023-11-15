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
    private Button stopTimer;
    private long timerInput = 1000000;
    private long currentTime = 1000;
    private boolean ButtonState = false;

    CountDownTimer AirsoftGameTime;

    NumberFormat TimerFormat = new DecimalFormat("00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameTimer = findViewById(R.id.TV_Timer);
        startTimer = findViewById(R.id.BTN_StartTimer);
        stopTimer = findViewById(R.id.BTN_Stop);

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ButtonState == true){
                    timerResume();
                    stopTimer.setText("Pause");
                    startTimer.setText("Start");
                    ButtonState = false;
                }
                else{
                    timerstart(timerInput);
                }

            }
        });

        stopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonState == false) {
                    timerPause();
                    ButtonState = true;
                    stopTimer.setText("Reset");
                    startTimer.setText("Resume");
                    gameTimer.setText(TimerFormat.format((currentTime / 3600000) % 24) + ":" + TimerFormat.format((currentTime / 60000) % 60) + ":" + TimerFormat.format((currentTime / 1000) % 60));
                } else {
                    AirsoftGameTime.cancel();
                    ButtonState = false;
                    stopTimer.setText("Pause");
                    startTimer.setText("Start");
                    gameTimer.setText(TimerFormat.format((timerInput / 3600000) % 24) + ":" + TimerFormat.format((timerInput / 60000) % 60) + ":" + TimerFormat.format((timerInput / 1000) % 60));
                }

            }
        });

    }
    public void timerstart(long timeinMilli) {
        AirsoftGameTime = new CountDownTimer(timerInput, 1000) {
            public void onTick(long millisUntilFinished) {
                currentTime = millisUntilFinished;
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                gameTimer.setText(TimerFormat.format(hour) + ":" + TimerFormat.format(min) + ":" + TimerFormat.format(sec));
            }

            public void onFinish() {
                gameTimer.setText("00:00:00");
            }
        };
        AirsoftGameTime.start();
    }

    public void timerPause() {
        AirsoftGameTime.cancel();
    }

    public void timerResume(){
        timerstart(currentTime);
    }

}
