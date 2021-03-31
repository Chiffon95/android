package com.example.s20210331_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = getIntent();
        String str = intent.getStringExtra(intent.EXTRA_TEXT);

        textView = (TextView)findViewById(R.id.tv_in_layout2);
        textView.setText(str);
    }
}