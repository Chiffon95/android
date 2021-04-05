package com.example.t20210404_for_search;

import android.os.Bundle;
import android.widget.HorizontalScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final int MENU_CNT = 9;
    int[] menuArr = {R.id.btn_menu_1, R.id.btn_menu_2, R.id.btn_menu_3,
            R.id.btn_menu_4, R.id.btn_menu_5, R.id.btn_menu_6,
            R.id.btn_menu_7, R.id.btn_menu_8, R.id.btn_menu_9};

    HorizontalScrollView hScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        hScrollView = (HorizontalScrollView)findViewById(R.id.scrollview_menu_scrollbars);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}