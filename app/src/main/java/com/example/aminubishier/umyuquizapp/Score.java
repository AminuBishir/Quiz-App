package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Score extends AppCompatActivity {
TextView displayInfo;
    TextView motivationMessage;
    Intent intent;
    String file_name; //to hold name of the file containing questions
    String name; // to retrieve and hold name of the student
    ArrayList<String> missedSummary;
    DatabaseOpenHelper myDB;
    MediaPlayer excellent,good,bad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle bundle;
        bundle = getIntent().getExtras();
        missedSummary = new ArrayList<>();
        int  attempted_questions = bundle.getInt("attempted");
        int correctly_answered = bundle.getInt("correctly");
        int wrongly_answered = bundle.getInt("wrongly");
        double score_percent = bundle.getDouble("percent");
        int total_questions = bundle.getInt("total");
        missedSummary = bundle.getStringArrayList("missedSummary");
        file_name= getIntent().getStringExtra("file_name");
        myDB = new DatabaseOpenHelper(this);
        String content = "Attempted: "+attempted_questions +" out of "+total_questions+" \n\n"+
                "Correct answers: "+correctly_answered+" \n\n" +
                "Wrong answers: "+wrongly_answered+" \n\n"+
                "Score percentage: "+score_percent+"%";
        name = myDB.getStudentName(); //getting the student name from DB
        //creating object of the class Message
        Message myMessage = new Message(score_percent, name);

        //variable to hold the motivational message;
        String messageToBeShown = myMessage.getMessage();

        motivationMessage = (TextView) findViewById(R.id.message_txt);
        motivationMessage.setText(messageToBeShown);

        displayInfo = (TextView) findViewById(R.id.displayInfo);
        displayInfo.setText(content);

        //initializing sound players
        excellent = MediaPlayer.create(this.getBaseContext(),R.raw.stadiumapplause);
        good = MediaPlayer.create(this.getBaseContext(),R.raw.audienceapplause);
        bad = MediaPlayer.create(this.getBaseContext(),R.raw.woahsound);

        //To select type of sound to be played, according  to user's performance
        int index = myMessage.getSoundIndex();
        switch (index){
            case 1: bad.start();
                break;
            case 2: good.start();
                break;
            case 3: excellent.start();
                break;
        }

    }
    public void goToMenu(View view){
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }
    public void reStart(View view){
        intent = new Intent(this,TakeQuiz.class);
        intent.putExtra("file_name",file_name);
        startActivity(intent);
        finish();
    }
    public  void goToSummary(View view){
        intent = new Intent(this,MissedAnswerSummary.class);
        intent.putExtra("file_name",file_name);
        intent.putExtra("missedSummary",missedSummary);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

    }
}
