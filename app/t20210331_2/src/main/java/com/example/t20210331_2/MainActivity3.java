package com.example.t20210331_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.t20210331_2.UserCheck.POSITION;
import static com.example.t20210331_2.UserCheck.RESULT_C0DE_USER_NOTIFY;
import static com.example.t20210331_2.UserCheck.RESULT_C0DE_USER_REMOVE;
import static com.example.t20210331_2.UserCheck.USER_INFO;

public class MainActivity3 extends AppCompatActivity {

    private Toast toast = null;
    UserInfo user = new UserInfo();
    Button btn;
    EditText et;
    RadioGroup rg;
    int position;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        intent = getIntent();
        user = (UserInfo) intent.getSerializableExtra(USER_INFO);
        position = intent.getIntExtra(POSITION, -1);

        et = (EditText) findViewById(R.id.layout3_et_name);
        et.setText(user.name);
        et = (EditText) findViewById(R.id.layout3_et_phone);
        et.setText(user.phone);

        rg = (RadioGroup) findViewById(R.id.layout3_rg);

        if (user.subject == R.drawable.google_free_icon_one) {
            rg.check(R.id.layout3_rb_1);
        } else if (user.subject == R.drawable.google_free_icon_two) {
            rg.check(R.id.layout3_rb_2);
        } else if (user.subject == R.drawable.google_free_icon_three) {
            rg.check(R.id.layout3_rb_3);
        } else if (user.subject == R.drawable.google_free_icon_four) {
            rg.check(R.id.layout3_rb_4);
        }
    }


    public void onClickNotify(View v){
        et = (EditText)findViewById(R.id.layout3_et_name);
        user.name = et.getText().toString();
        et = (EditText)findViewById(R.id.layout3_et_phone);
        user.phone = et.getText().toString();

        if(user.name == null || user.name == "" || user.name.length() == 0){
            toastShow("이름을 입력하세요");
            return;
        }else if (user.phone == null || user.phone == "" || user.phone.length() == 0){
            toastShow("번호를 입력하세요");
            return;
        }

        if(rg.getCheckedRadioButtonId() == R.id.layout3_rb_1){
            user.subject = R.drawable.google_free_icon_one;
        }else if(rg.getCheckedRadioButtonId() == R.id.layout3_rb_2){
            user.subject = R.drawable.google_free_icon_two;
        }else if(rg.getCheckedRadioButtonId() == R.id.layout3_rb_3){
            user.subject = R.drawable.google_free_icon_three;
        }else if(rg.getCheckedRadioButtonId() == R.id.layout3_rb_4){
            user.subject = R.drawable.google_free_icon_four;
        }else { user.subject = R.drawable.google_free_icon_portrait; }

        intent.putExtra(USER_INFO, user).putExtra(POSITION,position);
        setResult(RESULT_C0DE_USER_NOTIFY, intent);

        finish();
    }

    public void onClickRemove(View v){
        intent.putExtra(POSITION,position);
        setResult(RESULT_C0DE_USER_REMOVE, intent);

        finish();
    }

    public void onClickCancel(View v){
        setResult(RESULT_CANCELED);

        finish();
    }

    private void toastShow(String message) {
        if (toast == null) {
            toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}