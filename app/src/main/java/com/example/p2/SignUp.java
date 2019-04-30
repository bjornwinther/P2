package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private TextView suInfo;
    private EditText username;
    private EditText email;
    private EditText phone;
    private EditText createPass;
    private EditText confirmPass;
    private Button createAcc;
    private TextView suWarningUsername;
    private TextView suWarningEmail;

    static Account[] accounts = new Account[10];
    static int indexOfAcc = 0;
    private int maxAccounts = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        suWarningUsername = (TextView) findViewById(R.id.suWarningUsername);
        suInfo = (TextView) findViewById(R.id.suText);
        username = (EditText) findViewById(R.id.suUsername);
        email = (EditText) findViewById(R.id.suEmail);
        phone = (EditText) findViewById(R.id.suPhoneNo);
        createPass = (EditText) findViewById(R.id.suCreatePass);
        confirmPass = (EditText) findViewById(R.id.suConfirmPass);
        createAcc = (Button) findViewById(R.id.subtnCreate);
        suWarningEmail = (TextView) findViewById(R.id.suWarningEmail);

        suWarningUsername.setText("Ostemad");
        suWarningUsername.setVisibility(View.GONE);
        suWarningEmail.setVisibility(View.GONE);



        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put all the following in a method instead perhaps?: and consider putting in try-catch?
                try{
                if(indexOfAcc == maxAccounts){
                    Toast.makeText(getApplicationContext(),"Maximum number of accounts reached", Toast.LENGTH_SHORT).show();
                }else if(username.getText().toString().length() < 4){
                    suWarningUsername.setTextColor(Color.RED);
                    suWarningUsername.setText("Must be 4 chars long");
                    suWarningUsername.setVisibility(View.VISIBLE);
                }else if (!email.getText().toString().endsWith("@hotmail.com") || email.getText().toString().endsWith("@student.aau.dk")){ //after || doesn't work
                    suWarningUsername.setVisibility(View.GONE);
                    suWarningEmail.setTextColor(Color.RED);
                    suWarningEmail.setText("Email entered not valid");
                    suWarningEmail.setVisibility(View.VISIBLE);
                }
                else if(!createPass.getText().toString().equals(confirmPass.getText().toString())) {
                    suWarningEmail.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Created Password must match Confirmed Password", Toast.LENGTH_SHORT).show();
                }else {
                    suWarningEmail.setVisibility(View.GONE);
                    suWarningUsername.setVisibility(View.GONE);
                    indexOfAcc++;
                    accounts[indexOfAcc] = new Account(username.getText().toString(), email.getText().toString(),
                            phone.getText().toString(), createPass.getText().toString(), confirmPass.getText().toString());
                    Intent intent = new Intent(SignUp.this, SignUpSecond.class);
                    startActivity(intent);
                }
                } catch(Exception e){
                    System.out.println("SignUp onclick Failed.");
                    }

            }
        });

    }


    //the following methods needs to replace the code in the create.acc on click:
    public boolean checkPassword(String createPass, String confirmPass){
        if(createPass.equals(confirmPass)){
            return true;
        }
        return false;
    }

    /*public void displayWarning() {
        suWarningUsername.setTextColor(Color.RED);
        suWarningUsername.setVisibility(View.VISIBLE);

    }*/


    //create general method that can check different things with different parameters or do overriding.
    // consider whether it is necassary to do the methods, since they will only be used once, and ultimately just be more code.



}
