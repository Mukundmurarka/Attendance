package com.example.mukundmurarka.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Teacherdetail extends SQLiteOpenHelper {
    public Teacherdetail(Context context) {
        super(context, "TEACHERUSER", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE TEADETAIL(" +
                "Name text," +
                "EMAILID text," +"PASSWORD)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TEADETAIL");
        onCreate(sqLiteDatabase);

    }
    public void addData(String name_tea, String email_tea, String pass_tea){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name_tea);
        contentValues.put("EMAILID", email_tea);
        contentValues.put("PASSWORD", pass_tea);

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("TEADETAIL", null, contentValues);

    }

    public Cursor getData() {
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("TEADETAIL",null,null,null,null,null,null);
        return cursor;
    }

    public void onDelete(String name) {
        SQLiteDatabase sqLiteDatabase =  getWritableDatabase();
        String[] whreArg = {name};
        sqLiteDatabase.delete("TEADETAIL","Name = ?", whreArg);

    }
}
