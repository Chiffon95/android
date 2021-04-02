package com.example.s20210402_countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyCountDownTimer countDownTimer;
    EditText et;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_s);
    }

    public void onClickStart(View v){
        et = (EditText)findViewById(R.id.et_timer);
        int sec = Integer.parseInt(et.getText().toString());
        int millislnFuture = sec * 1000;

        tv.setText(sec + "초");
        countDownTimer = new MyCountDownTimer(millislnFuture, 1000);
        countDownTimer.start();
    }

    class MyCountDownTimer extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText(millisUntilFinished/1000 + "초");
        }

        @Override
        public void onFinish() {
            tv.setText("타이머 완료");
        }
    }
}