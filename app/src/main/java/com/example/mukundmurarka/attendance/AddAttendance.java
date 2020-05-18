
package com.example.mukundmurarka.attendance;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddAttendance extends AppCompatActivity {
    RadioGroup radioBranch, radioSubject;
    RadioButton radio1, radio2;

    Button okk;

    public int day, month, Year;

    EditText date;
    DatePickerDialog datePickerDialog;

    TextView textView1, textView2;


    int radioId1, radioId2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        radioBranch = (RadioGroup) findViewById(R.id.radiobranch);
        radioSubject = (RadioGroup) findViewById(R.id.radiosubject);
        okk = (Button) findViewById(R.id.ok1);
        date = (EditText) findViewById(R.id.dateatt);
        textView1 = (TextView)findViewById(R.id.textbranch);
        textView2 = (TextView)findViewById(R.id.textView8);



        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calender = Calendar.getInstance();
                int Year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddAttendance.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
                        date.setText(dayofmonth + "/" +(monthofyear + 1)+ "/" +year);
                    }
                } , Year, month,day);
                datePickerDialog.show();

            }
        });


        okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    radioId1 = radioBranch.getCheckedRadioButtonId();
                   radioId2= radioSubject.getCheckedRadioButtonId();
                    radio1 = findViewById(radioId1);
                    radio2 =  findViewById(radioId2);
                    textView1.setText("your choice  " +radio1.getText());
                    textView2.setText("your subject " + radio2.getText());
                Intent intent = new Intent(AddAttendance.this,AttendanceActivity.class);
                startActivity(intent);



//                    Toast.makeText(AddAttendance.this," plaese select branch or subject",Toast.LENGTH_SHORT).show();

//                    radioId1 = radioBranch.getCheckedRadioButtonId();
//                    radioId2= radioSubject.getCheckedRadioButtonId();
//                    radio1 = findViewById(radioId1);
//                    radio2 =  findViewById(radioId2);
//                    textView.setText("your choice  " +radio1.getText()+ " " +radio2.getText());

                }



        });

    }

    public void checkbranch(View V) {
        radioId1 = radioBranch.getCheckedRadioButtonId();
        radio1 = findViewById(radioId1);
        Toast.makeText(AddAttendance.this, "select branch" + radio1.getText(), Toast.LENGTH_SHORT).show();
    }

    public void checksubject(View V) {
        radioId2 = radioSubject.getCheckedRadioButtonId();
        radio2 = findViewById(radioId2);
        Toast.makeText(AddAttendance.this, "select subject" + radio2.getText(), Toast.LENGTH_SHORT).show();


    }
}
