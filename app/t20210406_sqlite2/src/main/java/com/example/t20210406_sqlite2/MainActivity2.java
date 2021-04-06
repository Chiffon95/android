package com.example.t20210406_sqlite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;
    EditText et_country;
    EditText et_capital;
    Button btn_ok;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_country = (EditText)findViewById(R.id.act_insert_et_country);
        et_capital = (EditText)findViewById(R.id.act_insert_et_capital);
        btn_ok = (Button)findViewById(R.id.act_insert_btn_ok);
        btn_cancel = (Button)findViewById(R.id.act_insert_btn_cancel);
    }

    public void onClickOK(View view){
        intent = new Intent();
        String str1 = et_country.getText().toString().trim();
        String str2 = et_capital.getText().toString().trim();

        intent.putExtra("country", str1).putExtra("capital", str2);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void onClickCancel(View view){
        finish();
    }
}