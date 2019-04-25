package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    Account[] accounts = new Account[25];
    private int index = 0;
    private int maxAccounts = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        suInfo = (TextView) findViewById(R.id.suText);
        username = (EditText) findViewById(R.id.suUsername);
        email = (EditText) findViewById(R.id.suEmail);
        phone = (EditText) findViewById(R.id.suPhoneNo);
        createPass = (EditText) findViewById(R.id.suCreatePass);
        confirmPass = (EditText) findViewById(R.id.suConfirmPass);
        createAcc = (Button) findViewById(R.id.subtnCreate);


        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!createPass.getText().toString().equals(confirmPass.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Created Password must match Confirmed Password", Toast.LENGTH_SHORT).show();
                }else{
                    accounts[index] = new Account(username.getText().toString(), email.getText().toString(),
                            phone.getText().toString(), createPass.getText().toString(), confirmPass.getText().toString());
                    index++;
                    Toast.makeText(getApplicationContext(),"Account created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }




}
