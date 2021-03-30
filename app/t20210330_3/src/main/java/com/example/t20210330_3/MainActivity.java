package com.example.t20210330_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

class NameCheck{

    static final String POSITION = "position";
    static final int REQUEST_CODE_USER_NAME = 1;
    static final String USER_NAME = "name";
    static final int REQUEST_CODE_USER_NAME2 = 2;
    static final int MY_RESULT_CODE_REMOVE = 21;
    static final int MY_RESULT_CODE_NOTIFY = 22;
    static final String USER_NAME2 = "name2";
}

public class MainActivity extends AppCompatActivity {


    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter aa;
    Intent intent;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.lv_name);

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);


        listView.setAdapter(aa);

        button = (Button)findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MainActivity2.class)
                        .putExtra(NameCheck.USER_NAME,"");
                startActivityForResult(intent, NameCheck.REQUEST_CODE_USER_NAME);

                Log.i("chiffon95", "btn_notify");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(MainActivity.this, MainActivity3.class)
                        .putExtra(NameCheck.USER_NAME2, arrayList.get(position))
                        .putExtra(NameCheck.POSITION, position);
                startActivityForResult(intent, NameCheck.REQUEST_CODE_USER_NAME2);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arrayList.get(position),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int position = 0;
        intent = getIntent();

        if(requestCode == NameCheck.REQUEST_CODE_USER_NAME){
            if(resultCode == RESULT_OK){
                String str_lv = data.getStringExtra(NameCheck.USER_NAME);
                arrayList.add(str_lv);
                aa.notifyDataSetChanged();
            }
        }else if (requestCode == NameCheck.REQUEST_CODE_USER_NAME2){
            if(resultCode == NameCheck.MY_RESULT_CODE_REMOVE){
                position = data.getIntExtra(NameCheck.POSITION, -1);

                arrayList.remove(position);
                aa.notifyDataSetChanged();

            }else if (resultCode == NameCheck.MY_RESULT_CODE_NOTIFY){
                String str_notify = data.getStringExtra(NameCheck.USER_NAME2);
                position = data.getIntExtra(NameCheck.POSITION, -1);

                arrayList.set(position, str_notify);
                aa.notifyDataSetChanged();
            }
        }

    }
}