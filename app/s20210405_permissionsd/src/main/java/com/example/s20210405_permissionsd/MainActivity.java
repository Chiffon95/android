package com.example.s20210405_permissionsd;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 1;
    ArrayList<String> al_list = new ArrayList<>();
    ArrayAdapter aa;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView)findViewById(R.id.listView_main);
        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al_list);
        lv.setAdapter(aa);

        btn = (Button)findViewById(R.id.btn_permission);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                permissionReadExternalStorage();
            }
        });

        btn = (Button)findViewById(R.id.btn_get_mp3_file);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readExternalMusicFiles();
            }
        });
    }

    //파일 불러오기
    void readExternalMusicFiles(){
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        String strPath = path.getPath();

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        };
        String[] mplist = path.list(filter);
        if(mplist.length == 0){
            Toast.makeText(this, "파일이 없습니다.", Toast.LENGTH_SHORT).show();
        }else {
            for (String s : mplist){
                al_list.add(s);
                aa.notifyDataSetChanged();
            }
        }
    }

    //파일 권한 부여
    void permissionReadExternalStorage(){
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(MainActivity.this, "권한이 없습니다.",
                        Toast.LENGTH_SHORT).show();
            }else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_READ_EXTERNAL_STORAGE);
            }
        }else{
            Toast.makeText(MainActivity.this, "권한을 얻었습니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_READ_EXTERNAL_STORAGE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "한번 더 눌러주세요.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}