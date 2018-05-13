package com.example.aminubishier.umyuquizapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Aminu Bishier on 7/6/2017.
 */

public class QuestionsRepo{
    private BufferedReader File;
    private static final int QUESTION_NUMBER=100;
    private String questions[]=new String[ QUESTION_NUMBER], answers[]=new String[ QUESTION_NUMBER];
    private String options[][]=new String[ QUESTION_NUMBER][4];
    private    int o_count=0,q_count=0,a_count=0;

    //class constructor with BufferedReader obj as arg.
    public QuestionsRepo(BufferedReader file){
        File = file;

         }
         //This method will tokenize the content of the text file
    public void Tokenize(){
        try {

            String line;

            //contains "untokenized" lines of text
            String[] linesContainer = new String[QUESTION_NUMBER];

            //for holding current number of line to be read
            int linesCounter=0;

            //loop to populate the linesContainer
            while((line=File.readLine())!=null){
                linesContainer[linesCounter] = line;
                linesCounter++;

            }

            //call the reshuffledArray method and assign the returned value to shuffledQuestions
            String[] shuffledQuestions = reshuffleArray(linesContainer);

            //loop to tokenize the whole of shuffledQuestions into individual question, option and answer
            for(String s : shuffledQuestions) {
                StringTokenizer tokenizer = new StringTokenizer(s, "#,:");
                questions[q_count] = tokenizer.nextToken();
                q_count++;
                options[o_count][0] = tokenizer.nextToken();

                options[o_count][1] = tokenizer.nextToken();

                options[o_count][2] = tokenizer.nextToken();

                options[o_count][3] = tokenizer.nextToken();
                o_count++;
                answers[a_count] = tokenizer.nextToken();
                a_count++;


            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //method to get array of questions
    public String[] getQuestions(){
        return
                questions;
    }

    public String getQuestion(int num){
       return questions[num];

    }
    //methods getOp1 to getOp4 return consecutive options for a given question
    public String getOp1(int num){
        return options[num][0];
    }
    public String getOp2(int num){
        return options[num][1];
    }
    public String getOp3(int num){
        return options[num][2];
    }
    public String getOp4(int num){
        return options[num][3];
    }

    //method to get and return the answer for a given question
    public String getAnswer(int num){
        return answers[num];
    }

    //Method to reshuffle any supplied array of strings
    public static String[] reshuffleArray(String[] array){
        Random randomNumberGenerator = new Random();
        int randomNumber;
        String[] shuffledArray = new String[QUESTION_NUMBER];
        int count =0; //to be used in the while loop below
        int count1 =0; //to be used in the reshuffling loop

        //create array list obj of type int, to hold random nums from 0 to questions.length (QUESTION_NUMBER)
        ArrayList<Integer> randomNumbersArray = new ArrayList<Integer>();
        while(count<QUESTION_NUMBER){
            randomNumber = randomNumberGenerator.nextInt(QUESTION_NUMBER);

            //if generated random number doesn't exist in the arrayList, then add it, else do nothing
            if(!randomNumbersArray.contains(randomNumber)){
                randomNumbersArray.add(randomNumber);
                count++;
            }

        }
        /*use the randomly generated randomNumbersArray as an index of the passed array of string, and then assign its value to the
        new shuffledArray which has count1 as an index (which starts from 0 to length of randomNumbersArray)
        */

        for(int i : randomNumbersArray){
            shuffledArray[count1]=array[i];
            count1++;
        }
        return shuffledArray; //return the shuffled array of string
    }

}
