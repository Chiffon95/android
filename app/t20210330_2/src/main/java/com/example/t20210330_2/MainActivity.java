package com.example.t20210330_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CODE_START_INPUT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivityForResult(intent, REQUEST_CODE_START_INPUT);

        Log.i("chiffon95", "onClick");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("chiffon95", "onActivityResult");
    }
}