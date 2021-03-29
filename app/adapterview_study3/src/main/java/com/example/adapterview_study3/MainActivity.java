package com.example.adapterview_study3;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> user_name = new ArrayList<>();
    ArrayList<String> user_email = new ArrayList<>();
    ArrayList<String> user_check = new ArrayList<>();
    MyAdapter aa;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RadioGroup rg =(RadioGroup)findViewById(R.id.rg);
//        rg.setOnCheckedChangeListener(rg_ls);

        Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(btn_listener);

        aa = new MyAdapter(this, R.layout.activity_main, R.id.listitem_tv, user_name, user_check);
        ListView lv = (ListView)findViewById(R.id.lv_info);
        lv.setAdapter(aa);
    }

    View.OnClickListener btn_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText et;

            et = (EditText)findViewById(R.id.et_name);
            user_name.add(et.getText().toString().trim());

            et = (EditText)findViewById(R.id.et_email);
            user_email.add(et.getText().toString().trim());

            if (rg.getCheckedRadioButtonId() == R.id.rb_android) {
                user_check.add("android");
            } else if (rg.getCheckedRadioButtonId() == R.id.rb_ios) {
                user_check.add("ios");
            }

            aa.notifyDataSetChanged();
            Log.i("chiffon95", "onCLick : " + user_name + ", " + user_email);
        }
    };

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

    RadioGroup.OnCheckedChangeListener rg_ls = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.rb_android){
                Log.i("chiffon95", "android");
            }else if(checkedId == R.id.rb_ios){
                Log.i("chiffon95", "ios");
            }else{
                Log.i("chiffon95", "error");
            }
        }
    };

}

class MyAdapter extends ArrayAdapter{

    LayoutInflater inflater;
    ArrayList<String> al;
    ArrayList<String> al2;

    public MyAdapter(@NonNull Context context, int resource, int textViewResourceId,
                     @NonNull ArrayList<String> objects, @NonNull ArrayList<String> objects2) {
        super(context, resource, textViewResourceId, objects);
        al = objects;
        al2 = objects2;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = inflater.inflate(R.layout.row, null);
        }
        int nResId = R.drawable.ic_launcher_background;

        if(al2.get(position).equals("android")){
            nResId = R.drawable.ic_launcher_background;
        }else if(al2.get(position).equals("ios")){
            nResId = R.drawable.ic_launcher_foreground;
        }


        TextView tv = (TextView)view.findViewById(R.id.listitem_tv);
        tv.setText(al.get(position).toString());

        return view;
    }
}