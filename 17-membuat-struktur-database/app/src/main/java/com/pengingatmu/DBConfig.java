package com.pengingatmu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConfig extends SQLiteOpenHelper {

    // membuat konstanta
    private static final String DB_NAME = "your_note.db";
    private static final int DB_VERSION = 1;

    public DBConfig(@Nullable Context context){
        // pembuatan database
        super( context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // membuat struktur table
        String queryCreateTable = "CREATE TABLE notes ( id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(255) NOT NULL, description TEXT NOT NULL )";
        db.execSQL(queryCreateTable);

        // sample data
        String querySampleData = "INSERT INTO notes (title, description) VALUES ('catatan awal', 'Selamat mencatat kawan')";
        db.execSQL(querySampleData);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
