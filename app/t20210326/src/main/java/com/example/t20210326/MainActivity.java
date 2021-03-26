package com.example.t20210326;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String str_motion[] = {"DOWN", "UP", "MOVE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rl = (RelativeLayout)findViewById(R.id.layout);
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("chiffon95", "RelativeLayout : " + str_motion[event.getAction()]);
                return false;
            }
        });

        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("chiffon95", "TextView : " + str_motion[event.getAction()]);
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("chiffon95", "TextView : " + str_motion[event.getAction()]);

        return super.onTouchEvent(event);
    }
}