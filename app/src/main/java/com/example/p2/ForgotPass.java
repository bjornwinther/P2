package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPass extends AppCompatActivity {

    private TextView fpInfo;
    private EditText fpEmail;
    private Button fpSendNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        fpInfo = (TextView) findViewById(R.id.fpInfo);
        fpEmail = (EditText) findViewById(R.id.fpEmail);
        fpSendNew = (Button) findViewById(R.id.fpBtn);

        fpSendNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add a method to validate whether it is an actual email, and then give the toast as a response if it is. (look at validate method in MainActivity).
                Toast.makeText(getApplicationContext(),"Email with instructions sent", Toast.LENGTH_LONG).show();
            }
        });

    }


}
