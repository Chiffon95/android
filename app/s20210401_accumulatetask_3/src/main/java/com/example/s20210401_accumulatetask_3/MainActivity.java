package com.example.s20210401_accumulatetask_3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    long value;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView) findViewById(R.id.tv);
    }

    public void onClick(View view) {
        AccumulateTask myTask = new AccumulateTask();
        myTask.execute(50);
    }

    class AccumulateTask extends AsyncTask<Integer, String, Long> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            value = 0;
        }

        @Override
        protected Long doInBackground(Integer... integers) {
            while (isCancelled() == false) {
                value++;
                if (value <= integers[0]) {
                    publishProgress(value + "");
                } else {
                    break;
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return value;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mText.setText(values[0]);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            mText.setText("success!!"+aLong);
            Log.i("yun", "작업을 마친 후 변환 값은 " + aLong+"입니다.");
        }
    }

}