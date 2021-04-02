package com.example.s20210401_thread_handler;

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
    Handler handler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(@NonNull Message msg) {

            if(msg.what == WHAT_HANDLER_MSG_COUNT && msg.arg1 < 5){
                msg.arg1++;
                tv = (TextView)findViewById(R.id.tv_text);
                tv.setText(msg.arg1 + "초");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_text);

    }

    public void onClickStart(View v) {
        int count = 0;

        Thread th_count = new Thread(){
            @Override
            public void run() {

                for(int i = 0; i < 5; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = handler.obtainMessage(WHAT_HANDLER_MSG_COUNT, count);
                    handler.sendMessage(msg);
                    Log.i("chiffon95", " onClickStart Run count : " + count);
                }
            }
        };
        th_count.start();
    }

    public void onClickStop(View v) {
        int count = 0;

        handler.removeMessages(WHAT_HANDLER_MSG_COUNT);
        Toast.makeText(this, "onClickStop Count : " + (count + 1),
                Toast.LENGTH_LONG).show();
    }
}