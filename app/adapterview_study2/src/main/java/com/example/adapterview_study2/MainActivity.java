package com.example.adapterview_study2;

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
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> al_UserInfo;
    MyAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aa = new MyAdapter(this, R.layout.layout_ex1, R.id.lv_name_n_email, al_UserInfo);
        Button button = (Button)findViewById(R.id.btn_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText)findViewById(R.id.et_name);
                al_UserInfo.add(et.getText().toString());
                aa.notifyDataSetChanged();
            }
        });
    }
}

class MyAdapter extends ArrayAdapter<String>{

    LayoutInflater inflater;
    ArrayList<String> mName;

    public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ArrayList<String> objects) {
        super(context, resource, textViewResourceId, objects);
        mName = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.layout_ex1, null);
        }
        ImageView iv = (ImageView)view.findViewById(R.id.iv_user_image);
        int  nResId = R.drawable.heart_imo2;

        if (position % 2 == 0){
            nResId = R.drawable.star_imo2;
        }

        iv.setImageResource(nResId);

        TextView tv = (TextView)view.findViewById(R.id.tv_user_name);
        tv.setText(mName.get(position));

//        TextView tv2 = (TextView)view.findViewById(R.id.tv_user_email);
//        tv2.setText(mEmail[position]);

        return view;
    }
}