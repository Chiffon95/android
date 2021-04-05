package com.example.s20210404_study_for_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    TextView tv;
    String str;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = getIntent();
        str = intent.getStringExtra("next_activity");
        tv = (TextView)findViewById(R.id.activity2_tv_main);
        tv.setText(str);

        btn = (Button)findViewById(R.id.activity2_btn_start);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.activity2_et_str_to_activity1);
                String string = editText.getText().toString();
                editText.setText("");

                Intent intent1 = new Intent();
                intent1.putExtra("next_activity",string);
                setResult(RESULT_OK, intent1);

                finish();
            }


        });

        btn = (Button)findViewById(R.id.activity2_btn_cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }


}