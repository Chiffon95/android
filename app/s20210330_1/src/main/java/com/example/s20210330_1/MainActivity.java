package com.example.s20210330_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("chiffon95", "Landscape");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("chiffon95", "Portrait");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("chiffon95", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("chiffon95", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("chiffon95", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("chiffon95", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("chiffon95", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("chiffon95", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("chiffon95", "onDestroy");
    }

    ArrayList<UserInfo> arrayList = new ArrayList();
    public void onClick(View view){

        UserInfo userInfo = new UserInfo();

        userInfo.name = "최현학";
        userInfo.email = "a@naver.com";
        userInfo.phone = "01023232323";
        userInfo.address = "천안";
        userInfo.user = "안녕하세요";

        arrayList.add(userInfo);
        arrayList.add(userInfo);

        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("score", 90).putExtra("id", "최현학")
        .putExtra("userInfo",arrayList);
        startActivity(i);
    }
}
class UserInfo implements Serializable {
    String name;
    String email;
    String phone;
    String address;
    String user;

    @NonNull
    @Override
    public String toString() {
        return name + ", " + email + ", " + phone + ", " + address + ", " + user;
    }
}