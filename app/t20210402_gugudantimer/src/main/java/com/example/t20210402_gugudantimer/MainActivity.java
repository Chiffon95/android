package com.example.t20210402_gugudantimer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
    Button btn_start = (Button)findViewById(R.id.btn_start);
    GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout_btns);
    TextView tv_result = (TextView)findViewById(R.id.tv_end_result);
    ProgressBar pb;
    Button btn;
    int cnt;
    int[] arrBtn = {R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9,
            R.id.btn_del, R.id.btn_0, R.id.btn_ent};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb_timer);
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setVisibility(View.VISIBLE);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void onClickStart(View v){
        int max = pb.getMax();
        btn_start.setVisibility(View.GONE);
        btn_start.setClickable(false);

        question();

        changeV
        for(int i = 0; i < arrBtn.length; i++){
           btn = (Button)findViewById(arrBtn[i]);
           btn.setVisibility(View.VISIBLE);
           btn.setEnabled(true);
        }
    }

    public void onClickReStart(View v){
        ((TextView)v).setVisibility(View.INVISIBLE);
        btn_start.setVisibility(View.VISIBLE);
        btn_start.setClickable(true);
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

    public void onClickBtn(View v) {
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

        cnt = Integer.parseInt(((TextView)findViewById(R.id.answer_cnt)).getText().toString());

        if (!tv.getText().toString().equals("") && tv.getText().toString().length() != 0){

            int compareNum = Integer.parseInt(tv.getText().toString());

            if (compareNum == resultNum){
                cnt++;
                ((TextView)findViewById(R.id.answer_cnt)).setText(cnt + "");
            }
        }

        Log.i("chiffon95", "btnENT : " + resultNum + " , cnt : " + cnt);
    }

    class Accumulate extends AsyncTask<Integer, Integer, String>{

        static final String STR = "";
        int progress = 0;
        @Override
        protected void onPreExecute() {
            progress = 0;
        }

        @Override
        protected String doInBackground(Integer... integers) {
            while(progress < integers[0]){
                progress++;
                publishProgress(progress);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return STR;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String endStr) {
            TextView tv = (TextView)findViewById(R.id.tv_end_result);

            for (int i = 0; i < arrBtn.length; i++){
                btn = (Button)findViewById(arrBtn[i]);
                btn.setVisibility(View.INVISIBLE);
                btn.setClickable(false);
            }

            tv.setVisibility(View.VISIBLE);
            tv.setText("1분간의 기록 : " + cnt + " 회");
        }
    }
}