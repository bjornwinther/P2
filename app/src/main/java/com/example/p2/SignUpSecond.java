package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.p2.SignUp.accounts;
import static com.example.p2.SignUp.indexOfAcc;

public class SignUpSecond extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button createAccount;
    private EditText firstName;
    private EditText lastName;
    private EditText uni;
    private EditText major;
    private EditText status;
    private String selectedGender;
    private int selectedAge;
    private String selectedSemester;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_second);

        createAccount = (Button) findViewById(R.id.susCreatebtn);
        Spinner spinnerGender = findViewById(R.id.susSpinnerGender);
        Spinner spinnerAge = findViewById(R.id.susSpinnerAge);
        Spinner spinnerSemester = findViewById(R.id.susSpinnerSemester);
        firstName = findViewById(R.id.susFName);
        lastName = findViewById(R.id.susLName);
        uni = findViewById(R.id.susUni);
        major = findViewById(R.id.susMajor);
        status = findViewById(R.id.susStatus);

        spinnerGender.setOnItemSelectedListener(this);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerSemester.setOnItemSelectedListener(this);

        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Freak");

        List<Integer>  ageList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ageList.add(16+i);
        }

        List<String> semesterList = new ArrayList<>();
        for(int i = 1; i <= 8; i++) {
            semesterList.add(i + ". semester");
        }


        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderList);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);

        ArrayAdapter<Integer> ageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ageList);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(ageAdapter);

        ArrayAdapter<String> semesterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesterList);
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(semesterAdapter);

        createAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                accounts[indexOfAcc].setFirstName(firstName.getText().toString());
                accounts[indexOfAcc].setLastName(lastName.getText().toString());
                accounts[indexOfAcc].setUniveristy(uni.getText().toString());
                accounts[indexOfAcc].setMajor(major.getText().toString());
                accounts[indexOfAcc].setStatus(status.getText().toString());
                accounts[indexOfAcc].setGender(selectedGender);
                accounts[indexOfAcc].setAge(selectedAge);
                accounts[indexOfAcc].setSemester(selectedSemester);
                Toast.makeText(getApplicationContext(), "Account created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpSecond.this, MainActivity.class); // change to MainActivity. going to profile is temporary.
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.susSpinnerGender) {
            selectedGender = parent.getItemAtPosition(position).toString();
        }
        else if(parent.getId() == R.id.susSpinnerSemester) {
            selectedSemester = parent.getItemAtPosition(position).toString(); // move selectedSemester and selectedAge to other method paired with drop down menu.
        }else if(parent.getId() == R.id.susSpinnerAge) {
            selectedAge = (Integer) parent.getItemAtPosition(position); // Might cause a crash - Be aware.
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
