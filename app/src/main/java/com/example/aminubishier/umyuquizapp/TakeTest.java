package com.example.aminubishier.umyuquizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TakeTest extends AppCompatActivity {
QuestionBank Question = new QuestionBank();
    TextView choice1,choice2,choice3,choice4;
    TextView status,question_text;
    String correctAnswer;
    Intent intent;
    int questionLength = Question.questions.length;
    int mark=0,quest_no=1,counter=0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);
        choice1 = (TextView) findViewById(R.id.op1_txt);
        choice2 = (TextView) findViewById(R.id.op2_txt);
        choice3 = (TextView) findViewById(R.id.op3_txt);
        choice4 = (TextView) findViewById(R.id.op4_txt);
        status = (TextView) findViewById(R.id.status_txt);
        question_text = (TextView) findViewById(R.id.question_text);
        r = new Random();
        updateQuestion(counter);
        intent = new Intent();

        choice1.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v) {
                                           if(quest_no<questionLength){
                                               if(choice1.getText().toString() ==correctAnswer){
                                                   mark++;
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                               else {
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                           }
                                           else {
                                               showScore();
                                           }
                                       }
                                   }

        );
        choice2.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v) {
                                           if(quest_no<questionLength){
                                               if(choice2.getText().toString() ==correctAnswer){
                                                   mark++;
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                               else {
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                           }
                                           else {
                                               showScore();
                                           }
                                       }
                                   }

        );
        choice3.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v) {
                                           if(quest_no<questionLength){
                                               if(choice3.getText().toString() ==correctAnswer){
                                                   mark++;
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                               else {
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                           }
                                           else {
                                               showScore();
                                           }
                                       }
                                   }

        );
        choice4.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v) {
                                           if(quest_no<questionLength){
                                               if(choice4.getText().toString() ==correctAnswer){
                                                   mark++;
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                               else {
                                                   quest_no++;
                                                   updateQuestion(counter);
                                               }
                                           }
                                           else {
                                               showScore();
                                           }
                                       }
                                   }

        );

    }
    private void updateQuestion(int num){
        status.setText(quest_no+"/"+questionLength);
        question_text.setText(Question.getQuestion(num));
        choice1.setText(Question.getOp1(num));
        choice2.setText(Question.getOp2(num));
        choice3.setText(Question.getOp3(num));
        choice4.setText(Question.getOp4(num));
        correctAnswer = (Question.getAnswer(num));
        counter++;


    }
    private void showScore(){
        intent = new Intent(this, Score.class);
        String result = "You have attempted "+quest_no+" out of "+questionLength+" questions\n"+
                "Your score is "+mark+" %";
        Bundle bundle = new Bundle();
        intent.putExtra("result",result);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want finish taking the test?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {


                finish();
            }
        } );
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }
}
