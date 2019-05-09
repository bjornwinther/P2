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

        numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));
        numberAttempts.setVisibility(View.GONE);

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePageTo(ForgotPass.class);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {// maybe put in try-catch?
            @Override
            public void onClick(View v) {
                if(indexOfAcc == 0) {
                    accounts[indexOfAcc] = new Account("", "admin@hotmail.com", "12345678", "", "", "SuperHuMAN", 22,
                            "Iver", "Ottosen", "AAU", "Math", "Complicated", "6.Semester");
                }
                // as long as both of the methods are called, it will always run at least ONE of the else-statements in one of the methods!
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
                    Intent intent = new Intent(MainActivity.this, Forum.class); // correct so it directs to the correct class (not Forum?)
                    startActivity(intent);
                    uniqueAccID = indexLoop;

                } else { // fix else method - so it doesnt run every time:
                    Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                    numberAttempts.setVisibility(View.VISIBLE);
                    counter--;
                    numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));
                    // maybe add if counter < 3 - turn text red?
                    if (counter <= 0) {
                        login.setEnabled(false); // Deactivates login-button.
                    }
                }
            }
        }catch(Exception e){
           System.out.println("validateUser-method went wrong");
        }
    }

    private void changePageTo(Class page) {
        Intent intent = new Intent(MainActivity.this, page);
        startActivity(intent);
    }


}
