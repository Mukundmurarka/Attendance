package com.example.mukundmurarka.attendance;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity {
    ListView list;
   String[] totallist = {"c","c++","pyhton", "swift", " kotlin", "java", "csharpe", "c#", "flash", "datascience", "arduino", " nfhgf","bhbjvks0", "bsnbsk"};
//    ArrayList<String> namelist;
//    ArrayList<String> totallist;
//
//    SQLiteDatabase sqLiteDatabase;
//    detailsofstudent studentdetail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        list = (ListView)findViewById(R.id.liststud);

//        totallist= new  ArrayList<>();
//        namelist = new ArrayList<>();
//
//        studentdetail= new detailsofstudent(StudentList.this);
//        Cursor cursor = studentdetail.getData();
//        sqLiteDatabase = studentdetail.getWritableDatabase();


//        if (cursor.moveToFirst()) {
//            do {
//                String name_s = cursor.getString(cursor.getColumnIndex("Name"));
//                String roll_s = cursor.getString(cursor.getColumnIndex("Rollno"));
//                String branch_s= cursor.getString(cursor.getColumnIndex("Branch"));
//                String semes_s = cursor.getString(cursor.getColumnIndex("Semester"));
//                String mobile_s= cursor.getString(cursor.getColumnIndex("MobileNo"));
//
//                namelist.add(name_s);
//                totallist.add(name_s + " " + roll_s + " " + branch_s + " "+ semes_s +" " + mobile_s);
//
//            }
//            while (cursor.moveToNext());
//        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(StudentList.this, android.R.layout.simple_list_item_1, totallist);
        list.setAdapter(arrayAdapter);

    }
}
