package com.example.s20210401_handler_runnable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_text);
    }

    void onClickStart3(View v){

        cnt = 0;
        tv.setText("Count :" + cnt);

        Thread th_cnt = new Thread("Count Thread"){
            @Override
            public void run() {
                super.run();
            }
        };
    }

    void onClickStop3(View v){

    }
}