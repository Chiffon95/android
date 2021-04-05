package com.example.s20210406_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlDB;
    Cursor cursor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_main);

        MyOpenHelper myHelper = new MyOpenHelper(this, "myDB.db",
                null, 1);
        sqlDB = myHelper.getWritableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM world", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String country = cursor.getString(1);
            String capital = cursor.getString(2);

            Log.i("chiffon95", id + ", " + country + "," + capital);
        }
    }

    public void onClickAdd(View view){
        sqlDB.execSQL("INSERT INTO world VALUES (null, 'korea', 'seoul');");
    }

    public void onClickRead(View view){
        cursor = sqlDB.rawQuery("SELECT * FROM world", null);
        String str = null;
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String country = cursor.getString(1);
            String capital = cursor.getString(2);

            str = id + ". " + country + ", " + capital + "\n";
            tv.append(str);
        }
    }

    public void onClickNotify(View view){
        sqlDB.execSQL("UPDATE world SET capital= '서울' WHERE _id=1;");
    }

    public void onClickRemove(View view) {
        sqlDB.execSQL("DELETE FROM world WHERE _id = 1");
    }
}

class MyOpenHelper extends SQLiteOpenHelper{

    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        sqlDB.execSQL("CREATE TABLE world (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "country TEXT, capital TEXT);");
        sqlDB.execSQL("INSERT INTO world VALUES (null, 'korea', 'seoul');");
        sqlDB.execSQL("INSERT INTO world VALUES (null, 'france', 'paris');");
        sqlDB.execSQL("INSERT INTO world VALUES (null, 'japan', 'tock');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}