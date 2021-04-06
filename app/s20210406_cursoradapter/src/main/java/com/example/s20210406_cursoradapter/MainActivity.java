package com.example.s20210406_cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class NameForDB {
    static final String DB_NAME = "myDB.db";
    static final String DB_TABLE_NAME = "user";
    static final String COL1_NAME = "name";
    static final String COL2_NAME = "info";
    static final int DB_VERSION = 1;
}

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlDB;
    Cursor cursor;
    EditText et_name;
    EditText et_info;
    ListView lv_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText)findViewById(R.id.et_name);
        et_info = (EditText)findViewById(R.id.et_Info);
        lv_user = (ListView)findViewById(R.id.listView_user);
        MySQLHepler mySQL = new MySQLHepler(this, NameForDB.DB_NAME,
                null, NameForDB.DB_VERSION);
        sqlDB = mySQL.getWritableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM world", null);
    }

    public void onClickAdd(View view){
        String name = et_name.getText().toString().trim();
        String info = et_info.getText().toString().trim();

        sqlDB.execSQL("INSERT INTO " + NameForDB.DB_TABLE_NAME +
                " VALUES (null, '"+ name + "', '" + info + "');");
    }
    public void onClickRead(View view){
        cursor = sqlDB.rawQuery("SELECT * FROM " + NameForDB.DB_TABLE_NAME, null);
        String str = null;
        while (cursor.moveToNext()){

        }
    }

    public void onClickRemove(View view){
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        sqlDB.execSQL("DELETE FROM " + NameForDB.DB_TABLE_NAME + " WHERE _id =" + id + ";");
    }
    public void onClickNotify(View view){

    }
}

class MySQLHepler extends SQLiteOpenHelper{

    public MySQLHepler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NameForDB.DB_TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                NameForDB.COL1_NAME + " TEXT, " + NameForDB.COL2_NAME + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

class DBAdapter extends CursorAdapter{

    public DBAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}