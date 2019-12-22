package com.example.mobileapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    static String CREATE_SQL = "CREATE TABLE userinfo (" +
            "userId varchar(100) primary key," +
            "userPwd varchar(200)," +
            "userAddr varchar(300)," +
            "userPhone varchar(100)" +
            ");";

    static String DELETE_SQL = "DROP TABLE userinfo;";

    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SQL);
    } // 데이터베이스를 생성하는 용도

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_SQL);
        onCreate(sqLiteDatabase);
    } // 데이터베이스를 수정하는 용도
}
