package com.example.addarraylist_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String>arr1 = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr1);
        ListView lv = (ListView)findViewById(R.id.list_arr);
        lv.setAdapter(adapter);
        ((Button)findViewById(R.id.btn)).setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        int i;
        @Override
        public void onClick(View v) {
            i++;
            arr1.add(i +"번째 추가");
            adapter.notifyDataSetChanged();
            Log.i("chiffon95", "onCLick : " + i);
        }
    };

}