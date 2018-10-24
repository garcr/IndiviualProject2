package com.example.rubyt.indiviualproject2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText eTxtFname,eTxtLname, eTxtmonth, eTxtday, eTxtyear, eTxtEmail, eTxtPassword;
    TextView txtPass;
    String password = "test";
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // set EditText and other view variables to the id of their appropriate view
        eTxtFname = (EditText)findViewById(R.id.edit_Fname);
        eTxtLname = (EditText)findViewById(R.id.edit_Lname);
        eTxtyear = (EditText)findViewById(R.id.eTxt_year);
        eTxtmonth = (EditText)findViewById(R.id.eTxt_month);
        eTxtday = (EditText)findViewById(R.id.eTxt_day);
        eTxtEmail=(EditText)findViewById(R.id.eTxtEmail);
        eTxtPassword = (EditText)findViewById(R.id.eTxtPass);
        btnCreate = (Button)findViewById(R.id.btn_CR);
        txtPass = (TextView)findViewById(R.id.txtPass);

    }
    // Validate EditText string for a name, must not be empty and greater than 2 characters
    public boolean validateName(EditText name){
            if (TextUtils.isEmpty(name.getText().toString())) {
                name.setError(getString(R.string.error_empty));
                return false;
            } else if (name.getText().toString().length() < 3) {
                name.setError(getString(R.string.error_shortfield));
                return false;
            } else
                return true;

    }
    //Validate EditText month is not empty and between 1 - 12
    public boolean validateMonth(){
        if(TextUtils.isEmpty(eTxtmonth.getText().toString())) {
            eTxtmonth.setError(getString(R.string.error_empty));
            return  false;
        }
        else if(Integer.parseInt(eTxtmonth.getText().toString()) > 12 || Integer.parseInt(eTxtmonth.getText().toString()) < 1){
            eTxtmonth.setError("Month must be between 01 and 12");
            return false;
        }
        else
            return true;

    }
    //Validate Edit day is between 1 - 32 and not empty
    public boolean validateDay(){

        if(TextUtils.isEmpty(eTxtday.getText().toString())) {
            eTxtday.setError(getString(R.string.error_empty));
             return false;
        }
        else if(Integer.parseInt(eTxtday.getText().toString()) > 32 || Integer.parseInt(eTxtday.getText().toString()) < 1) {
            eTxtday.setError("Month must be between 1 and 32");
            return false;
        }
        else return true;

    }
    //Validate year is between 1918 - 2010, and must not be empty
    public boolean validateYear(){
        if(TextUtils.isEmpty(eTxtyear.getText().toString())) {
            eTxtyear.setError(getString(R.string.error_empty));
            return false;
        }
        else if(Integer.parseInt(eTxtyear.getText().toString()) > 2010 || Integer.parseInt(eTxtyear.getText().toString()) < 1918) {
            eTxtmonth.setError("Year must be between 2010 and 1918");
            return false;
        }
        else
            return true;
    }
    // Use util.PAtters.Email_Adress validate string matches the pattern regex,
    // Email_Address - Regular expression pattern to match email addresses.
    public boolean validateEmail(){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(eTxtEmail.getText().toString()).matches()) {
            return true;
        }else{
            eTxtEmail.setError(getString(R.string.error_email));
            return false;
        }
    }
    // Validate password is not empty and greater than 4 characters
    public boolean validatePassword(){
        if(TextUtils.isEmpty(eTxtPassword.getText().toString())) {
            eTxtPassword.setError(getString(R.string.error_empty));
            return false;
        }
        else if(eTxtPassword.getText().toString().length() < 5) {
            eTxtPassword.setError(getString(R.string.error_short_password));
            return false;
        }
        else
            return true;
    }
    //Start new Intents to
    public void saveUser(){
       /* Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
        Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
        String pass = eTxtPassword.getText().toString();
        String email = eTxtEmail.getText().toString();
        //add string into the Intent objects, with email and password input, password and email are used as keys
        intent1.putExtra("password", eTxtPassword.getText().toString());
        intent2.putExtra("email", eTxtEmail.getText().toString());
        startActivity(intent1);
        startActivity(intent2);
        //Start a new activity and start the LoginActivity to move to Login page
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        */
        SharedPreferences shareInfo = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shareInfo.edit();
        editor.putString("email", eTxtEmail.getText().toString());
        editor.putString("password", eTxtPassword.getText().toString());
        Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
        editor.commit();

    }
    public void onClickCreate(View view) {
        //if any validation methods called are not true, then set error, else call startLog method to move into login page with credentials
        if (!validateName(eTxtFname) || !validateName(eTxtLname) || !validateMonth() || !validateDay() || !validateYear() || !validateEmail() || !validatePassword())
            btnCreate.setError(getString(R.string.error_form));
        else {
            saveUser();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }

    }
}
