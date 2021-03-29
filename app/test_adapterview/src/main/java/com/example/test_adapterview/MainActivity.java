package com.example.test_adapterview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class UserInfo{
    static String name;
    static String email;
    static int subject;
}
public class MainActivity extends AppCompatActivity {

    static final int SUBJECT_CODE_ANDROID = 1;
    static final int SUBJECT_CODE_IOS = 2;

    ArrayList<UserInfo> userInfo = new ArrayList<>();
    MyAdapter aa;
    EditText et_name;
    EditText et_email;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aa = new MyAdapter(this, R.layout.layout_ex1, userInfo);

        ListView lv = (ListView) findViewById(R.id.lv_Info);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(lis_item);

        ((Button) findViewById(R.id.btn_add)).setOnClickListener(lis);

        et_email = (EditText) findViewById(R.id.et_email);
        et_name = (EditText) findViewById(R.id.et_name);
        rg = (RadioGroup) findViewById(R.id.rg);

    }

    View.OnClickListener lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UserInfo st = new UserInfo();
            st.name = et_name.getText().toString();
            st.email = et_email.getText().toString();
            if (rg.getCheckedRadioButtonId() == R.id.rb_android) {
                st.subject = SUBJECT_CODE_ANDROID;
            } else if (rg.getCheckedRadioButtonId() == R.id.rb_ios) {
                st.subject = SUBJECT_CODE_IOS;
            }
            userInfo.add(st);
            aa.notifyDataSetChanged();

            et_name.setText("");
            et_email.setText("");
        }
    };

    AdapterView.OnItemClickListener lis_item = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            UserInfo st = userInfo.get(position);
            Toast.makeText(MainActivity.this, st.name + ", "
                    + st.email, Toast.LENGTH_SHORT).show();
        }
    };
}
class MyAdapter extends ArrayAdapter<UserInfo> {

    ArrayList<UserInfo> al = new ArrayList<>();
    LayoutInflater inflater;

    public MyAdapter(@NonNull Context context, int resource, ArrayList<UserInfo> al) {
        super(context, resource, al);
        inflater = LayoutInflater.from(context);
        this.al = al;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.layout_ex1, null);
        }
        UserInfo userInfo = al.get(position);

        ImageView iv = (ImageView) view.findViewById(R.id.iv_userImage);
        int resId = 0;
        if (UserInfo.subject == MainActivity.SUBJECT_CODE_ANDROID) {
            resId = R.drawable.heart_imo;
        } else {
            resId = R.drawable.star_imo;
        }
        iv.setImageResource(resId);

        ((TextView) view.findViewById(R.id.tv_user_name)).setText(UserInfo.name);

        return view;
    }
}