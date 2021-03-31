package com.example.t20210331_1;

import android.content.Context;
import android.content.Intent;
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

import static com.example.t20210331_1.UserCheck.POSITION;
import static com.example.t20210331_1.UserCheck.REQUEST_CODE_RADIO;
import static com.example.t20210331_1.UserCheck.REQUEST_CODE_USER_INFO1;
import static com.example.t20210331_1.UserCheck.REQUEST_CODE_USER_INFO2;
import static com.example.t20210331_1.UserCheck.RESULT_C0DE_USER_INFO;
import static com.example.t20210331_1.UserCheck.RESULT_C0DE_USER_NOTIFY;
import static com.example.t20210331_1.UserCheck.RESULT_C0DE_USER_REMOVE;
import static com.example.t20210331_1.UserCheck.USER_INFO;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserInfo> userInfoArrayList = new ArrayList<>();
    UserCheck user = new UserCheck();
    MyAdapter myAdapter;
    Intent intent;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1, userInfoArrayList);
        ListView listView = (ListView)findViewById(R.id.layout1_lv_user);
        listView.setAdapter(myAdapter);

        button = (Button)findViewById(R.id.btn_new_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(USER_INFO, new UserInfo());
                startActivityForResult(intent, REQUEST_CODE_USER_INFO1);
            }
        });

        listView.setOnItemLongClickListener(listener);
    }


    AdapterView.OnItemLongClickListener listener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            intent = new Intent(MainActivity.this, MainActivity3.class);
            intent.putExtra(USER_INFO,userInfoArrayList.get(position))
                    .putExtra(POSITION, position).putExtra(REQUEST_CODE_RADIO, 0);
            startActivityForResult(intent, REQUEST_CODE_USER_INFO2);

            return  false;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UserInfo userInfo = new UserInfo();
        int index = 0;

        if(requestCode == REQUEST_CODE_USER_INFO1){
            if(resultCode == RESULT_C0DE_USER_INFO){
                userInfo = (UserInfo)data.getSerializableExtra(USER_INFO);

                userInfoArrayList.add(userInfo);
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

class MyAdapter extends ArrayAdapter<UserInfo>{

    ArrayList<UserInfo> user = new ArrayList<>();
    LayoutInflater inflater;
    ImageView imageView;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserInfo> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        this.user = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        int rImageId = 0;

        if(view == null){
//            view = inflater.inflate(R.layout.listview_layout, null);
            view = super.getView(position, convertView, parent);
        }

        if(user.get(position).subject == R.drawable.free_icon_one_565860){
            rImageId = R.drawable.free_icon_one_565860;
        }else if(user.get(position).subject == R.drawable.free_icon_two_565861){
            rImageId = R.drawable.free_icon_two_565861;
        }else if(user.get(position).subject == R.drawable.free_icon_three_565855){
            rImageId = R.drawable.free_icon_three_565855;
        }else if(user.get(position).subject == R.drawable.free_icon_four_565856){
            rImageId = R.drawable.free_icon_four_565856;
        }else { rImageId = R.drawable.free_icon_portrait_565886; }

        imageView = (ImageView)view.findViewById(R.id.lv_image);
        imageView.setImageResource(rImageId);
        ((TextView)view.findViewById(R.id.lv_name)).setText(user.get(position).name);

        return view;

    }


}