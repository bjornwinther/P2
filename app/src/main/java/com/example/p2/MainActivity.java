package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView numberAttempts;
    private TextView forgotPass;
    private Button login;
    private Button signUp;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editUsername); // binding variables to the layout elements.
        password = (EditText) findViewById(R.id.editPassword);
        numberAttempts = (TextView) findViewById(R.id.tvAttempts);
        forgotPass = (TextView) findViewById(R.id.tvForgotPass);
        login = (Button) findViewById(R.id.btnLogin);
        signUp = (Button) findViewById(R.id.btnSignUp);

        numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(ForgotPass.class);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString()); // get input with getText() and convert to string toString()
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(SignUp.class);
            }
        });

    }

    private void validate(String username, String password) {
        if((username.equals("Vangede")) && (password.equals("Gudhjem"))){
            Intent intent = new Intent(MainActivity.this, Forum.class); // correct so it directs to the correct class (not Forum?)
            startActivity(intent);
        }else{
            counter--;
            numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));
            if(counter <= 0) {
                login.setEnabled(false); // Deactivates login-button.
            }
        }

    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(MainActivity.this, page);
        startActivity(intent);
    }



}
