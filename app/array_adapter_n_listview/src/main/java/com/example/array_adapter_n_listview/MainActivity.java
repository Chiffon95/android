package com.example.array_adapter_n_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    String str_items[] = {"blue", "red", "green", "yellow"};
//    int color[] = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ArrayAdapter<String> aa;
//        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_items);
//
//        ListView listView = (ListView)findViewById(R.id.list);
//        listView.setAdapter(aa);
//        listView.setOnItemClickListener(listener);
//    }
//
//    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            view.setBackgroundColor(color[position]);
//            Log.i("chiffon95", "OnItemClick : " + str_items[position]);
//        }
//    };
    String str_animals[] = {"Owl", "Shark", "Bear", "Polar Bear", "Monkey"};
    int src_animals[] = {R.drawable.owl, R.drawable.shark, R.drawable.bear,
            R.drawable.polar_bear, R.drawable.monkey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ontouch_2);

        ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_animals);

        ListView listView = (ListView)findViewById(R.id.list_animals);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ImageView iv = (ImageView)findViewById(R.id.animal_images);
            iv.setImageResource(src_animals[position]);
            Log.i("chiffon95", "OnItemClick - Image : " + str_animals[position]);
        }
    };


//    ArrayList<String> arrayList = new ArrayList<>();
//    ArrayAdapter aa;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
//        ListView lv = (ListView)findViewById(R.id.lv_Info);
//        lv.setAdapter(aa);
//
//        Button btn = (Button)findViewById(R.id.btn_ok);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText et = (EditText)findViewById(R.id.et_Info);
//
//                arrayList.add(et.getText().toString());
//                aa.notifyDataSetChanged();
//            }
//        });
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}