package com.example.for_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class For_Test_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for__test_1);

        Button btn_tv = (Button) findViewById(R.id.btn_txt_change);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)findViewById(R.id.tv);
                if (tv.getText().equals("Chnaged Text!"))
                    tv.setText("Hello World!");
                else
                    tv.setText("Chnaged Text!");
            }
        });

        Button btn_hide = (Button) findViewById(R.id.btn_hide_tv);
        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)findViewById(R.id.tv);
                if(tv.getVisibility() == View.VISIBLE)
                    tv.setVisibility(View.INVISIBLE);
                else
                    tv.setVisibility(View.VISIBLE);
            }
        });
    }
}