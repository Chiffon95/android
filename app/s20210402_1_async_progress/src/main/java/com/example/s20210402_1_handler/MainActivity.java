package com.example.s20210402_1_handler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb_1);
        btn = (Button)findViewById(R.id.btn_start);
    }

    public void onClickStart(View v){
        int max = pb.getMax();
        new AccumulateTask().execute(max);
        btn.setClickable(false);
    }

    class AccumulateTask extends AsyncTask<Integer, Integer, String>{

        static final String RESULT_SUCCESS = "SUCCESS";
        int progress = 0;

        @Override
        protected void onPreExecute() {
            progress = 0;
        }

        @Override
        protected String doInBackground(Integer... integers) {

            while(isCancelled() == false){
                progress++;
                if (progress <= integers[0]){
                    publishProgress(progress);
                }else{ break; }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return RESULT_SUCCESS;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String string) {
            Toast.makeText(MainActivity.this,string, Toast.LENGTH_SHORT).show();
            btn.setClickable(true);
        }
    }
}