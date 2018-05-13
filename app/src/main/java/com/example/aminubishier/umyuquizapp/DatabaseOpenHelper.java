package com.example.aminubishier.umyuquizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * This class will handle the database operations
 * Created by Aminu Bishier on 7/29/2017.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "user.db";
    private static String TABLE_NAME = "login";
    private static String COL1 = "Username";
    private static String COL2 = "Password";
    private static String COL3 = "student_name";
    private static String login_name;
    private static String student_name;

    //create the database via DatabaseOpenHelper constructor
    public DatabaseOpenHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    //query for creating the database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(Username TEXT, Password TEXT, student_name TEXT)");

    }

    //create the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

db.execSQL("DROP TABLE IF EXIST" +DATABASE_NAME);
         onCreate(db);
    }

    //Method for inserting data into the database
    public boolean insertData(String userEmail, String password, String student_name){
        SQLiteDatabase putData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,userEmail);
        contentValues.put(COL2,password);
        contentValues.put(COL3,student_name);

        long result = putData.insert(TABLE_NAME,null,contentValues);
        //return false if data is not inserted
        if(result==-1)
           return false;

        //return true if the data is inserted
        else
            return true;
    }
    //Method for returning username/email of the user from the database
    public String getUsername(){
        SQLiteDatabase getData = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " +TABLE_NAME;
        Cursor cursor = getData.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
             login_name = cursor.getString(cursor.getColumnIndex(COL1));
            return login_name;
        }
        else
            return null;
    }

    //Method to retrieve the name of the user/student form the database
    public String getStudentName(){
        SQLiteDatabase getData = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " +TABLE_NAME;
        Cursor cursor = getData.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            student_name = cursor.getString(cursor.getColumnIndex(COL3));
            return student_name;
        }
        else
            return " ";
    }
}
