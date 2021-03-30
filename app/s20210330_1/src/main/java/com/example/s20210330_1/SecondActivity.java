package com.example.s20210330_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();
        int myScore = i.getIntExtra("score", -1);
        String name = i.getStringExtra("id");
        ArrayList<UserInfo> arrayList = (ArrayList<UserInfo>)i.getSerializableExtra("userInfo");

        TextView tv = (TextView)findViewById(R.id.tv_info);
        tv.setText(arrayList.toString());

        Log.i("chiffon95", "extra : " + name + ", " + myScore);
    }
}