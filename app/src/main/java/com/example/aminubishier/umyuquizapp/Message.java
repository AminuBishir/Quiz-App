package com.example.aminubishier.umyuquizapp;

import android.media.MediaPlayer;

import java.util.Random;

/**
 * Created by Aminu Bishier on 9/20/2017.
 */

public class Message {
    Random random; //to be used in generating random numbers
    private double percent;
    private String name;
    private int soundIndex;

    //constructor
    public Message(double percentage, String username){
        percent = percentage;
        name = username;

    }

        //Method to return a message/remark based on the supplied score percentage
    public String getMessage(){

        //calling randNum() method to retrieve the generated random integer (0 to 2)
        int generatedNum = randNum();
        String myMessage=null;
        if(percent<50){
            soundIndex = 1;
            switch (generatedNum){

                case 0 :
                    myMessage= "Haba "+name+", you can do better than this!";
                    break;
                case 1 :
                    myMessage = "This is below average "+name+", but remember you are not an average!";
                    break;
                case 2 :
                    myMessage = "come on "+name+"!, your score is too low this time, please try harder.";


            }
        }
        else if(percent<60){
            soundIndex = 2;
            switch (generatedNum){
                case 0 :
                    myMessage= "Good job "+name+"!, try a bit harder next time!";
                    break;
                case 1 :
                    myMessage = "This is awesome "+name+", but still you can do better than this!";
                    break;
                case 2 :
                    myMessage = "You are really trying "+name+"!, your score indicates that you are not playing.";
            }

        }
        else {
            soundIndex = 3;
            switch (generatedNum){
                case 0 :
                    myMessage= "Bravo! Thank you "+name+" for this excellent performance";
                    break;
                case 1 :
                    myMessage = "Marvelous! "+name+", You are indeed a Guru!";
                    break;
                case 2 :
                    myMessage = "Gbosa! to you "+name+"!, you've done wonderfully well!.";
            }
        }
        return myMessage;
    }



    private int randNum(){
       random = new Random();
        int genNum = random.nextInt(3);
        return genNum;
    }
    public int getSoundIndex(){
        return soundIndex;
    }

}
