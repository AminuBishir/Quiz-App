package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Login extends AppCompatActivity {
    private EditText user_email, user_password,student_name;
    private Button login_button;
    private DatabaseOpenHelper myDb;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_email = (EditText)findViewById(R.id.name_txtb);
        user_password = (EditText)findViewById(R.id.password_txtb);
        login_button = (Button) findViewById(R.id.login_btn);
        student_name = (EditText)findViewById(R.id.student_name_txtb);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the object of the DatabaseOpenHelper
                myDb = new DatabaseOpenHelper(Login.this);

                //get the email typed by user
                //String userEmail = user_email.getText().toString();
                String userEmail = "aminu@students.umyu.edu.ng";
                //extract and compare the pattern of the school email
                String schoolEmail = userEmail.substring(userEmail.indexOf("@") + 1);

                //extract user's first name
                String UserNames[] = student_name.getText().toString().split(" ");
                String userFirstName = UserNames[0];

                //checking whether the email matches the pattern
                if (schoolEmail.equals("students.umyu.edu.ng")) {

                    //the insertData returns true if successful and false if otherwise
                    boolean isInserted = myDb.insertData(schoolEmail, user_password.getText().toString(), userFirstName);

                    //if it returns true i.e successful
                    if (isInserted){
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();
                    intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                        finish();
                }
                //if it returns false i.e not successful
                    else
                        Toast.makeText(Login.this, "Login not Successful", Toast.LENGTH_LONG).show();

                    }

                    //if email doesn't match the pattern
                 else {
                    Toast.makeText(Login.this, "Please check the email", Toast.LENGTH_LONG).show();

                }
            }
        });



    }
}
