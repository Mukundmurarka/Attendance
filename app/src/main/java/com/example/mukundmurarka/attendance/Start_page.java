package com.example.mukundmurarka.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_page extends AppCompatActivity {
    Button addstudent, viewstudent, viewattendance, addfeaculty, viewfeaculty, logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        addstudent  = (Button)findViewById(R.id.addstu);
        viewstudent =(Button)findViewById(R.id.viewstu);
        viewattendance =  (Button)findViewById(R.id.viewatt);
        addfeaculty = (Button)findViewById(R.id.addfea);
        viewfeaculty = (Button)findViewById(R.id.viewfea);
        logout = (Button)findViewById(R.id.logoutbtn);

        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addstud = new Intent(Start_page.this, AddStudent.class);
                startActivity(addstud);
            }
        });


        viewstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewstud =  new Intent(Start_page.this,StudentList.class);
                startActivity(viewstud);
            }
        });



    }
}
