package com.example.s20210401_handler_runnable;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    TextView tv;
    Button btn;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_text);
    }

    public void onClickStart3(View v){

        cnt = 0;
        tv.setText("Count :" + cnt);

        Thread th_cnt = new Thread("Count Thread"){
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(cnt + "초");
                        }
                    });
                    Log.i("chiffon95", "Count : " + cnt);
                }
            }
        };
        th_cnt.start();
    }

    public void onClickStop3(View v){

    }
}