package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose_session_moral extends AppCompatActivity {
String course="moral",path;
    Button btn_14_15,btn_15_16,btn_16_17;
    Intent intent;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_session_moral);
        btn_14_15 = (Button) findViewById(R.id.session_14_15_btn);
        btn_15_16 = (Button) findViewById(R.id.session_15_16_btn);
        btn_16_17 = (Button) findViewById(R.id.session_16_17_btn);
        bundle = new Bundle();
    }

    public void moral_session_14_15(View view){
        path = "question.txt";
        intent = new Intent(this,TakeQuiz.class);
        intent.putExtra("file_name",path);
        startActivity(intent);
        finish();
    }
    public void moral_session_15_16(View view){
        path = "question.txt";
        intent = new Intent(this.getApplicationContext(),TakeQuiz.class);
        intent.putExtra("file_name",path);
        startActivity(intent);
        finish();
    }
    public void moral_session_16_17(View view){
        path = "question.txt";
        intent.putExtra("file_name",path);
        startActivity(intent);
        finish();
    }
}
