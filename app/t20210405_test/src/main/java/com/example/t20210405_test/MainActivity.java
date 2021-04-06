package com.example.t20210405_test;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb_main;
    ImageView iv_logo;
    Button btn_admin;
    boolean acstop;
    int progress;
    int proStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb_main = (ProgressBar)findViewById(R.id.act1_pb);
        iv_logo = (ImageView)findViewById(R.id.act1_iv_logo);
        btn_admin = (Button)findViewById(R.id.act1_btn_admin);
        progress = 0;

        int max = pb_main.getMax();
        new AccumulateTask().execute(max);
    }

    @Override
    protected void onPause() {
        super.onPause();
        acstop = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        acstop = true;
    }

    public void onClickAdmin(View view){
        onPause();
        Intent intent = new Intent(MainActivity.this, MainActivity4.class);
        startActivity(intent);
    }

    class AccumulateTask extends AsyncTask<Integer, Integer, String>{

        static final String str = "로딩이 완료되었습니다!";

        @Override
        protected void onPreExecute() { progress = 0; }

        @Override
        protected String doInBackground(Integer... integers) {
            while (progress < integers[0]){
                if(!acstop){
                    progress += 0;
                }else{
                    progress++;
                }
                publishProgress(progress);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb_main.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String str) {

            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            finish();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

    }
}