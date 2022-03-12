package com.example.group_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "students.db";

    public DBHelper(Context context) {
        super(context, "students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create Table users(firstname TEXT, lastname TEXT, email TEXT, username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean regUser(String firstname, String lastname, String email, String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("email",email);
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDB.insert("users", null, contentValues);

        if (result==-1)
            return false;
        else
            return true;
    }
    public boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ?",new String[] {username});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkUser(String username,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username,password});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
