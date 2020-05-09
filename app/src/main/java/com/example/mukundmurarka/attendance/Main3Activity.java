package com.example.mukundmurarka.attendance;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    private EditText teach_name, teach_email, teach_pass;
    Button submit;
    public FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        teach_name =(EditText)findViewById(R.id.tea_name);
        teach_email =  (EditText)findViewById(R.id.tea_email);
        teach_pass = (EditText)findViewById(R.id.tea_pass);
        submit = (Button)findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teachername= teach_name.getText().toString();
                String teacheremail =  teach_email.getText().toString();
                String teacherpassword = teach_pass.getText().toString();
                teacher_ragister(teachername, teacheremail,teacherpassword);
            }
        });




    }

    private void teacher_ragister(String teachername, String teacheremail, String teacherpassword) {
        mAuth.createUserWithEmailAndPassword(teacheremail, teacherpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Main3Activity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Main3Activity.this,"unsuccessfull",Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
