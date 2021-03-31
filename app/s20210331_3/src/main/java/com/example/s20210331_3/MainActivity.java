package com.example.s20210331_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View v){
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        String str = intent.getStringExtra("result");
        if (str.length() > 0) {
            ((TextView) findViewById(R.id.tv_result_activity1)).setText(str);
        }
    }
}