package com.example.t20210331_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.t20210331_1.UserCheck.RESULT_C0DE_USER_INFO;
import static com.example.t20210331_1.UserCheck.USER_INFO;

public class MainActivity2 extends AppCompatActivity {

    UserInfo userInfo = new UserInfo();
    Intent intent;
    EditText editText;
    Button button;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = (RadioGroup)findViewById(R.id.layout2_rg);
        button = (Button)findViewById(R.id.layout2_btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, phone;
                intent = getIntent();
                editText = (EditText)findViewById(R.id.lyaout2_et_name);
                userInfo.name = editText.getText().toString().trim();
                editText = (EditText)findViewById(R.id.layout2_et_phone);
                userInfo.phone = editText.getText().toString().trim();

                if (radioGroup.getCheckedRadioButtonId() == R.id.layout2_rb_1) {
                    userInfo.subject = R.drawable.free_icon_one_565860;
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.layout2_rb_2) {
                    userInfo.subject = R.drawable.free_icon_two_565861;
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.layout2_rb_3) {
                    userInfo.subject = R.drawable.free_icon_three_565855;
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.layout2_rb_4) {
                    userInfo.subject = R.drawable.free_icon_four_565856;
                } else { userInfo.subject = R.drawable.free_icon_portrait_565886; }

                intent.putExtra(USER_INFO, userInfo);
                setResult(RESULT_C0DE_USER_INFO, intent);

                finish();
            }
        });

        button = (Button)findViewById(R.id.layout2_btn_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = getIntent();
                setResult(RESULT_CANCELED);

                finish();
            }
        });
    }
}