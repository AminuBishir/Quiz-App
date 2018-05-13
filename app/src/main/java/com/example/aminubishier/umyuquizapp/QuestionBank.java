package com.example.aminubishier.umyuquizapp;

/**
 * Created by Aminu Bishier on 7/1/2017.
 */

public class QuestionBank {
    public QuestionBank(){

    }
    String questions[]={"Who was the first president of Nigeria?",
            "Who was the first Prime minister of Nigeria?",
            "In which year festac festival took place?",
            "WHO was the first CBN Governor?",
            "Who was the vice President of Nigeria during Buhari's firs Administration?",
            "Who took over power after president Olusegun Obasanjo?",
            "Who is the current president of Nigeria?",
            "Which type of currency does Nigeria use currently?",
            "Who was the successor of  Aliyu mai Borno?",
            "What is the full meaning of INEC?"};

    String[][]options={{"Muhammad Buhari", "Olusegun Obasanjo", "Tafawa Balewa", "Nnamdi Azikwe"},
            {"Ahmadu Bello Sardauna", "Obafemi Awolowo", "Tafawa Balewa", "Murtala Muhammad"},
            {"1950", "1975", "1980", "1966"},
            {"Roy Pentelow Fenton", "Sanusi Lamido Sanusi", "Aliyu mai Borno", "Clement Isong"},
            {"Atiku Abubakar", "Tunde Idiagbon", "Earnest Shonekan", "Yemi Osinbajo"},
            {"Umar Musa Yaradua", "Goodluck Jonathan", "Namadi Sambo", "Sani Abacha"},
            {"Olusegun Obasanjo", "Goodluck Jonathan", "Muhammad Buhari", "Atiku Abubakar"},
            {"Dollar", "Cedi", "Naira", "Pound"},
            {"Clement Isong", "Sanusi Lamido Sanusi", "Ngozi O. Iwela", "Godwin Emefele"},
            {"Independent Nigeria Election Commision", "Independent National Election Commision", "Independent National Electoral Commision", "Inter National Electoral Commision"}
    };
    String answers[]={"Nnamdi Azikwe",
            "Tafawa Balewa",
            "1966",
            "Roy Pentelow Fenton",
            "Tunde Idiagbon",
            "Umar Musa Yaradua",
            "Muhammad Buhari",
            "Naira",
            "Clement Isong",
            "Idependent National Electoral Commision"};

    public  String getQuestion(int i){
        String question = questions[i];
        return question;
    }
    public String getOp1(int i){
        String op1 = options[i][0];
        return op1;
    }
    public String getOp2(int i){
        String op2 = options[i][1];
        return op2;
    }
    public  String getOp3(int i){
        String op3 = options[i][2];
        return op3;
    }
    public  String getOp4(int i){
        String op4 = options[i][3];
        return op4;
    }
    public String getAnswer(int i){
        String ans = answers[i];
        return ans;
    }
}
