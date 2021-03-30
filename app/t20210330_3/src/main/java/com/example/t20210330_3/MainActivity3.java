package com.example.t20210330_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity3 extends AppCompatActivity {

    int position = 0;
    Button button;
    EditText editText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        intent = getIntent();
        String str_name = intent.getStringExtra(NameCheck.USER_NAME2);

        editText = (EditText)findViewById(R.id.layout3_et_name);
        editText.setText(str_name);

        button = (Button)findViewById(R.id.layout3_btn_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = getIntent();
                setResult(RESULT_CANCELED,intent);

                finish();
            }
        });

        button = (Button)findViewById(R.id.layout3_btn_remove);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = getIntent();
                position = intent.getIntExtra(NameCheck.POSITION, -1);
                intent.putExtra(NameCheck.POSITION, position);
                setResult(NameCheck.MY_RESULT_CODE_REMOVE, intent);

                finish();
            }
        });

        button = (Button)findViewById(R.id.layout3_btn_notify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = getIntent();
                String str_notify = ((EditText)findViewById(R.id.layout3_et_name)).getText().toString();
                position = intent.getIntExtra(NameCheck.POSITION, -1);

                intent.putExtra(NameCheck.POSITION, position)
                        .putExtra(NameCheck.USER_NAME2, str_notify);
                setResult(NameCheck.MY_RESULT_CODE_NOTIFY, intent);

                finish();
            }
        });
    }
}