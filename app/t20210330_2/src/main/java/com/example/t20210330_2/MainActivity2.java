package com.example.t20210330_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick(View view){
        Intent intent = new Intent();
        intent.putExtra("result", 100);
        setResult(RESULT_OK, intent);

        finish();

        Log.i("chiffon95", "MainActivity2 >> onClick");
    }
}