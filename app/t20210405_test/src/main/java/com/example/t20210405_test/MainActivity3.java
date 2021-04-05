package com.example.t20210405_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.t20210405_test.UserCode.ACT2;
import static com.example.t20210405_test.UserCode.RESULT_CODE_ACT2;

public class MainActivity3 extends AppCompatActivity {

    UserInfo userInfo = new UserInfo();
    Intent intent;
    TextView tv;
    CheckBox checkBox;
    EditText et_name;
    EditText et_address;
    EditText et_phone;
    LinearLayout linearLayout;
    RelativeLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        intent = getIntent();
        userInfo = (UserInfo)intent.getSerializableExtra(ACT2);

        checkBox = (CheckBox)findViewById(R.id.act3_checkBox);
        et_name = (EditText)findViewById(R.id.act3_et_name);
        et_address = (EditText)findViewById(R.id.act3_et_address);
        et_phone = (EditText)findViewById(R.id.act3_et_phone);
        linearLayout = (LinearLayout)findViewById(R.id.act3_liLayout);
        gridLayout = (RelativeLayout)findViewById(R.id.act3_reLayout);
        linearLayout.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.INVISIBLE);

        tv = (TextView)findViewById(R.id.act3_tv_date);
        tv.setText(userInfo.date);
        tv = (TextView)findViewById(R.id.act3_tv_time);
        tv.setText(userInfo.time);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    gridLayout.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
                }else{
                    linearLayout.setVisibility(View.INVISIBLE);
                    gridLayout.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void onClickSave_act3(View view){
        UserInfo user = new UserInfo();
        user.name = et_name.getText().toString();
        user.address = et_address.getText().toString();
        user.phone = et_phone.getText().toString();

        intent.putExtra(ACT2,user);
        setResult(RESULT_CODE_ACT2, intent);

        finish();
    }
    public void onClickCancel_act3(View view){
        finish();
    }
    public void onClickReset(View view){
        et_name.setText("");
        et_address.setText("");
        et_phone.setText("");
    }
}