package com.example.s20210405_fileinout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final String FILENAME = "myFile.txt";
    EditText et;
    TextView tv;
    String data;

    int len = 0;
    int result = 0;
    FileInputStream fis;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File path = getFilesDir();
        String str =path.getAbsolutePath();
        Log.i("chiffon95", str);

        File file = new File(getFilesDir(), FILENAME);
        String str1 = path.getAbsolutePath();
        Log.i("chiffon95", str1);
    }

    public void onClickWrite(View view){

        et = (EditText)findViewById(R.id.et_data);
        FileOutputStream fos = null;
        data = et.getText().toString();
        et.setText("");

        try {
            fos = openFileOutput(FILENAME, MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EditText et1 = (EditText)findViewById(R.id.et_data);
        et1.setVisibility(View.INVISIBLE);
        TextView tv = (TextView)findViewById(R.id.tv_main);
        tv.setVisibility(View.VISIBLE);
    }

    public void onClickRead(View view){
        FileInputStream fis = null;
        tv = (TextView)findViewById(R.id.tv_main);

        try {
            fis = openFileInput(FILENAME);
            len = fis.available();
            if(len > 0){
                byte buff[] = new byte[len];
                while(result > - 1){
                    result = fis.read(buff);
                    Log.i("chiffon95", "onClickRead Result :" + result);
                }
                fis.close();
                result = 0;
                tv.setText(new String(buff));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void onClickReadMode(View view){
        EditText et1 = (EditText)findViewById(R.id.et_data);
        et1.setVisibility(View.VISIBLE);
    }
}