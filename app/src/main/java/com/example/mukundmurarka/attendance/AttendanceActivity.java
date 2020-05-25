package com.example.mukundmurarka.attendance;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button btn;
    EditText tv;

    ArrayList<String> namelist;
    ArrayList<String> totallist;
    ArrayAdapter <String> arrayAdapter;

    SQLiteDatabase sqLiteDatabase;
    detailsofstudent studentdetail;

    ListView lv;
    int rid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        rg = (RadioGroup) findViewById(R.id.selbranch);
        btn = (Button) findViewById(R.id.button2);
        lv = (ListView) findViewById(R.id.listtsttu);
        tv = (EditText) findViewById(R.id.cccc);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rid = rg.getCheckedRadioButtonId();
                rb = findViewById(rid);
                 tv.setText(rb.getText().toString());
//                namelist.add(branch);
//                lv.setAdapter(arrayAdapter);


                totallist = new ArrayList<>();
                namelist = new ArrayList<>();

                String search = tv.getText().toString().trim();

                studentdetail = new detailsofstudent(AttendanceActivity.this);
                Cursor cursor;
                cursor = studentdetail.selectData(rb.getText().toString());
                //Cursor cursor = sqLiteDatabase.rawQuery("Select * From STUDETAIL where Branch =" + tv.setText(rb.getText().toString().trim())+,null );
                sqLiteDatabase = studentdetail.getWritableDatabase();


                if (cursor.moveToFirst()) {
                    do {
                        String name_s = cursor.getString(cursor.getColumnIndex("Name"));
                        String roll_s = cursor.getString(cursor.getColumnIndex("Rollno"));
                        String branch_s = cursor.getString(cursor.getColumnIndex("Branch"));
                        String semes_s = cursor.getString(cursor.getColumnIndex("Semester"));
                        String mobile_s = cursor.getString(cursor.getColumnIndex("MobileNo"));

                        namelist.add(name_s);
                        totallist.add(name_s + " " + roll_s + " " + branch_s + " " + semes_s + " " + mobile_s);

                    }
                    while (cursor.moveToNext());
                }
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_list_item_1, totallist);
                lv.setAdapter(arrayAdapter);

                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                        AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceActivity.this);

                        builder.setTitle("Confirm");
                        builder.setMessage("you are present or not ?");

                        builder.setPositiveButton("p", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(AttendanceActivity.this, "you are present ", Toast.LENGTH_LONG).show();

                                dialog.dismiss();
                            }
                        });

                        builder.setNegativeButton("b", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(AttendanceActivity.this, "you are present ", Toast.LENGTH_LONG).show();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();

                        return true;
                    }
                });


            }
        });
    }
//        totallist= new  ArrayList<>();
//        namelist = new ArrayList<>();
//
//        String search= tv.getText().toString().trim();
//
//        studentdetail= new detailsofstudent(AttendanceActivity.this);
//        Cursor cursor;
//        cursor = studentdetail.getData();
//        //Cursor cursor = sqLiteDatabase.rawQuery("Select * From STUDETAIL where Branch =" + tv.setText(rb.getText().toString().trim())+,null );
//        sqLiteDatabase = studentdetail.getWritableDatabase();
//
//
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
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AttendanceActivity.this, android.R.layout.simple_list_item_1, totallist);
//        lv.setAdapter(arrayAdapter);
//
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceActivity.this);
//
//                builder.setTitle("Confirm");
//                builder.setMessage("you are present or not ?");
//
//                builder.setPositiveButton("p", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//
//                       Toast.makeText(AttendanceActivity.this, "you are present ", Toast.LENGTH_LONG).show();
//
//                        dialog.dismiss();
//                    }
//                });
//
//                builder.setNegativeButton("b", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        Toast.makeText(AttendanceActivity.this, "you are present ", Toast.LENGTH_LONG).show();
//                    }
//                });
//                AlertDialog alert = builder.create();
//                alert.show();
//
//                return true;
//            }
//        });
//    }
    public  void checkbtn(View v){
        rid = rg.getCheckedRadioButtonId();
        rb = findViewById(rid);
        //String rb1 = rb.getText().toString();
        Toast.makeText(AttendanceActivity.this, "select branch" + rb.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}
