package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose_session_peace extends AppCompatActivity {
Intent intent;
    String path;
    Button btn_14_15,btn_15_16,btn_16_17;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_session_peace);
        btn_14_15 = (Button) findViewById(R.id.session_14_15_btn);
        btn_15_16 = (Button) findViewById(R.id.session_15_16_btn);
        btn_16_17 = (Button) findViewById(R.id.session_16_17_btn);
        
    }

    public void peace_session_14_15(View view){
        path = "question.txt";
        intent = new Intent(this.getApplicationContext(),TakeQuiz.class);
        intent.putExtra("file_name",path);
        startActivity(intent);
        finish();
    }
    public void peace_session_15_16(View view){
        path = "question.txt";
        intent = new Intent(this.getApplicationContext(),TakeQuiz.class);
        intent.putExtra("file_name",path);
        startActivity(intent);
        finish();
    }
    public void peace_session_16_17(View view){
        path = "question.txt";
        intent = new Intent(this.getApplicationContext(),TakeQuiz.class);
        intent.putExtra("file_name",path);
        startActivity(intent);
        finish();

    }
}
