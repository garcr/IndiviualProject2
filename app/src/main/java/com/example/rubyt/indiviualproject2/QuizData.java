package com.example.rubyt.indiviualproject2;

public class QuizData {

    private String mQuestions[] = {
            "What color a is fire truck?",
            "How many legs does a dog have?",
            "What describes a soccer ball?",
            "What describes a dog?",
            "What does a computer have?",
            "N/A"

    };

    private String mChoices[][] = {
            {"Red", "Blue", "White", "Green"},
            {"Three", "Four", "One", "None"},
            {"Round", "Sqaure", "Triangle", "Orange"},
            {"Tail", "Flies", "Speaks", "Human"},
            {"Wings", "CPU", "Ears", "Eyes"},
            {"Null", "Null", "Null", "Null"},
    };

    private String mCorrectAnswers[] = {"Red", "Four", "Round", "Tail", "CPU", "Null"};
    private String answers2 [][]= {
            {"Round", "Square", "White"},
            {"Barks", "Furry"},
            {"RAM", "CPU", "SSD"}
    };
    public QuizData(){

    }

    public String getQuestion(int quesNum) {
        String question = mQuestions[quesNum];
        return question;
    }


    public String getChoice1(int cNum) {
        String choice1 = mChoices[cNum][0];
        return choice1;
    }


    public String getChoice2(int cNum) {
        String choice1 = mChoices[cNum][1];
        return choice1;
    }

    public String getChoice3(int cNum) {
        String choice3 = mChoices[cNum][2];
        return choice3;
    }
    public String getChoice4(int cNum) {
        String choice4 = mChoices[cNum][3];
        return choice4;
    }

    public String getCorrectAnswer(int aNum) {
        String answer = mCorrectAnswers[aNum];
        return answer;
    }



}

