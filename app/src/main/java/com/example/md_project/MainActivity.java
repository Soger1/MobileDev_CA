package com.example.md_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gameTimer;
    private Button startTimer;
    private Button stopTimer;
    private long timerInput = 1500000;
    private long currentTime = 1000;
    Timer GameLenTimer; // Timer object handles all thing to do with countdown timer


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameTimer = findViewById(R.id.TV_Timer);
        startTimer = findViewById(R.id.BTN_StartTimer);
        stopTimer = findViewById(R.id.BTN_Stop);
        GameLenTimer = new Timer(gameTimer);
        gameTimer.setText("00:25:00");

        //Start Stop Pause Buttons
        startTimer.setOnClickListener(new View.OnClickListener() { //Start Button
            @Override
            public void onClick(View view) {
                if(startTimer.getText().equals("Start")){
                    GameLenTimer.timer_start(timerInput);
                }else{
                    GameLenTimer.timerResume();
                    stopTimer.setText("Pause");
                    startTimer.setText("Start");
                }

            }
        });

        stopTimer.setOnClickListener(new View.OnClickListener() { //Stop Button
            @Override
            public void onClick(View v) {
                if (stopTimer.getText().equals("Pause")) {
                    GameLenTimer.timerPause();
                    stopTimer.setText("Reset");
                    startTimer.setText("Resume");
                    gameTimer.setText(GameLenTimer.getTimerString());
                } else {
                    GameLenTimer.timerstop();
                    stopTimer.setText("Pause");
                    startTimer.setText("Start");
                    gameTimer.setText(GameLenTimer.getTimerString());
                }
            }
        });
    }
}
