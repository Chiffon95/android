package com.example.s20210402_sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chB = (CheckBox)findViewById(R.id.chB_sound);
//        chB.setOnCheckedChangeListener(onResumeListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = getSharedPreferences(
                "com.example.s20210402_sharedpreference.sound", MODE_PRIVATE);
        boolean bSound = pref.getBoolean("sound", false);

        chB = (CheckBox)findViewById(R.id.chB_sound);
        chB.setChecked(bSound);

        pref.registerOnSharedPreferenceChangeListener(myListener);
    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getSharedPreferences("sharedpreferences", MODE_PRIVATE);
        pref.unregisterOnSharedPreferenceChangeListener(myListener);
    }

    SharedPreferences.OnSharedPreferenceChangeListener myListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            boolean bSound = sharedPreferences.getBoolean(key, false);
            String str = (bSound) ? "설정" : "해제";
            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    };
//    CompoundButton.OnCheckedChangeListener onResumeListener = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            SharedPreferences pref = getSharedPreferences(
//                    "com.example.s20210402_sharedpreference.sound", MODE_PRIVATE);
//            SharedPreferences.Editor editor = pref.edit();
//            editor.putBoolean("sound", isChecked);
//            editor.commit();
//        }
//    };


}