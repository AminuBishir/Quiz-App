package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GSP extends AppCompatActivity {
Intent goToPeace;
    Intent goToEnglish1;
    Intent goToEnglish2;
    Intent goToEnvironmental;
    Intent goToMoral;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsp);
        goToPeace =new  Intent(this,TakeQuiz.class);
        goToEnglish1 =new  Intent(this,TakeQuiz.class);
        goToEnglish2 =new  Intent(this,TakeQuiz.class);
        goToEnvironmental =new  Intent(this,TakeQuiz.class);
        goToMoral =new  Intent(this,TakeQuiz.class);
    }
    public void peace(android.view.View view){

            path = "peace_and_conflict.txt";
            goToPeace = new Intent(this.getApplicationContext(),TakeQuiz.class);
            goToPeace.putExtra("file_name",path);
            startActivity(goToPeace);
            finish();


    }
    public void english1(android.view.View view){
        path = "use_of_eng_1.txt";
        goToEnglish1 = new Intent(this.getApplicationContext(),TakeQuiz.class);
        goToEnglish1.putExtra("file_name",path);
        startActivity(goToEnglish1);
        finish();

    }
    public void english2(android.view.View view){
        path = "use_of_eng_1.txt";
        goToEnglish2 = new Intent(this.getApplicationContext(),TakeQuiz.class);
        goToEnglish2.putExtra("file_name",path);
        startActivity(goToEnglish2);
        finish();


    }
    public void environmental(android.view.View view){
        path = "environmental.txt";
        goToEnvironmental = new Intent(this.getApplicationContext(),TakeQuiz.class);
        goToEnvironmental.putExtra("file_name",path);
        startActivity(goToEnvironmental);
        finish();

    }
    public void moral(android.view.View view){
        path = "moral.txt";
        goToMoral = new Intent(this.getApplicationContext(),TakeQuiz.class);
        goToMoral.putExtra("file_name",path);
        startActivity(goToMoral);
        finish();
    }
}
