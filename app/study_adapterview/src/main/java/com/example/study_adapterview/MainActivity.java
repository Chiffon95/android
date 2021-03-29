package com.example.study_adapterview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

class UserInfo{
    String name;
    String phone;
    String email;
    String address;
}

public class MainActivity extends AppCompatActivity {

    ArrayList<UserInfo> arrayListUserInfo = new ArrayList<>();
    MyAdapter adapterUser;
    EditText et_name;
    EditText et_phone;
    EditText et_email;
    EditText et_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterUser = new MyAdapter(this, R.layout.layout, arrayListUserInfo);
        ListView lv = (ListView)findViewById(R.id.lv_Info);
        lv.setAdapter(adapterUser);

        ((Button) findViewById(R.id.btn_ok)).setOnClickListener();

        et_name = (EditText) findViewById(R.id.et_name);
        et_name = (EditText) findViewById(R.id.et_phone);
        et_name = (EditText) findViewById(R.id.et_email);
        et_email = (EditText) findViewById(R.id.et_address);
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}

class MyAdapter extends ArrayAdapter{

    LayoutInflater inflater;
    ArrayList<UserInfo> arrayList;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = inflater.inflate(R.layout.layout, null);
        }
        UserInfo userInfo = arrayList.get(position);

        ImageView iv = (ImageView)view.findViewById(R.id.iv);

        int mReId = R.drawable.ic_launcher_background;
        iv.setImageResource(mReId);

        return view;
    }
}