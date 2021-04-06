package com.example.t20210406_sqlite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Intent intent;
    EditText et_cou;
    EditText et_cap;
    Button btn_ok;
    Button btn_cancel;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        intent = getIntent();
        id = intent.getIntExtra("id", -1);
        String strCou = intent.getStringExtra("country");
        String strCap = intent.getStringExtra("capital");

        et_cou = (EditText)findViewById(R.id.act_update_country);
        et_cap = (EditText)findViewById(R.id.act_update_capital);
        btn_cancel = (Button)findViewById(R.id.act_update_btn_cancel);
        btn_ok = (Button)findViewById(R.id.act_update_btn_ok);

        et_cou.setText(strCou); et_cap.setText(strCap);
    }

    public void onClickOKUpdate(View view){
        Intent intent1 = new Intent();
        intent1.putExtra("country", et_cou.getText().toString().trim())
                .putExtra("capital", et_cap.getText().toString().trim())
                .putExtra("id",id);
        setResult(RESULT_OK,intent1);

        finish();
    }
    public void onClickCancelUpdate(View view){
        finish();
    }
}