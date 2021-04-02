package com.example.t20210402_timertest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer = new Timer();
    TimerTask tickTask;
    TimerTask finishTask;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.et_timer);
    }

    public void onClickStart(View v){
        String str = et.getText().toString();
        int timeGet = Integer.parseInt(et.getText().toString());
        int timeH, timeM, timeS;
        timeH = timeGet / 3600;
        timeM = timeGet / 60;
        timeS = timeGet % 60;

        tickTask = new TimerTask() {
            @Override
            public void run() {
                int count = 0;

                Log.i("chiffon95", "task");
            }
        };
        finishTask = new TimerTask() {
            @Override
            public void run() {
                Log.i("chiffon95", "finishTask");
            }
        };
        timer.schedule(finishTask, timeGet * 1000);
        timer.schedule(tickTask, 0, 1000);

        Toast.makeText(MainActivity.this, timeH + "시간 " + timeM + "분 "
        + timeS + "초 후에 알림이 실행됩니다.", Toast.LENGTH_LONG).show();
    }
    public void onClickCancel(View v){
        if(tickTask != null){
            tickTask.cancel();
            tickTask = null;
        }

        if(finishTask != null){
            finishTask.cancel();
            finishTask = null;
        }
    }
    public void onClickStop(View v){
        if(tickTask != null){
            tickTask.cancel();
            tickTask = null;
        }

        if(finishTask != null){
            finishTask.cancel();
            finishTask = null;
        }
    }
}