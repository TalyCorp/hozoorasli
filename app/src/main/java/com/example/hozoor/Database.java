package com.example.hozoor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public class Database extends SQLiteOpenHelper implements BaseColumns {
    private final String DBName = "school";

    public Database(Context context) {
        super(context, "school", null, 1);
    }
    public static final String DATABASE_NAME="classList.DB";
    public static final String TABLE_NAME="classList";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_TIMESTAMP="timestamp";

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String Sqlite="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT NOT NULL,"+COLUMN_TIMESTAMP+" TIMESTAMP DEFAULT CURRENT_TIMESTAMP"+");";
        db.execSQL(Sqlite);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }


}
