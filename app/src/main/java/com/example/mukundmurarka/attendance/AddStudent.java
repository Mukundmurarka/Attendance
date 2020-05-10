package com.example.mukundmurarka.attendance;

import android.content.Intent;
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


        final String name_s = e1.getText().toString().trim();
        final String rollno_s = e2.getText().toString().trim();
        final String branch_st = e3.getText().toString().trim();
        final String seme_s = e4.getText().toString().trim();
        final String mobile_st =  e5.getText().toString().trim();




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (TextUtils.isEmpty(name_s) || TextUtils.isEmpty(rollno_s) || TextUtils.isEmpty(branch_st) || TextUtils.isEmpty(seme_s) || TextUtils.isEmpty(mobile_st)){
                   Toast.makeText(AddStudent.this , "fill all the field", Toast.LENGTH_SHORT).show();
               }
               else{
                    studentdetail = new detailsofstudent(AddStudent.this);


               }
            }
        });

    }
}
