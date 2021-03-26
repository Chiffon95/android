package com.example.connectphone;

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

public class connect_test1 extends AppCompatActivity{

    //test1
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_connect_test1);
//
//        Button btn1 = (Button)findViewById(R.id.btn_1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(connect_test1.this, "1번 버튼", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        Button btn2 = (Button)findViewById(R.id.btn_2);
//        btn2.setOnClickListener(this);
//
//        Button btn_tv = (Button)findViewById(R.id.btn_tv);
//        btn_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView tv = (TextView)findViewById(R.id.tv);
//                if(tv.getText().equals("버튼이 눌렸습니다!"))
//                    tv.setText("텍스트뷰");
//                else
//                    tv.setText("버튼이 눌렸습니다!");
//            }
//        });
//
//        Button btnHide = (Button)findViewById(R.id.btn_hide);
//        btnHide.setOnClickListener(new View.OnClickListener() {
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
//
//    @Override
//    public void onClick(View v){
//        Toast.makeText(connect_test1.this, "2번 버튼", Toast.LENGTH_LONG).show();
//    }

//    //test2
    ArrayList<String> arrlist1 = new ArrayList<String>();
    ArrayAdapter arradapter1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_test2);

        arradapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrlist1);
        ListView lv = (ListView)findViewById(R.id.list_name);
        lv.setAdapter(arradapter1);

        Button btn_ok = (Button)findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(okLi);

        Button btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(cancelLi);

        Button btn_remove = (Button)findViewById(R.id.btn_remove);
        btn_remove.setOnClickListener(removeLi);

        lv.setOnItemLongClickListener(ls_long);
    }

    View.OnClickListener okLi =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText et = (EditText)findViewById(R.id.name);
            String str = et.getText().toString().trim();

            if(str.length() > 0){
                arrlist1.add(str);
                arradapter1.notifyDataSetChanged();
            }
            et.setText("");

            Log.i("chiffon95", "onClick - ok : " + str);
        }
    };
    View.OnClickListener cancelLi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText et = (EditText)findViewById(R.id.name);
            et.setText("");

            Log.i("chiffon95", "onClick - cancel");
        }
    };
    View.OnClickListener removeLi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int index = -1;
            String str_remove = "";

            if(arrlist1.size() != 0){
                index = arrlist1.size() - 1;
                str_remove = arrlist1.get(index).toString();
                arrlist1.remove(index);
            }

            arradapter1.notifyDataSetChanged();

            Log.i("chiffon95", "onClick - remove : " + str_remove);
        }
    };

    AdapterView.OnItemLongClickListener ls_long = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            String str_remove = "";

            str_remove = arrlist1.get(position).toString();
            arrlist1.remove(position);
            arradapter1.notifyDataSetChanged();

            Log.i("chiffon95", "OnItemLongClickListener : " + str_remove);

            return false;
        }
    };

//    //test3
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.connect_test3);
//    }
//
//    public void onClick(View v){
//        ((TextView)findViewById(R.id.tv_num)).setText(((Button)v).getText());
//    }
}