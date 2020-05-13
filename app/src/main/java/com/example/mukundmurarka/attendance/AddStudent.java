package com.example.mukundmurarka.attendance;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    EditText e1,e2,e3, e4, e5;
    Button ok;
    detailsofstudent studentdetail;
    SQLiteDatabase database;
    Cursor cursor;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        e1 = (EditText)findViewById(R.id.name_s);
        e2 = (EditText)findViewById(R.id.roll_s);
        e3 = (EditText)findViewById(R.id.branch_s);
        e4 = (EditText)findViewById(R.id.sem_s);
        e5 = (EditText)findViewById(R.id.mobile_s);
        ok = (Button)findViewById(R.id.btn_s);
        context = AddStudent.this;


//        final String name_s = e1.getText().toString().trim();
//        final String rollno_s = e2.getText().toString().trim();
//        final String branch_st = e3.getText().toString().trim();
//        final String seme_s = e4.getText().toString().trim();
//        final String mobile_st =  e5.getText().toString().trim();




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (TextUtils.isEmpty(e1.getText().toString()) ){
                   Toast.makeText(AddStudent.this , "fill all the field", Toast.LENGTH_SHORT).show();
               }
               else{
                    studentdetail = new detailsofstudent(AddStudent.this);
                    studentdetail.addData(e1.getText().toString().trim(),e2.getText().toString().trim(),e3.getText().toString().trim(),e4.getText().toString().trim(),e5.getText().toString().trim());
                   Intent intent1 = new Intent(AddStudent.this, StudentList.class);
                   startActivity(intent1);
                    Toast.makeText(AddStudent.this, "add successfully", Toast.LENGTH_SHORT).show();

               }
            }
        });

    }
}
