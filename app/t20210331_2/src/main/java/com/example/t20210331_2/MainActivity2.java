package com.example.t20210331_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.t20210331_2.UserCheck.RESULT_C0DE_USER_INFO;
import static com.example.t20210331_2.UserCheck.USER_INFO;

public class MainActivity2 extends AppCompatActivity {

    private Toast toast = null;
    UserInfo userInfo = new UserInfo();
    RadioGroup rg;
    Button btn;
    EditText et;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = getIntent();

        rg = (RadioGroup)findViewById(R.id.layout2_rg);
        btn = (Button)findViewById(R.id.layout2_btn_add);
    }

    public void onClickAdd(View v){
        intent = new Intent();
        et = (EditText)findViewById(R.id.layout2_et_name);
        userInfo.name = et.getText().toString();

        et = (EditText)findViewById(R.id.layout2_et_phone);
        userInfo.phone = et.getText().toString();

        if(userInfo.name == null || userInfo.name == "" || userInfo.name.length() == 0){
            toastShow("이름을 입력하세요");
            return;
        }else if (userInfo.phone == null || userInfo.phone == "" || userInfo.phone.length() == 0){
            toastShow("번호를 입력하세요");
            return;
        }

        if(rg.getCheckedRadioButtonId() == R.id.layout2_rb_1){
            userInfo.subject = R.drawable.google_free_icon_one;
        }else if(rg.getCheckedRadioButtonId() == R.id.layout2_rb_2){
            userInfo.subject = R.drawable.google_free_icon_two;
        }else if(rg.getCheckedRadioButtonId() == R.id.layout2_rb_3){
            userInfo.subject = R.drawable.google_free_icon_three;
        }else if(rg.getCheckedRadioButtonId() == R.id.layout2_rb_4){
            userInfo.subject = R.drawable.google_free_icon_four;
        }else { userInfo.subject = R.drawable.google_free_icon_portrait; }

        intent.putExtra(USER_INFO, userInfo);
        setResult(RESULT_C0DE_USER_INFO, intent);

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