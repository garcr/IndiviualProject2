/*package com.example.rubyt.indiviualproject2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Check_Box extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check__box,
                container, false);
        return view;
    }
}
*/

package com.example.rubyt.indiviualproject2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class Check_Box extends Fragment {

    public QuizData mQuestionLibrary = new QuizData();
    String mAnswer;
    int mQuestionNumber = 2;
    Button submit;
    TextView questionView;
    CheckBox mButtonChoice1;
    CheckBox mButtonChoice2;
    CheckBox mButtonChoice3;
    CheckBox mButtonChoice4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check__box,
                container, false);
        questionView = (TextView) view.findViewById(R.id.question);
        mButtonChoice1 = (CheckBox) view.findViewById(R.id.check_one);
        mButtonChoice2 = (CheckBox) view.findViewById(R.id.check_two);
        mButtonChoice3 = (CheckBox) view.findViewById(R.id.check_three);
        mButtonChoice4 = (CheckBox) view.findViewById(R.id.check_four);
        submit = (Button)view.findViewById(R.id.btn_check_submit);
        setQuestions();

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if (mQuestionNumber == 5) {
                    ((QuizActivity) getActivity()).endCheckFrag();
                }
                if(mButtonChoice1.isChecked()){
                    if (mButtonChoice1.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();
                }
                if(mButtonChoice2.isChecked()){
                    if (mButtonChoice2.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();
                }
                if(mButtonChoice3.isChecked()){
                    if (mButtonChoice3.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();
                }
                if(mButtonChoice4.isChecked()){
                    if (mButtonChoice4.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();
                }


                updateQuestion();
            }

        });
        return view;
    }

    private void setQuestions(){
        questionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
    }
    public void updateQuestion(){
        if (mQuestionNumber == 4) {
            ((QuizActivity) getActivity()).setScoreText();
            ((QuizActivity) getActivity()).endCheckFrag();

        }else {
            ++mQuestionNumber;
            setQuestions();
        }

    }

}
