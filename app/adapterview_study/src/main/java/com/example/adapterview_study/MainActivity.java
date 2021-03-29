package com.example.adapterview_study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] name_arr = { "최현학", "강지윤", "윤용우", "김기훈","조휘만", "박지수"};
    String[] email_arr = {"a@naver.com", "b@naver.com", "c@naver.com", "d@naver.com",
                        "e@naver.com", "f@naver.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter aa = new MyAdapter(this, R.layout.layout_ex1, R.id.tv_name,
                R.id.tv_email, name_arr, email_arr);
        ListView lv = (ListView)findViewById(R.id.lv_custom);
        lv.setAdapter(aa);
    }
}

class MyAdapter extends ArrayAdapter<String> {

    LayoutInflater inflater;
    String mItem[];
    String mEmail[];

    public MyAdapter(@NonNull Context context, int resource, int textViewResourceId,
                     int textViewResourceId2, @NonNull String[] objects, @NonNull String[] objects2) {
        super(context, resource, textViewResourceId, objects);
        mItem = objects;
        mEmail = objects2;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.layout_ex1, null);
        }
        ImageView iv = (ImageView)view.findViewById(R.id.iv_item);
        int  nResId = R.drawable.heart_imo;

        if (position % 2 == 0){
            nResId = R.drawable.star_imo;
        }

        iv.setImageResource(nResId);

        TextView tv = (TextView)view.findViewById(R.id.tv_name);
        tv.setText(mItem[position]);

        TextView tv2 = (TextView)view.findViewById(R.id.tv_email);
        tv2.setText(mEmail[position]);

        return view;
    }
}