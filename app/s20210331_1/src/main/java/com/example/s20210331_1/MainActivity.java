package com.example.s20210331_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.et_search_layout_1);
        button = (Button)findViewById(R.id.btn_search_layout1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();

                Intent intent1 = new Intent();
                intent1.setAction(intent1.ACTION_SEND);
                intent1.putExtra(intent1.EXTRA_TEXT, str);
                intent1.setType("text/plain");
                startActivity(intent1.createChooser(intent1, "어떤 액티비티를 실행할까요?"));
            }
        });
    }
}