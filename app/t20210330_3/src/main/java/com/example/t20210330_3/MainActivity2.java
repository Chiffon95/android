package com.example.t20210330_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = (EditText)findViewById(R.id.et_name);
        button = (Button)findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra(NameCheck.USER_NAME, editText.getText().toString());
                setResult( RESULT_OK, intent);

                finish();
            }
        });

        button = (Button)findViewById(R.id.btn_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                setResult(RESULT_CANCELED, intent);

                finish();
            }
        });
    }
}