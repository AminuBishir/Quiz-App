package com.example.aminubishier.umyuquizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.support.v7.appcompat.R.styleable.View;

public class MainActivity extends AppCompatActivity {
    Intent go_to_gsp;
    Intent go_to_eds;
    Intent go_to_about;
    Intent go_to_help;
    Button gsp_btn;
    Button eds_btn;
    Button help_btn;
    Button about_btn;
    Button quit_btn;
    MediaPlayer sound;
    DatabaseOpenHelper mydb;
    String message;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_to_gsp = new Intent(getApplicationContext(), GSP.class);
        go_to_help = new Intent(getApplicationContext(), Help.class);
        go_to_about = new Intent(getApplicationContext(), About.class);
        sound = MediaPlayer.create(this.getBaseContext(),R.raw.background_sound);
        sound.start();
        gsp_btn = (Button) findViewById(R.id.gsp_btn);
        eds_btn = (Button) findViewById(R.id.eds_btn);
        help_btn = (Button) findViewById(R.id.help_btn);
        about_btn = (Button) findViewById(R.id.about_btn);
        quit_btn = (Button) findViewById(R.id.quit_btn);
       // message = mydb.getStudentName();


    }

    public void goingToGsp(android.view.View view) {
        startActivity(go_to_gsp);

        sound.stop();
        finish();
    }

    //Start EDS test
    public void goingToEds(View view) {
        path = "eds_one_a.txt";
        go_to_eds = new Intent(this.getApplicationContext(),TakeQuiz.class);
        go_to_eds.putExtra("file_name",path);
        startActivity(go_to_eds);
       sound.stop();
        finish();
    }



    public void goingToAbout(android.view.View view) {
        startActivity(go_to_about);


    }

    public void goingToHelp(android.view.View view) {
        startActivity(go_to_help);


    }

    public void quit(android.view.View view) {
        sound.stop();
        finish();

    }

    @Override
    public void onBackPressed() {


    }
}
