package com.example.t20210330;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String STR_COUNTRY = "country";
    static final int REQUEST_COUNTRY = 1;

    String[] country_name = {"한국", "중국", "일본"};
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add("한국");
        arrayList.add("중국");
        arrayList.add("일본");

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        ListView lv = (ListView) findViewById(R.id.lv_country);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(STR_COUNTRY, arrayList.get(position).toString());
                startActivityForResult(intent, REQUEST_COUNTRY);

            }
        });
    }
}