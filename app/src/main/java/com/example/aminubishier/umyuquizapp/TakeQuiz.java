package com.example.aminubishier.umyuquizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TakeQuiz extends AppCompatActivity {
RadioGroup rdg;
    RadioButton opt1,opt2,opt3,opt4;
    Button next_button;

    /*status = textview to hold number of questions attempted out of total, questions = testview for holding questions number*/
    TextView status,question;

    /*creating inputStreamReader object*/
    InputStream is;

    /*declaring object of type QuestionRepo (which is our constructor)*/
    QuestionsRepo questionsRepo;

    //declaring obj of type BufferedReader
    BufferedReader file;

    int count=0; //used to fetch next question
    int mark=0;  //holds the marks or points earned
    int status_count=1;  //keeps track of current question
    int missed_counter=0;  //holds number of questions missed
    ArrayList<String> missedSummary;
    String correctAnswer;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

          /*importing the Extras 'inherited' from the previous activity (i.e file path)*/
        final String FILE_NAME = getIntent().getStringExtra("file_name");

          //to displays the current question out of the total
        status = (TextView) findViewById(R.id.display_status_txt);

          //to display the question
        question = (TextView) findViewById(R.id.display_question_txt);

          //Groups radio buttons for the options
        rdg = (RadioGroup) findViewById(R.id.radioGrp);
        opt1 = (RadioButton) findViewById(R.id.display_option1_rd);
        opt2 = (RadioButton) findViewById(R.id.display_option2_rd);
        opt3 = (RadioButton) findViewById(R.id.display_option3_rd);
        opt4 = (RadioButton) findViewById(R.id.display_option4_rd);
          next_button = (Button) findViewById(R.id.next_button);
        try{

            /*the inputStreamReader object (is) is used to open the file whose name is passed from the previous activity
            and stored in the string variable fileName*/
            is = getResources().getAssets().open(FILE_NAME);

        }
          catch (IOException e){
              e.printStackTrace();
          }

          missedSummary = new ArrayList<>(); //Holed index of questions missed/answered incorrectly

          //wrapping the BufferedReader object
          file = new BufferedReader(new InputStreamReader(is));

          //calling the QuestionRepo constructor and passing the variable/object (which is of BufferedReader)*/
        questionsRepo = new QuestionsRepo(file);

        /*calling the method of the QuestionRepo constructor in order to tokenize the file stream stored in the Buffer*/
        questionsRepo.Tokenize();

          //see the method below
        updateScreen(count);

          //Setting an onClick method for the Next button
          next_button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(rdg.getCheckedRadioButtonId()!=-1) {
                      updateScore();
                      if (count < questionsRepo.getQuestions().length) {

                          updateScreen(count);
                          rdg.clearCheck();
                      } else
                          endQuiz();
                  }
                  else {
                      //print message indicating that no answer was selected
                      Toast.makeText(getApplicationContext(), "Please choose an answer", Toast.LENGTH_LONG).show();
                  }


              }
          } );


    }
    /*this method will update the screen (status, question, options and the answer) whenever called*/
    public void  updateScreen(int num){

        //this will set question_no/no_of_questions
        status.setText(status_count+"/"+questionsRepo.getQuestions().length);
        question.setText(questionsRepo.getQuestion(num));
        opt1.setText(questionsRepo.getOp1(num));
        opt2.setText(questionsRepo.getOp2(num));
        opt3.setText(questionsRepo.getOp3(num));
        opt4.setText(questionsRepo.getOp4(num));
        correctAnswer = questionsRepo.getAnswer(num);
        count++;
        status_count++;
    }
    public void endQuiz(){
        int attempted_questions, correctly_answered,wrongly_answered,total;
        double percentage;
        attempted_questions = count;
        correctly_answered = mark;
        wrongly_answered = (count - mark);
        total = questionsRepo.getQuestions().length;
        double ratio = ((double)correctly_answered / (double)total);
        percentage = (ratio *100);
        String fileName = getIntent().getStringExtra("file_name");
        Intent intent = new Intent(getApplicationContext(),Score.class);
        intent.putExtra("attempted",attempted_questions);
        intent.putExtra("wrongly",wrongly_answered);
        intent.putExtra("correctly",correctly_answered);
        intent.putExtra("percent",percentage);
        intent.putExtra("total",total);
        intent.putExtra("file_name",fileName);
        intent.putStringArrayListExtra("missedSummary",missedSummary);
        startActivity(intent);
        finish();

    }
    public void updateScore(){
        rdg = (RadioGroup) findViewById(R.id.radioGrp);
        if(rdg.getCheckedRadioButtonId() != -1){
            int id = rdg.getCheckedRadioButtonId();
            View findButton = rdg.findViewById(id);
            int radioID = rdg.indexOfChild(findButton);
            RadioButton checkedButton = (RadioButton) rdg.getChildAt(radioID);
            String checked_radioButton_text = checkedButton.getText().toString();
            if(checked_radioButton_text.equalsIgnoreCase(correctAnswer)){
                mark++;
                missed_counter++;
            }
            else {
                //populate missedSummary ArrayList with the Question and its answer.
                missedSummary.add(questionsRepo.getQuestion(missed_counter)+"\n"+"\t Ans: "+questionsRepo.getAnswer(missed_counter));
                missed_counter++;
            }
        }
        else {
            Toast.makeText(this,"Please choose an answer",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want end taking the test?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                endQuiz();

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
