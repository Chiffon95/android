package com.example.t20210405_test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    static final String PREF_FILE_NAME = "admin";
    static final String PREF_NAME = "admin_pw";
    SharedPreferences pref;
    Intent intent;
    EditText et_save;
    EditText et_new;
    Button btn_save;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        intent = getIntent();

        et_save = (EditText)findViewById(R.id.act4_et_currentAdminPw);
        et_new = (EditText)findViewById(R.id.act4_et_changedAdminPw);
        btn_save = (Button)findViewById(R.id.act4_btn_save);
        btn_cancel = (Button)findViewById(R.id.act4_btn_cancel);

        pref = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
        String str = pref.getString(PREF_NAME, "0000");
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREF_NAME, str);
        editor.commit();
    }

    public void onClickSave(View view){

        String str = pref.getString(PREF_NAME, "0000").trim();
        String strCurrent = et_save.getText().toString().trim();
        String strNew = et_new.getText().toString().trim();
        SharedPreferences.Editor editor = pref.edit();

        if(str.equals(strCurrent)){
            editor.putString(PREF_NAME, strNew);
            editor.apply();
            Toast.makeText(MainActivity4.this, "비밀번호가 변경되었습니다.",
                    Toast.LENGTH_SHORT).show();
            et_new.setText(""); et_save.setText("");

            finish();
        }else{
            Toast.makeText(MainActivity4.this, "비밀번호가 틀립니다.",
                    Toast.LENGTH_SHORT).show();
            et_new.setText(""); et_save.setText("");
        }
    }

    public void onClickCancel(View view){
        finish();
    }
}