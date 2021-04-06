package com.example.t20210405_test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.t20210405_test.MainActivity4.PREF_FILE_NAME;
import static com.example.t20210405_test.MainActivity4.PREF_NAME;

class UserInfo implements Serializable {
    static final String date = "2020년 4월 5일";
    static final String time = "17시 00분";
    String name;
    String address;
    String phone;
}
class UserCode{
    static final int REQEUST_CODE_ACT2 = 10;
    static final int RESULT_CODE_ACT2 = 11;
    static final String ACT2 = "ACT2";
    static final int REQUEST_CODE_ADMIN_DIAL = 20;
    static final int RESULT_CODE_ADMIN_DIAL = 21;
    static final String ADMIN_DIAL = "ADMIN_DIAL";
}
public class MainActivity2 extends AppCompatActivity {

    ArrayList<UserInfo> userInfoArr = new ArrayList<>();
    MyAdapter mAdapter;
    Button btn_NewAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAdapter = new MyAdapter(this, R.layout.listview_layout, userInfoArr);
        ListView lv = (ListView)findViewById(R.id.act2_LV);
        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                EditText et_admin = new EditText(MainActivity2.this);
                builder.setTitle("비밀 번호 입력").setMessage("관리자 비밀번호를 입력하세요.")
                .setView(et_admin);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences pref = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
                        String str = pref.getString(PREF_NAME, "0000");
                        if (str.equals(et_admin.getText().toString().trim())) {
                            Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                            intent.putExtra(UserCode.ADMIN_DIAL, userInfoArr.get(position));

                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity2.this, "비밀번호가 다릅니다.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity2.this, "취소하였습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    public void onClickEnd(View view){
        finish();
    }
    public void onClickNewAdd(View view){
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        intent.putExtra(UserCode.ACT2, new UserInfo());
        startActivityForResult(intent, UserCode.REQEUST_CODE_ACT2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UserInfo userInfo = new UserInfo();
        int index = 0;

        if (requestCode == UserCode.REQEUST_CODE_ACT2){
            if(resultCode == UserCode.RESULT_CODE_ACT2){
                userInfo = (UserInfo) data.getSerializableExtra(UserCode.ACT2);
                userInfoArr.add(userInfo);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}


class MyAdapter extends ArrayAdapter{

    ArrayList<UserInfo> al = new ArrayList<>();
    LayoutInflater inflater;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        this.al = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = inflater.inflate(R.layout.listview_layout, null);
        }

        TextView tv_date = ((TextView)view.findViewById(R.id.lv_tvDate));
        TextView tv_time = ((TextView)view.findViewById(R.id.lv_tvTime));
        TextView tv_name = ((TextView)view.findViewById(R.id.lv_tvName));
        TextView tv_address = ((TextView)view.findViewById(R.id.lv_tvAddress));

        tv_date.setText(al.get(position).date);
        tv_time.setText(al.get(position).time);
        String str = al.get(position).name;
        char name[] = str.toCharArray();

        for (int i = 0; i < str.length(); i ++){
            if(str.length() == 2){

            }
            if(i != 0 && i != str.length() - 1){ name[i] = 'O'; }
        }

        str = String.valueOf(name);
        tv_name.setText(str);
        tv_address.setText(al.get(position).address);

        return view;
    }
}