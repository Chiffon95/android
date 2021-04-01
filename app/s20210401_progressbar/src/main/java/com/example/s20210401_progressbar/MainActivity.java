package com.example.s20210401_progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final int PROGRESSBAR_START = 1;

    ProgressBar pb;

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == PROGRESSBAR_START){
                if(pb.getProgress() < pb.getMax()){
                    pb.setProgress(pb.getProgress() + 2);
                    sendEmptyMessageDelayed(PROGRESSBAR_START, 50);
                }else if (pb.getProgress() == pb.getMax()){
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    pb.setProgress(0);
                    handler.removeMessages(PROGRESSBAR_START);
                }
            }
            Log.i("chiffon95", "handleMessage Progress : " + pb.getProgress());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb_1);
    }

    public void onClick(View v){
        handler.removeMessages(PROGRESSBAR_START);
        pb.setProgress(0);
        handler.sendEmptyMessage(PROGRESSBAR_START);
    }
}