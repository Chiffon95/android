package com.example.t20210331_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.t20210331_1.UserCheck.POSITION;
import static com.example.t20210331_1.UserCheck.RESULT_C0DE_USER_NOTIFY;
import static com.example.t20210331_1.UserCheck.RESULT_C0DE_USER_REMOVE;
import static com.example.t20210331_1.UserCheck.USER_INFO;

public class MainActivity3 extends AppCompatActivity {

    UserInfo userInfo;
    Intent intent;
    EditText et_name;
    EditText et_phone;
    Button button;
    RadioGroup radioGroup;
    RadioButton radioButton;

    int position = 0;
    int radioBtnId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        userInfo = new UserInfo();
        radioGroup = (RadioGroup)findViewById(R.id.layout3_rg);
        et_name = (EditText)findViewById(R.id.layout3_et_name);
        et_phone = (EditText)findViewById(R.id.layout3_et_phone);

        intent = getIntent();
        userInfo = (UserInfo)intent.getSerializableExtra(USER_INFO);
        position = intent.getIntExtra(POSITION, -1);
        radioBtnId = userInfo.subject;

        et_name.setText(userInfo.name);
        et_phone.setText(userInfo.phone);
        ((RadioButton)findViewById(radioBtnId)).setChecked(true);

        button = (Button)findViewById(R.id.layout3_btn_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);

                finish();
            }
        });

        button = (Button)findViewById(R.id.layout3_btn_notify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo.name = et_name.getText().toString();
                userInfo.phone = et_phone.getText().toString();
                position = intent.getIntExtra(POSITION, -1);
                radioBtnId = radioGroup.getCheckedRadioButtonId();
                userInfo.subject = radioBtnId;

                intent.putExtra(USER_INFO, userInfo)
                        .putExtra(POSITION, position);
                setResult(RESULT_C0DE_USER_NOTIFY, intent);

                finish();
            }
        });

        button = (Button)findViewById(R.id.layout3_btn_remove);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = intent.getIntExtra(POSITION, -1);
                intent.putExtra(POSITION, position);
                setResult(RESULT_C0DE_USER_REMOVE, intent);

                finish();
            }
        });
    }
}