package com.example.mukundmurarka.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Teacheractivity extends AppCompatActivity {
    Button view, add, total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheractivity);
        view = (Button)findViewById(R.id.viewatt);
        add = (Button)findViewById(R.id.addatt);
        total =  (Button)findViewById(R.id.totalatt);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Teacheractivity.this,Viewattendance.class);
                startActivity(intent1);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Teacheractivity.this,AddAttendance.class);
                startActivity(intent2);

            }
        });
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 =  new Intent(Teacheractivity.this,TotalAttendance.class);
                startActivity(intent3);
            }
        });
    }
}
