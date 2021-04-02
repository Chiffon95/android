package com.example.t20210402_sharedpreference;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv_name;
    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (TextView)findViewById(R.id.tv_userName);
        readUserName();
    }

    public void onClickInput(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("이름입력");
        dialog.setMessage("사용자의 이름을 입력합니다.");

        EditText dialog_et = new EditText(this);
        dialog.setView(dialog_et);

        String str = et_name.getText().toString();
        dialog_et.setText(str);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = dialog_et.getText().toString();
                writeUserName(str);
                readUserName();
            }
        });

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                readUserName();
            }
        });

        dialog.show();
    }

    void readUserName(){
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String str_name = pref.getString("user_name", "unknown");
        tv_name.setText(str_name);
    }
    void writeUserName(String name){
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("user_name", name);
        editor.commit();
    }
}