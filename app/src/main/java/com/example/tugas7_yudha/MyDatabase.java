package com.example.tugas7_yudha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_anime";
    private static final String tb_anime = "tb_anime";
    private static final String tb_anime_id = "id";
    private static final String tb_anime_judul = "judul";
    private static final String tb_anime_genre = "genre";
    private static final String tb_anime_tahun = "tahun";
    private static final String CREATE_TABLE_ANIME = "CREATE TABLE " + tb_anime +"(" + tb_anime_id + " INTEGER PRIMARY KEY ,"+ tb_anime_judul + " TEXT ," + tb_anime_genre + " TEXT ," + tb_anime_tahun + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ANIME);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateAnime(Anime data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_anime_id, data.get_id());
        values.put(tb_anime_judul, data.get_judul());
        values.put(tb_anime_genre, data.get_genre());
        values.put(tb_anime_tahun, data.get_tahun());
        db.insert(tb_anime, null, values);
        db.close();
    }
    public List<Anime> ReadAnime() {
        List<Anime> listMhs = new ArrayList<Anime>();
        String selectQuery = "SELECT * FROM " + tb_anime;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Anime data = new Anime();
                data.set_id(cursor.getString(0));
                data.set_judul(cursor.getString(0));
                data.set_genre(cursor.getString(1));
                data.set_tahun(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateAnime (Anime data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_anime_judul, data.get_judul());
        values.put(tb_anime_genre, data.get_genre());
        values.put(tb_anime_tahun, data.get_tahun());
        return db.update(tb_anime, values, tb_anime_id + " = ?",
                new String[]{String.valueOf((data.get_judul()))});
    }
    public void DeleteAnime(Anime data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_anime,tb_anime_id+ " = ?", new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

