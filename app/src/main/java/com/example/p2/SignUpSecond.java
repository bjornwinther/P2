package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.p2.SignUp.accounts;
import static com.example.p2.SignUp.indexOfAcc;

public class SignUpSecond extends AppCompatActivity {

    private Button createAccount;
    private EditText firstName;
    private EditText lastName;
    private EditText uni;
    private Spinner spinnerSemester;
    private EditText major;
    private EditText status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_second);

        createAccount = (Button) findViewById(R.id.susCreatebtn);
        Spinner spinnerGender = findViewById(R.id.susSpinnerGender);
        Spinner spinnerAge = findViewById(R.id.susSpinnerAge);
        firstName = findViewById(R.id.susFName);
        lastName = findViewById(R.id.susLName);
        uni = findViewById(R.id.susUni);
        spinnerSemester = findViewById(R.id.susSpinnerSemester);
        major = findViewById(R.id.susMajor);
        status = findViewById(R.id.susStatus);


        List<String> genderArray = new ArrayList<>();
        genderArray.add("Male");
        genderArray.add("Female");
        genderArray.add("Freak");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genderArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        createAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                accounts[indexOfAcc].setFirstName(firstName.getText().toString());
                accounts[indexOfAcc].setLastName(lastName.getText().toString());
                accounts[indexOfAcc].setUniveristy(uni.getText().toString());
                accounts[indexOfAcc].setMajor(major.getText().toString());
                accounts[indexOfAcc].setStatus(status.getText().toString());
                Toast.makeText(getApplicationContext(), "Account created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpSecond.this, MainActivity.class); // change to MainActivity. going to profile is temporary.
                startActivity(intent);
            }
        });

    }
}
