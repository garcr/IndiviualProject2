package com.example.rubyt.indiviualproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

     //   setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // method starts login
    public void logInOnClick(View view){
        //move current context (Main) to LoginActivity, itent is a mechanism to move from one activity to another
        //Create new intent, requires your current context (which is the MainActivity), and we want to move to new activity
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
    // method starts register
    public void registerOnClick(View view){
        //move current context (Main) to RegisterActivity
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }
}
