package com.example.thanchu.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "ThanChu", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (" +
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT, " +
                        "%s TEXT," +
                        "%s TEXT," +
                        "%s TEXT)",
                "Card", "id", "name", "image", "artist", "description");
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop
        String query = "DROP TABLE Card";
        db.execSQL(query);
        //create again
        onCreate(db);
    }
}
