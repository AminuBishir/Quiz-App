package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MissedAnswerSummary extends AppCompatActivity {
Intent intent;
    Bundle bundle;
    String file_name;
    ArrayAdapter<String> adapter;
    ArrayList<String> missedSummary;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missed_answer_summary);
        file_name= getIntent().getStringExtra("file_name");
        listView = (ListView) findViewById(R.id.list_view);
        missedSummary = new ArrayList<>();
        bundle = getIntent().getExtras();
        missedSummary = bundle.getStringArrayList("missedSummary");
        adapter = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1,missedSummary);
        listView.setAdapter(adapter);
    }
    public void goToMenu(View view){
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();

    }
    public void reStart(View view){
        intent = new Intent(this,TakeQuiz.class);
        intent.putExtra("file_name",file_name);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
       super.onBackPressed();
        finish();

    }
}
