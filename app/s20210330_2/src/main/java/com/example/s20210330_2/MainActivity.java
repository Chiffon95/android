package com.example.s20210330_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickWeb(View view){

        EditText et = (EditText)findViewById(R.id.et_url);
        String str = et.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + str));
        startActivity(intent);
        et.setText("");
    }
    public void onClickWebSearch(View view){

        EditText et = (EditText)findViewById(R.id.et_search);
        String str = et.getText().toString();

        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, str);
        startActivity(intent);
        et.setText("");
    }

    public void onClickAlarm(View view){

        EditText et = (EditText)findViewById(R.id.et_alarm_h);
        EditText et2 = (EditText)findViewById(R.id.et_alarm_m);
        int hour = Integer.parseInt(et.getText().toString());
        int minutes = Integer.parseInt(et2.getText().toString());

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Test")
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        startActivity(intent);
        et.setText("");
        et2.setText("");
    }

    public void onClickDial(View view){

        EditText et = (EditText)findViewById(R.id.et_dial);
        String str = et.getText().toString();

        Uri uri = Uri.parse("tel:" + str);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
        et.setText("");
    }
}