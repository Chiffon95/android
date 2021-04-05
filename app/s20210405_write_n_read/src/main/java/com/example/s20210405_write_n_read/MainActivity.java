package com.example.s20210405_write_n_read;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String FILENAME = "myFile.txt";
    String strData = "file Test";
    TextView tv;
    EditText et;
    File sdpath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_main);
        et = (EditText)findViewById(R.id.et_main);
    }

    public void onClickSave(View view){

        sdpath = getExternalFilesDir(null);
        try {
            FileOutputStream fos = new FileOutputStream(sdpath.getAbsolutePath() + "/" + FILENAME);
            fos.write(strData.getBytes());
            Toast.makeText(this, "파일을 저장했습니다.",Toast.LENGTH_SHORT).show();

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickLoad(View view){
        int len = 0;
        int result = 0;

        sdpath = getExternalFilesDir(null);
        try {
            FileInputStream fis = new FileInputStream(sdpath.getAbsolutePath() + "/" + FILENAME);
            len = fis.available();
            if(len > 0){
                byte buff[] = new byte[len];
                while ( result > -1 ){
                    result = fis.read(buff);
                }
                tv.setText(new String(buff));
                Toast.makeText(this, "파일을 불러왔습니다.",Toast.LENGTH_SHORT).show();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}