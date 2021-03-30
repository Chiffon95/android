package com.example.t20210330;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");

        editText = (EditText)findViewById(R.id.et_country);
        editText.setText(country);

        button = (Button)findViewById(R.id.btn_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        button = (Button)findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                EditText editText = (EditText)findViewById(R.id.et_country);
                intent1.putExtra("result", editText.getText().toString());
                setResult(RESULT_OK, intent1);

                finish();

                Log.i("chiffon95", "Layout 2 >> onClick");
            }
        });
    }
}