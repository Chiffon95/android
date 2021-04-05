package com.example.t20210405_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.t20210405_test.UserCode.ADMIN_DIAL;

public class MainActivity5 extends AppCompatActivity {


    Intent intent;
    UserInfo userInfo = new UserInfo();
    Button btn_ok;
    Button btn_Dial;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        intent = getIntent();
        userInfo = (UserInfo)intent.getSerializableExtra(ADMIN_DIAL);
        btn_ok = (Button)findViewById(R.id.act5_btn_ok);
        btn_Dial = (Button)findViewById(R.id.act1_btn_admin);

        tv = (TextView)findViewById(R.id.act5_tv_date);
        tv.setText(userInfo.date);
        tv = (TextView)findViewById(R.id.act5_tv_time);
        tv.setText(userInfo.time);
        tv = (TextView)findViewById(R.id.act5_tv_name);
        tv.setText(userInfo.name);
        tv = (TextView)findViewById(R.id.act5_tv_address);
        tv.setText(userInfo.address);
        tv = (TextView)findViewById(R.id.act5_tv_phone);
        tv.setText(userInfo.phone);
    }

    public void onClickOk(View view){
        finish();
    }
    public void onClickDial(View view){
        tv = (TextView)findViewById(R.id.act5_tv_phone);
        String str = tv.getText().toString();
        Uri uri = Uri.parse("tel:" + str);

        Intent intent1 = new Intent((Intent.ACTION_DIAL), uri);
        startActivity(intent1);
    }
}