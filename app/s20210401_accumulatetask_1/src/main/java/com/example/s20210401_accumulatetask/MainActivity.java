package com.example.s20210401_accumulatetask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick (View v){
        AccumulateTask myTask = new AccumulateTask();
        myTask.execute(50);
    }

    class AccumulateTask extends AsyncTask<Integer, String, Long>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("chiffon95","onPreExecute");
        }

        @Override
        protected Long doInBackground(Integer... integers) {
            Log.i("chiffon95","doInBackground : " + integers[0]);
            publishProgress("hello");
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.i("chiffon95","onProgressUpdate : " + values[0]);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Log.i("chiffon95","onPostExecute : " + aLong);
        }
    }
}