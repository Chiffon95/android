package com.example.simple_bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Bingo extends AppCompatActivity {

    static final int PINK = Color.rgb(246, 154, 154);
    static final int SKYBLUE = Color.rgb(154, 246, 246);

    int arrIds[] = {R.id.tv_00, R.id.tv_01, R.id.tv_02, R.id.tv_03,
            R.id.tv_10, R.id.tv_11, R.id.tv_12, R.id.tv_13,
            R.id.tv_20, R.id.tv_21, R.id.tv_22, R.id.tv_23,
            R.id.tv_30, R.id.tv_31, R.id.tv_32, R.id.tv_33};

    boolean arrBoolean[] = new boolean[arrIds.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo);

        TextView tv;
        for(int i = 0; i < arrIds.length; i++){
            tv = (TextView)findViewById(arrIds[i]);
            tv.setText(i + 1 + "");
            tv.setBackgroundColor(SKYBLUE);
        }
    }

    public void onClick(View v) {
        ((TextView)v).setBackgroundColor(PINK);
        Log.i("chiffon95", "onClick : " + ((TextView)v).getText().toString());
        arrBoolean[v.findViewById()];
    }

    public void btnFinish(View v){
        int row = (int)Math.sqrt(arrIds.length);
        int col = (int)Math.sqrt(arrIds.length);

        TextView tv;
        for (int i = 0; i < row; i++){
            tv = (TextView)findViewById(arrIds[i]);
        }
    }

    public void btnStart(View v){
        TextView tv, tv2;
        for(int i = 0; i < arrIds.length; i++){

            int random = (int)(Math.random() * 16);
            tv = (TextView)findViewById(arrIds[i]);
            tv2 = ((TextView)findViewById(arrIds[random]));

            String temp = tv.getText().toString();
            tv.setText(tv2.getText().toString());
            tv2.setText(temp);
            tv.setBackgroundColor(SKYBLUE);
        }
    }
    public void btnCancel(View v){

    }

    String[] arrNum(){
        String str[] = new String[arrIds.length];
        for(int i = 0; i < str.length; i++){
            str[i] = i + 1 + "";
        }
        return str;
    }
}