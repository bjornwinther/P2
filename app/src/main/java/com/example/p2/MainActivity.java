package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView numberAttempts;
    private TextView forgotPass;
    private Button login;
    private Button signUp;
    private int counter = 5;
    private Boolean validated;

    static Account[] accounts = new Account[10];
    static int indexOfAcc = 0;
    static int maxAccounts = 10;
    static int uniqueAccID;


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

        validated = false;

        accounts[0] = new Account("", "admin@hotmail.com", "12345678", "", "", "SuperHuMAN", 22,
                "Iver", "Ottosen", "AAU", "Math", "6.Semester");

        numberAttempts.setVisibility(View.GONE);
        numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(ForgotPass.class);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {// maybe put in try-catch?
            @Override
            public void onClick(View v) {
                validateUser(username.getText().toString(), password.getText().toString()); // get input with getText() and convert to string toString() - temporary commented out

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(SignUp.class);
            }
        });

    }


    private void validateUser(String username, String password) { // maybe put in try-catch?
        try {


            for(int indexLoop = 0; indexLoop <= indexOfAcc; indexLoop ++) {
                if (username.equals(accounts[indexLoop].getUsername()) && password.equals(accounts[indexLoop].getConfirmPass())) {
                    uniqueAccID = indexLoop;
                    validated = true;
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Forum.class); // correct so it directs to the correct class (not Forum?)
                    startActivity(intent);

                }
            }
                if(!validated) { // fix else method - so it doesnt run every time:
                    Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                    counter--;
                    numberAttempts.setVisibility(View.VISIBLE);
                    numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));
                    // maybe add if counter < 3 - turn text red?
                    if (counter <= 0) {
                        login.setEnabled(false); // Deactivates login-button.
                    }
                }

        }catch(Exception e){
           System.out.println(e);
        }
    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(MainActivity.this, page);
        startActivity(intent);
    }


}
