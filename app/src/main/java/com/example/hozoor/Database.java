package com.example.hozoor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {
    private final String DBName = "school";

    public Database(Context context) {
        super(context, "school", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS school(id integer primary key autoincrement , name varchar ,family text,Class text)");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert(String name , String family,String Class) {
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("family",family);
        values.put("Class",Class);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.insert("school",null,values);
    }
}
