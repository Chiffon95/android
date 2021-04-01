package com.example.s20210401_accumulatetask_2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int value = 0;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_ms);

    }

    public  void onClick (View v){
        AccumulateTask myTask = new AccumulateTask();
        myTask.execute(900);
    }

    class AccumulateTask extends AsyncTask<Integer, Integer, Integer>{

        @Override
        protected void onPreExecute() {
            value = 0;
            Log.i("chiffon95","onPreExecute >> value : " + value);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while (isCancelled() == false){
                value++;
                if(value <= integers[0]){
                    publishProgress(value);
                } else { break; }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if(values[0] >= 60){
                tv.setText("00");
                Log.i("chiffon95","onPreExecute >> value : " + values[0]);
                tv = (TextView)findViewById(R.id.tv_s);
                int sec = Integer.parseInt(tv.getText().toString());
                if(sec >= 60){
                    tv.setText("00");
                    tv = (TextView)findViewById(R.id.tv_m);
                    sec = Integer.parseInt(tv.getText().toString());
                }
                tv.setText( (sec < 10) ? "0" + (sec + 1) : (sec + 1) + "");
                Log.i("chiffon95","onPreExecute >> sec : " + sec);

            }else { tv.setText( (values[0] < 10) ? "0" + (values[0] + 1) : (values[0] + 1) + ""); }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            tv.setText("00");
        }
    }
}