package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import java.util.List;

class Student {
    String name;
    String email;
    int subject;
}
public class MainActivity extends AppCompatActivity {

    static final int SUBJECT_CODE_ANDROID = 1;
    static final int SUBJECT_CODE_IOS = 2;

    ArrayList<Student> al = new ArrayList<>();
    MyAdapter aa;
    EditText et_name;
    EditText et_email;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aa = new MyAdapter(this, R.layout.row, al);

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(lis_item);

        ((Button) findViewById(R.id.btn)).setOnClickListener(lis);

        et_email = (EditText) findViewById(R.id.et_email);
        et_name = (EditText) findViewById(R.id.et_name);
        rg = (RadioGroup) findViewById(R.id.rg);

    }

    View.OnClickListener lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Student st = new Student();
            st.name = et_name.getText().toString();
            st.email = et_email.getText().toString();
            if (rg.getCheckedRadioButtonId() == R.id.rb_android) {
                st.subject = SUBJECT_CODE_ANDROID;
            } else if (rg.getCheckedRadioButtonId() == R.id.rb_ios) {
                st.subject = SUBJECT_CODE_IOS;
            }
            al.add(st);
            aa.notifyDataSetChanged();

            et_name.setText("");
            et_email.setText("");
        }
    };

    AdapterView.OnItemClickListener lis_item = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Student st = al.get(position);
            Toast.makeText(MainActivity.this, st.name + ", "
                    + st.email, Toast.LENGTH_SHORT).show();
        }
    };
}

class MyAdapter extends ArrayAdapter<Student> {

    ArrayList<Student> al = new ArrayList<>();
    LayoutInflater inflater;

    public MyAdapter(@NonNull Context context, int resource, ArrayList<Student> al) {
        super(context, resource, al);
        inflater = LayoutInflater.from(context);
        this.al = al;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.row, null);
        }
        Student student = al.get(position);

        ImageView iv = (ImageView) view.findViewById(R.id.listeitem_iv);
        int resId = 0;
        if (student.subject == MainActivity.SUBJECT_CODE_ANDROID) {
            resId = R.drawable.heart_imo;
        } else {
            resId = R.drawable.star_imo;
        }
        iv.setImageResource(resId);

        ((TextView) view.findViewById(R.id.listitem_tv)).setText(student.name);

        return view;
    }
}