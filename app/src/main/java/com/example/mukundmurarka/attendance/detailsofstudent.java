package com.example.mukundmurarka.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class detailsofstudent extends SQLiteOpenHelper {
    public detailsofstudent(Context context) {
        super(context, "USER", null, 1);
    }


//    public detailsofstudent(Context context){
//        super(context,"USER",null,1);
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE STUDETAIL(" +
                "Name text," +
                "Rollno text,"+"Branch text," +"Semester text,"+"Attend text,"+
                "MobileNo text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (newVersion>oldVersion){
        sqLiteDatabase.execSQL("ALTER Table STUDETAIL ADD COLUMN Attend text");
        onCreate(sqLiteDatabase);
        }

    }
    public void addData(String name_stu, String roll_stu, String branch_stu, String semester_stu, String mobile_stu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name_stu);
        contentValues.put("Rollno", roll_stu);
        contentValues.put("Branch", branch_stu);
        contentValues.put("Semester", semester_stu);
        contentValues.put("MobileNo", mobile_stu);
        //contentValues.put("ATTEND", attend_stu);

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("STUDETAIL", null, contentValues);

    }

    public Cursor getData() {
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("STUDETAIL",null,null,null,null,null,null);
        return cursor;
    }


    public Cursor selectData(String branch_stu){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] whreArg = {branch_stu};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM STUDETAIL WHERE Branch = ? " ,whreArg);
        return cursor;
    }


    public void onDelete(String name) {
        SQLiteDatabase sqLiteDatabase =  getWritableDatabase();
        String[] whreArg = {name};
        sqLiteDatabase.delete("STUDETAIL","Name = ?", whreArg);

    }
}



