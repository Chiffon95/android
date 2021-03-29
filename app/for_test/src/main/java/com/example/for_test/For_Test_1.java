package com.example.for_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class For_Test_1 extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_for__test_1);
//
//        Button btn_tv = (Button) findViewById(R.id.btn_txt_change);
//        btn_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView tv = (TextView)findViewById(R.id.tv);
//                if (tv.getText().equals("Chnaged Text!"))
//                    tv.setText("Hello World!");
//                else
//                    tv.setText("Chnaged Text!");
//            }
//        });
//
//        Button btn_hide = (Button) findViewById(R.id.btn_hide_tv);
//        btn_hide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView tv = (TextView)findViewById(R.id.tv);
//                if(tv.getVisibility() == View.VISIBLE)
//                    tv.setVisibility(View.INVISIBLE);
//                else
//                    tv.setVisibility(View.VISIBLE);
//            }
//        });
//    }
    ArrayList<String> al = new ArrayList<>();
    ArrayAdapter at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ex1);

        at = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
        ListView lv = (ListView)findViewById(R.id.lv_name);
        lv.setAdapter(at);

        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText)findViewById(R.id.et_name);
                if(et.getText().toString() != ""){
                    al.add(et.getText().toString());
                }
                at.notifyDataSetChanged();

                Log.i("chiffon95", "onClick : " + et.getText().toString());
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(For_Test_1.this, al.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}



    ArrayList<String> info = new ArrayList<>();
    ArrayAdapter at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        at = new ArrayAdapter(this, android.R.layout.simple_list_item_1, info);
        ListView lv = (ListView)findViewById(R.id.lv_Info);
        lv.setAdapter(at);

        Button btn_add = (Button)findViewById(R.id.btn_ok);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText)findViewById(R.id.et_Info);
                if(et.getText().toString() != ""){
                    info.add(et.getText().toString());
                }
                at.notifyDataSetChanged();

                Log.i("chiffon95", "onClick : " + et.getText().toString());
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, info.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }