package com.example.s20210404_study_for_test;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CODE_TEST = 11;
    Button btn_start;

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("chiffon95", "Configuration : landscape");
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("chiffon95", "Configuration : portrait");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button)findViewById(R.id.activity1_btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                EditText et = (EditText)findViewById(R.id.activity1_et_str_to_activity2);
                String str = et.getText().toString();
                et.setText("");

                intent.putExtra("next_activity",str);
                startActivityForResult(intent, REQUEST_CODE_TEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_TEST) {
            if (resultCode == RESULT_OK) {
                TextView tv = (TextView) findViewById(R.id.activity1_tv_main);
                tv.setText(data.getStringExtra("next_activity"));
            }
        }
    }
}