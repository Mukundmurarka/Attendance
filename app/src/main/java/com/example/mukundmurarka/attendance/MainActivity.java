package com.example.mukundmurarka.attendance;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button student, teacher, create,log;
    EditText id,password;

    public static final int user_stu=1;
    public static final int user_tea = 2;
    int user = 0;
    private com.google.firebase.auth.FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText)findViewById(R.id.emailid);
        password = (EditText)findViewById(R.id.pass);
        student = (Button)findViewById(R.id.button3);
        teacher = (Button)findViewById(R.id.tea_btn);
        create= (Button)findViewById(R.id.create);
        log= (Button)findViewById(R.id.loginbtn);

        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();



        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginid = id.getText().toString();
                String loginpass = password.getText().toString();
                if(TextUtils.isEmpty(loginid) || TextUtils.isEmpty(loginpass)){
                    Toast.makeText(MainActivity.this,"please enter id and password ",Toast.LENGTH_SHORT).show();
                }else {


                    loginuser(loginid, loginpass);
                }

            }
        });



        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=user_stu;
                student.setLinkTextColor(getResources().getColor(R.color.colorPrimaryDark));
                teacher.setLinkTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=user_tea;
                teacher.setLinkTextColor(getResources().getColor(R.color.colorPrimaryDark));
                student.setLinkTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user==0){
                    Toast.makeText(MainActivity.this,"please select a user",Toast.LENGTH_LONG).show();
                }else if (user==1){
                    Intent intent = new Intent(MainActivity.this, Student_Ragistration.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(intent);

                }
            }
        });
    }

    private void loginuser(String loginid, String loginpass) {
        mAuth.signInWithEmailAndPassword(loginid, loginpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()) {
                  if(user==0){
                      Toast.makeText(MainActivity.this,"please select a user",Toast.LENGTH_LONG).show();
                  }else if (user==1){
                      Intent intent = new Intent(MainActivity.this, Start_page.class);
                      startActivity(intent);
                      finish();
                  }
                  else{
                      Intent intent = new Intent(MainActivity.this, Teacheractivity.class);
                      startActivity(intent);
                      finish();

                  }
//                  Intent mintent = new Intent(MainActivity.this, Start_page.class);
//                  startActivity(mintent);
//                  finish();
              }else{
                  Toast.makeText(MainActivity.this,"email and password is incorrect ", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser ==  null){
//            Intent intent1 = new Intent(MainActivity.this,Start_page.class);
//            startActivity(intent1);
//            finish();
            Toast.makeText(MainActivity.this , "please login ", Toast.LENGTH_SHORT).show();

        }

    }



}


