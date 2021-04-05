package com.example.t20210406_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlDB;
    Cursor cursor;
    TextView tv;
    EditText et_country;
    EditText et_capital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_mainTv);
        et_country = (EditText)findViewById(R.id.et_country);
        et_capital = (EditText)findViewById(R.id.et_capital);

        MyOpenHelper myHelper = new MyOpenHelper(this, "mySQLDB.db",
                null, 1);
        sqlDB = myHelper.getWritableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM world", null);
    }

    public void onClickAdd(View view){
        String country = et_country.getText().toString().trim();
        String capital = et_capital.getText().toString().trim();

        sqlDB.execSQL("INSERT INTO world VALUES (null, '" + country + "', '" + capital + "');");
        et_country.setText("");
        et_capital.setText("");

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

    }
    public void onClickRemove(View view){
        cursor.moveToFirst();
        int id = cursor.getInt(0);

        sqlDB.execSQL("DELETE FROM world WHERE _id ="+ id +";");
    }
}

class MyOpenHelper extends SQLiteOpenHelper{

    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE world (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "country TEXT, capital TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}