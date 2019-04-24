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
    private Button login;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editUsername);
        password = (EditText) findViewById(R.id.editPassword);
        numberAttempts = (TextView) findViewById(R.id.tvAttempts);
        login = (Button) findViewById(R.id.btnLogin);

        numberAttempts.setText("No. of attempts remaining: " + String.valueOf(counter));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString()); // get input with getText() and convert to string toString()

            }
        });

    }

    private void validate(String username, String password) {
        if((username == "Vangede") && (password == "Gudhjem")){
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

}
