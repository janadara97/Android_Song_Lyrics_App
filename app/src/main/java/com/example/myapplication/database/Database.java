package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.myapplication.Model.Song;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME="songL13.db";
    private static final int DB_VER=1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    //get all songs
    public List<Song> getSongs(){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"song_id","song_name","song_artist","song_content"};
        String tableName="sinhala_songs";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<Song> result=new ArrayList<>();

        if (cursor.moveToFirst()){

            do {

                Song song=new Song();
                song.setId(cursor.getInt(cursor.getColumnIndex("song_id")));
                song.setName(cursor.getString(cursor.getColumnIndex("song_name")));
                song.setArtist(cursor.getString(cursor.getColumnIndex("song_artist")));
                song.setContent(cursor.getString(cursor.getColumnIndex("song_content")));
                result.add(song);


            }
            while (cursor.moveToNext());
        }
        return result;
    }

    //function get all song's name
    public List<String> getNames(){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"song_name"};
        String tableName="sinhala_songs";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<String> result=new ArrayList<>();

        if (cursor.moveToFirst()){

            do {


                result.add(cursor.getString(cursor.getColumnIndex("song_name")));


            }
            while (cursor.moveToNext());
        }
        return result;


    }


    public List<String> getId(){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"song_id"};
        String tableName="sinhala_songs";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<String> result=new ArrayList<>();

        if (cursor.moveToFirst()){

            do {


                result.add(cursor.getString(cursor.getColumnIndex("song_id")));


            }
            while (cursor.moveToNext());
        }
        return result;


    }




    //function to get song by it name
    public List<Song> getSongByName(String name){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"song_id","song_name","song_artist","song_content"};
        String tableName="sinhala_songs";

        qb.setTables(tableName);
        //this will like query select *from songs whre name LIKE pattern
        Cursor cursor=qb.query(db,sqlSelect,"song_name LIKE ?",new String[]{"%"+name+"%"},null,null,null);
        List<Song> result=new ArrayList<>();

        if (cursor.moveToFirst()){

            do {

                Song song=new Song();
                song.setId(cursor.getInt(cursor.getColumnIndex("song_id")));
                song.setName(cursor.getString(cursor.getColumnIndex("song_name")));
                song.setArtist(cursor.getString(cursor.getColumnIndex("song_artist")));
                song.setContent(cursor.getString(cursor.getColumnIndex("song_content")));
                result.add(song);


            }
            while (cursor.moveToNext());
        }
        return result;

    }
}
