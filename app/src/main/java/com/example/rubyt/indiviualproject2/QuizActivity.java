package com.example.rubyt.indiviualproject2;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {
    android.support.v4.app.FragmentManager fragMan;
    TextView anserTxt;
    String mAnswer;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;

    int score = 0;
    TextView scoreTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        scoreTxt = (TextView)findViewById(R.id.scoreTxtQ);
        anserTxt = (TextView)findViewById(R.id.answersTxt);
/*
        SharedPreferences shareQuiz = getSharedPreferences("QuizData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shareQuiz.edit();
        editor.putString("question", "What does fragment do?");
        editor.putString("answer", "Something");
        Toast.makeText(this, "Score Saved", Toast.LENGTH_SHORT).show();
        editor.commit();
*/

        fragMan = getSupportFragmentManager();

        Fragment fragRadio = fragMan.findFragmentByTag("R");//new Radio_Button();


        android.support.v4.app.FragmentTransaction trans = fragMan.beginTransaction();
        if(fragRadio == null) {
            fragRadio = new Radio_Button();
            trans.add(R.id.fragmentAct, fragRadio, "R");
            trans.commit();
        }

    }

    public void startCheckFrag(){
        fragMan = getSupportFragmentManager();
        Check_Box checkBox = new Check_Box();
        android.support.v4.app.FragmentTransaction trans = fragMan.beginTransaction();
        trans.replace(R.id.fragmentAct,checkBox,"C");
        trans.commit();
    }

    public void endCheckFrag(){
        Check_Box checkBox = (Check_Box)fragMan.findFragmentByTag("C");
        android.support.v4.app.FragmentTransaction trans = fragMan.beginTransaction();
        trans.remove(checkBox);
        trans.commit();
    }
    public void updateScore(){
        score+=1;
    }

    public void setScoreText(){
        scoreTxt.setText("Score: " + score);
    }

    public void storeAnswer(int pos, String userAnswer){
      //  answers[pos] = userAnswer;
    }
    public void setAnswers(){
        //anserTxt.setText(answers[0]);
        anserTxt.setText(answer1);
    }
}
