package com.ivanchenko_daniil.rrrr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "photo_urls.db";
    private static final String TABLE_NAME = "urls_table";
    private static final String COL_ID = "ID";
    private static final String COL_URL = "URL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_URL + " TEXT)";
        db.execSQL(createTable);

        // Добавление URL-адресов в таблицу при создании базы данных
        insertURL(db, "https://sich.zp.ua/wp-content/uploads/2021/02/Park_Voznesenivs_kyj-1024x583.jpg");
        insertURL(db, "https://sich.zp.ua/wp-content/uploads/2021/02/Ploshcha_Maiakovs_koho-1024x668.jpg");
        insertURL(db, "https://sich.zp.ua/wp-content/uploads/2021/02/Mural_na_fasadi_shkoly_mystetstv_-3-1024x682.jpg");
        insertURL(db, "https://sich.zp.ua/wp-content/uploads/2021/02/Natsional_nyj_zapovidnyk_-Khortytsia--1024x683.jpg");
        insertURL(db, "https://zp.gov.ua/upload/editor/prospekt-sobornyj.jpg");
        insertURL(db, "https://i.pinimg.com/originals/7a/23/23/7a2323ca6cfa9fbd6425e59a329d37d3.jpg");
        insertURL(db, "https://ki.ill.in.ua/a/675x0/24113486.jpg");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertURL(SQLiteDatabase db, String url) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_URL, url);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllURLs() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
