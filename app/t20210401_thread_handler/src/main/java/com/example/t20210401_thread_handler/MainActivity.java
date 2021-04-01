package com.example.t20210401_thread_handler;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final int WHAT_HANDLER_MSG_COUNT = 1;
    TextView tv;
    Button btn;
    int count;
    long color;
    boolean bcontinue;
    Handler handler = new Handler(Looper.getMainLooper()){ //Looper.getMainLooper() 추가 할 것

        @Override
        public void handleMessage(@NonNull Message msg) {

            if(msg.what == WHAT_HANDLER_MSG_COUNT && msg.arg1 < 10){
                color = Color.argb((int)(Math.random() * 256), (int)(Math.random() * 256),
                        (int)(Math.random() * 256), (int)(Math.random() * 256));
                count++;
                tv.setText(count + "초, 색상 : " + color);
                tv.setBackgroundColor((int)color);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_text);

    }

    public void onClickStart2(View v) {
        bcontinue = true;
        count = 0;

        Thread th_count = new Thread(){
            @Override
            public void run() {

                for(int i = 0; i < 10; i++){

                    if (!bcontinue) break;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = handler.obtainMessage(WHAT_HANDLER_MSG_COUNT, count);
                    handler.sendMessage(msg);
                    Log.i("chiffon95", " onClickStart Run >>" +
                            "color : " + color + ", count : " + count);
                }
            }
        };
        th_count.start();
    }

    public void onClickStop2(View v) {

        bcontinue = false;
        handler.removeMessages(WHAT_HANDLER_MSG_COUNT);
        Toast.makeText(this, "onClickStop >>" +
                        "Color : " + color + ", Count : " + (count + 1),
                Toast.LENGTH_LONG).show();
    }
}