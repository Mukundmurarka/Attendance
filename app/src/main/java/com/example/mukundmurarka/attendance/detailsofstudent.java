package com.example.mukundmurarka.attendance;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class detailsofstudent extends SQLiteOpenHelper {


    detailsofstudent(Context context){
        super(context,"studetail",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER(" +
                "Name text," +
                "Rollno text," +
                "Branch text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
