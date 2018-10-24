package com.example.rubyt.indiviualproject2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    EditText passW;
    EditText email;
    TextView txtLabel;
    String emailC;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.editTextEmail);
        passW = (EditText)findViewById(R.id.editTextPass);
        txtLabel = (TextView)findViewById(R.id.textViewLogin);
        SharedPreferences usrerInfo = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        emailC = usrerInfo.getString("email", DEFAULT);
        password = usrerInfo.getString("password", DEFAULT);
    }


    public boolean validateLogin(){
        // validate email input and password with
        if(email.getText().toString().equals(emailC) && password.equals(passW.getText().toString()))
            return true;
        else
            return false;
        }
        // call validateLogin() to determine if login is successful or not
    public void onClickLogIn(View view){
        if(validateLogin()) {
            Toast.makeText(this, "Logging in", Toast.LENGTH_LONG).show();
            startActivity(new Intent(LoginActivity.this, QuizActivity.class));
        }else {
            txtLabel.setText(getString(R.string.error_login) + emailC);
            txtLabel.setBackgroundColor(Color.RED);
        }
    }


}
