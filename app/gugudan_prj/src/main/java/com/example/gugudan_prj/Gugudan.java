package com.example.gugudan_prj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Gugudan extends AppCompatActivity {

    int[] arrBtn = {R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9,
            R.id.btn_del, R.id.btn_0, R.id.btn_ent};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gugudan);
        question();
    }
    void question(){
        TextView tv = (TextView)findViewById(R.id.tv_question_left);
        TextView tv2 = (TextView)findViewById(R.id.tv_question_right);

        int numLeft, numRight;

        numLeft = (int)(Math.random() * 8) + 2;
        numRight= (int)(Math.random() * 9) + 1;

        tv.setText(numLeft + "");
        tv2.setText(numRight + "");
        Log.i("chiffon95", "question : " + numLeft + " x " + numRight);
    }

    public void onClick(View v) {
        TextView tv;
        tv = (TextView)findViewById(R.id.tv_answer);

        if (((TextView)v).getText().equals("DEL")){
            tv.setText("");
        }else if (((TextView)v).getText().equals("ENT")){
            btnENT(tv);
            tv.setText("");
        }else{
            tv.append(((TextView)v).getText().toString());
        }

        Log.i("chiffon95", "onClick : " + ((TextView)v).getText().toString());
    }

    void btnENT(TextView tv){
        TextView tv2 = (TextView)findViewById(R.id.tv_question_left);
        TextView tv3 = (TextView)findViewById(R.id.tv_question_right);
        TextView tv4 = (TextView)findViewById(R.id.tv_result);

        int leftNum = Integer.parseInt(tv2.getText().toString());
        int rightNum = Integer.parseInt(tv3.getText().toString());
        int resultNum = leftNum * rightNum;

        tv4.setText(resultNum + "");

        int cnt = Integer.parseInt(((TextView)findViewById(R.id.answer_cnt)).getText().toString());
        int compareNum = Integer.parseInt(tv.getText().toString());

        if (compareNum == resultNum){
            cnt++;
            ((TextView)findViewById(R.id.answer_cnt)).setText(cnt + "");
        }
        question();

        Log.i("chiffon95", "btnENT : " + resultNum + " , cnt : " + cnt);
    }
}