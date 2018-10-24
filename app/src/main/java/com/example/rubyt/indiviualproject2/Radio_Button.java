package com.example.rubyt.indiviualproject2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class Radio_Button extends Fragment {
    public QuizData mQuestionLibrary = new QuizData();
    String mAnswer;
    int mQuestionNumber = 0;
    Button submit;
    TextView questionView;
    RadioButton mButtonChoice1;
    RadioButton mButtonChoice2;
    RadioButton mButtonChoice3;
    RadioButton mButtonChoice4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio__button,
                container, false);
        questionView = (TextView) view.findViewById(R.id.question);
        mButtonChoice1 = (RadioButton) view.findViewById(R.id.radio_one);
        mButtonChoice2 = (RadioButton) view.findViewById(R.id.radio_two);
        mButtonChoice3 = (RadioButton) view.findViewById(R.id.radio_three);
        mButtonChoice4 = (RadioButton) view.findViewById(R.id.radio_four);
        submit = (Button) view.findViewById(R.id.btn_radio_sub);
        setQuestions();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.isChecked()){
                    if(mButtonChoice1.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();

                }
                if(mButtonChoice2.isChecked()){
                    if(mButtonChoice2.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();

                }
                if(mButtonChoice3.isChecked()){
                    if(mButtonChoice3.getText().toString().equals(mAnswer))
                        ((QuizActivity) getActivity()).updateScore();

                }
                if(mButtonChoice4.isChecked()){
                    if(mButtonChoice4.getText().toString().equals(mAnswer))
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

    private void updateQuestion() {
        ++mQuestionNumber;
        setQuestions();
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        if (mQuestionNumber == 2) {
            ((QuizActivity) getActivity()).setAnswers();
            ((QuizActivity) getActivity()).startCheckFrag();
        }

    }

}