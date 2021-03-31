package com.example.t20210331_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserInfo> userInfoArrayList = new ArrayList<>();
    MyAdapter myAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new MyAdapter(this, R.layout.listview_layout, userInfoArrayList);
        lv = (ListView)findViewById(R.id.lv_name_activity_1);
        lv.setAdapter(myAdapter);
    }
}

class MyAdapter extends ArrayAdapter<UserInfo> {

    ArrayList<UserInfo> user = new ArrayList<>();
    LayoutInflater inflater;
    ImageView iv;
    TextView tv;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserInfo> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        user = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        iv = ((ImageView)view).findViewById(R.id.listView_image);
        tv = ((TextView)view).findViewById(R.id.listView_text);

        if (view == null){
            view = inflater.inflate(R.layout.listview_layout, null);
        }
        int lvImgId = 0;

        if(user.get(position).subject == R.drawable.google_free_icon_one){
            lvImgId = R.drawable.google_free_icon_one;
        }else if(user.get(position).subject == R.drawable.google_free_icon_two){
            lvImgId = R.drawable.google_free_icon_two;
        }else if(user.get(position).subject == R.drawable.google_free_icon_three){
            lvImgId = R.drawable.google_free_icon_three;
        }else if(user.get(position).subject == R.drawable.google_free_icon_four){
            lvImgId = R.drawable.google_free_icon_four;
        }else{
            lvImgId = R.drawable.google_free_icon_portrait;
        }

        iv.setImageResource(lvImgId);
        tv.setText("" + lvImgId);

        return view;
//        return super.getView(position, convertView, parent);
    }
}