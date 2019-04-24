package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    private TextView suInfo;
    private EditText username;
    private EditText email;
    private EditText phone;
    private EditText createPass;
    private EditText confirmPass;
    private Button createAcc;

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
                //What happends when Create-button is pressed
            }
        });

    }




}
