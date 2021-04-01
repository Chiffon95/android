package com.example.t20210331_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.t20210331_2.UserCheck.POSITION;
import static com.example.t20210331_2.UserCheck.REQUEST_CODE_USER_INFO1;
import static com.example.t20210331_2.UserCheck.REQUEST_CODE_USER_INFO2;
import static com.example.t20210331_2.UserCheck.RESULT_C0DE_USER_INFO;
import static com.example.t20210331_2.UserCheck.RESULT_C0DE_USER_NOTIFY;
import static com.example.t20210331_2.UserCheck.RESULT_C0DE_USER_REMOVE;
import static com.example.t20210331_2.UserCheck.USER_INFO;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserInfo> userInfoArrayList = new ArrayList<>();
    MyAdapter myAdapter;
    Button btn;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new MyAdapter(this, R.layout.listview_layout, userInfoArrayList);
        lv = (ListView)findViewById(R.id.lv_name_activity_1);
        lv.setAdapter(myAdapter);

        btn = (Button)findViewById(R.id.btn_newAdd_activity_1);
        btn.setOnClickListener(btnAddListener);

        lv.setOnItemLongClickListener(lvItemLongListener);
        lv.setOnItemClickListener(lvItemListener);
    }

    View.OnClickListener btnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra(USER_INFO, new UserInfo());
            startActivityForResult(intent, REQUEST_CODE_USER_INFO1);
        }
    };

    AdapterView.OnItemLongClickListener lvItemLongListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            intent.putExtra(USER_INFO, userInfoArrayList.get(position))
                    .putExtra(POSITION, position);
            startActivityForResult(intent, REQUEST_CODE_USER_INFO2);
            return false;
        }
    };

    AdapterView.OnItemClickListener lvItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String str = "tel:" + userInfoArrayList.get(position).phone;

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(str));
            startActivity(intent);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UserInfo userInfo = new UserInfo();
        int index = 0;

        if(requestCode == REQUEST_CODE_USER_INFO1){
            if(resultCode == RESULT_C0DE_USER_INFO){
                userInfoArrayList.add((UserInfo)data.getSerializableExtra(USER_INFO));
            }
        }else if (requestCode == REQUEST_CODE_USER_INFO2){
            if(resultCode == RESULT_C0DE_USER_NOTIFY){
                userInfo = (UserInfo)data.getSerializableExtra(USER_INFO);
                index = data.getIntExtra(POSITION, -1);

                userInfoArrayList.set(index, userInfo);
            }else if(resultCode == RESULT_C0DE_USER_REMOVE){
                index = data.getIntExtra(POSITION, -1);
                userInfoArrayList.remove(index);
            }
        }
        myAdapter.notifyDataSetChanged();
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

        if (view == null){
            view = inflater.inflate(R.layout.listview_layout, null);
        }
        iv = (ImageView)view.findViewById(R.id.listView_image);
        tv = (TextView)view.findViewById(R.id.listView_text);
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
        tv.setText(user.get(position).name);

        return view;
//        return super.getView(position, convertView, parent);
    }
}