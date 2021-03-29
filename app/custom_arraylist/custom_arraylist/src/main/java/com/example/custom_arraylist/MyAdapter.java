package com.example.custom_arraylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.example.custom_arraylist.MainActivity.SUBJECT_CODE_ANDROID;

public class MyAdapter extends ArrayAdapter<Student> {

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
        if (student.subject == SUBJECT_CODE_ANDROID) {
            resId = R.drawable.heart_imo;
        } else {
            resId = R.drawable.star_imo;
        }
        iv.setImageResource(resId);

        ((TextView) view.findViewById(R.id.listitem_tv)).setText(student.name);

        return view;
    }
}

