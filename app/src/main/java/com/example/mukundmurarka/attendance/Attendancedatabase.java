package com.example.mukundmurarka.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Attendancedatabase extends SQLiteOpenHelper {
    public Attendancedatabase(Context context ) {
        super(context, "ATTENDANCE_TABLE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ATTENDANCET("+"Name Text,"+"Status Text)");
        onCreate(sqLiteDatabase);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ATTENDANCET");
        onCreate(sqLiteDatabase);
    }
        public void addData(String name_st, String stu_stt){
            ContentValues contentValues = new ContentValues();
            contentValues.put("Name", name_st);
            contentValues.put("Status", stu_stt);


            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            sqLiteDatabase.insert("ATTENDANCET", null, contentValues);



    }
    public void onDelete(String name) {
        SQLiteDatabase sqLiteDatabase =  getWritableDatabase();
        String[] whreArg = {name};
        sqLiteDatabase.delete("ATTENDANCET","Name = ?", whreArg);

    }


}
