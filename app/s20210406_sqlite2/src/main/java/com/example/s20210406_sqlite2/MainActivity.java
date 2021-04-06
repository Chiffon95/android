package com.example.s20210406_sqlite2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor cursor;
    ListView lv;
    SimpleCursorAdapter ca;

    private static final int RQCODE_INSERT = 1;
    private static final int RQCODE_UPDATE = 2;
    private static final int RQCODE_DELETE = 3;

    private static final int MENU_INSERT   = Menu.FIRST ;
    private static final int MENU_UPDATE   = Menu.FIRST + 1 ;
    private static final int MENU_DELETE   = Menu.FIRST + 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String strCol[] = {"country", "capital"};
        int arr_ids[] = {android.R.id.text1, android.R.id.text2};

        MyOpenHelper helper = new MyOpenHelper(this, "mydb.db", null,1);
        db = helper.getWritableDatabase();

        cursor = db.rawQuery("SELECT * FROM world", null);
        lv = (ListView)findViewById(R.id.list);
        ca = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2,cursor,
                strCol, arr_ids,1);
        lv.setAdapter(ca);
        registerForContextMenu(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_INSERT, Menu.NONE, "insert");
        menu.add(Menu.NONE, 21, Menu.NONE, "test");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case MENU_INSERT:{
                Log.i("yun", "insert");
                break;
            }
            case 21:{
                Log.i("yun", "test");
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
e
        menu.add(Menu.NONE, MENU_DELETE, Menu.NONE, "delete");
        menu.add(Menu.NONE, MENU_UPDATE, Menu.NONE, "update");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()){
            case MENU_DELETE:{
                Log.i("yun", "delete");
                break;
            }
            case MENU_UPDATE:{
                Log.i("yun", "update");
                break;
            }
        }

        return super.onContextItemSelected(item);
    }
}

class MyOpenHelper extends SQLiteOpenHelper{

    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE world (_id INTEGER PRIMARY KEY AUTOINCREMENT, country TEXT, capital TEXT);");
        db.execSQL("INSERT INTO world VALUES (null, 'korea', 'seoul');");
        db.execSQL("INSERT INTO world VALUES (null, 'france', 'paris');");
        db.execSQL("INSERT INTO world VALUES (null, 'japan', 'tock');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}