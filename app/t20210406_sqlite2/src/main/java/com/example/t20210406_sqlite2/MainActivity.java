package com.example.t20210406_sqlite2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
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

    SQLiteDatabase sqlDB;
    Cursor cursor;
    ListView lv;
    SimpleCursorAdapter cursorAdapter;

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

        String strCol[] = { "country", "capital" };
        int tvIds[] = { android.R.id.text1, android.R.id.text2 };

        MySQLiteOpenHelper myHelper = new MySQLiteOpenHelper(this, "myDB.db",
                null, 1);
        sqlDB = myHelper.getWritableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM world", null);
        lv = (ListView)findViewById(R.id.lisViewMain);
        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2,
                cursor, strCol,tvIds, 1);
        lv.setAdapter(cursorAdapter);
        registerForContextMenu(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_INSERT, Menu.NONE, "insert");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case MENU_INSERT:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("country", "").putExtra("capital","");
                startActivityForResult(intent,RQCODE_INSERT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Context Menus
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, MENU_UPDATE, Menu.NONE, "update");
        menu.add(Menu.NONE, MENU_DELETE, Menu.NONE, "delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()){
            case MENU_UPDATE:
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);

                cursor.moveToPosition(position);
                String cou = cursor.getString(1);
                String cap = cursor.getString(2);
                intent.putExtra("position",position).putExtra("country",cou)
                        .putExtra("capital",cap);
                startActivityForResult(intent,RQCODE_UPDATE);
                break;
            case MENU_DELETE:
                cursor.moveToPosition(position);
                int id = cursor.getInt(0);
                sqlDB.execSQL("DELETE FROM world WHERE _id ="+ id +";");

                break;
        }
        cursor.requery();
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            switch (requestCode){
                case RQCODE_INSERT:
                    String strCou = data.getStringExtra("country");
                    String strCap = data.getStringExtra("capital");
                    sqlDB.execSQL("INSERT INTO world VALUES (null, '"+ strCou +"','"+ strCap +"');");
                    cursorAdapter.notifyDataSetChanged();

                    cursor.requery();
                    break;
                case RQCODE_UPDATE:
                    String strCou2 = data.getStringExtra("country");
                    String strCap2 = data.getStringExtra("capital");
                    int position = data.getIntExtra("position", -1);
                    cursor.moveToPosition(position);
                    sqlDB.execSQL("UPDATE world SET country = '" + strCou2 + "'," +
                            "capital = '"+ strCap2 + "' WHERE _id=" + (position + 1));
                    cursor.requery();
            }
        }
    }
}

class MySQLiteOpenHelper extends SQLiteOpenHelper{

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE world (_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", country TEXT, capital TEXT)");
        db.execSQL("INSERT INTO world VALUES (null, 'korea', 'seoul');");
        db.execSQL("INSERT INTO world VALUES (null, 'china', 'ccccc');");
        db.execSQL("INSERT INTO world VALUES (null, 'japan', 'jjjjj');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}