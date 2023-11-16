package com.example.md_project;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Timer {
    private long timerInput = 1500000;
    private long currentTime = 1000;
    private long hour;
    private long min;
    private long sec;
    CountDownTimer timer;
    NumberFormat TimerFormat = new DecimalFormat("00");
    private TextView TimerText;

    public Timer(TextView input) {
        TimerText = input;
    }

    public void timer_start(long time) {
        timer = new CountDownTimer(timerInput, 1000) {
            public void onTick(long millisUntilFinished) {
                currentTime = millisUntilFinished;
                hour = (millisUntilFinished / 3600000) % 24;
                min = (millisUntilFinished / 60000) % 60;
                sec = (millisUntilFinished / 1000) % 60;
                TimerText.setText(TimerFormat.format((currentTime / 3600000) % 24) + ":" + TimerFormat.format((currentTime / 60000) % 60) + ":" + TimerFormat.format((currentTime / 1000) % 60));
            }

            public void onFinish() {

            }
        };
        timer.start();
    }
    public void timerstop() { timer.cancel();}

    public void timerPause() {
        timer.cancel();
    }

    public void timerResume(){
        timer_start(currentTime);
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public String getTimerString(){
        return (TimerFormat.format((currentTime / 3600000) % 24) + ":" + TimerFormat.format((currentTime / 60000) % 60) + ":" + TimerFormat.format((currentTime / 1000) % 60));
    }


}
