package com.example.mukundmurarka.attendance;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Student_Ragistration extends AppCompatActivity {
    TextView textView1, textView2, textView3,  textView5, textView6;
    EditText Name, Roll_no, Branch,  Emaiid, pass;
    Button sub;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = (TextView)findViewById(R.id.name);
        textView2 = (TextView)findViewById(R.id.rollno);
        textView3 = (TextView)findViewById(R.id.branch);

        textView5 =  (TextView)findViewById(R.id.email);
        textView6 = (TextView)findViewById(R.id.textView5);
        Name = (EditText) findViewById(R.id.full_name);
        Roll_no = (EditText) findViewById(R.id.roll_no);
        Branch = (EditText) findViewById(R.id.bran);

        Emaiid = (EditText) findViewById(R.id.emailid);
        sub = (Button) findViewById(R.id.submit);
        pass = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentname = Name.getText().toString();
                String stu_Roll = Roll_no.getText().toString();
                String stu_branch = Branch.getText().toString();

                String stu_email = Emaiid.getText().toString();
                String stu_pass = pass.getText().toString();
                user_ragistration(studentname, stu_Roll, stu_branch, stu_email, stu_pass);
            }

        });
    }

    private void user_ragistration(String studentname, String stu_roll, String stu_branch,  String stu_email, String stu_pass) {
        mAuth.createUserWithEmailAndPassword(stu_email, stu_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Student_Ragistration.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Student_Ragistration.this,"something error occur ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}



