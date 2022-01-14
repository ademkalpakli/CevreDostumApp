package com.example.cevredostumapp;
//adem kalpakli
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    UserInformations user;
    EditText name,surname,birthday,age,education;
    EditText gmail, password;
    FirebaseAuth auth;
    FirebaseUser member;
    Button btnNewReg, btnCancel;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        gmail = findViewById(R.id.gmail);
        password = findViewById(R.id.password);
        btnCancel = findViewById(R.id.btncancel);
        name =  findViewById(R.id.inputName);
        surname = findViewById(R.id.inputSurname);
        birthday = findViewById(R.id.inputBirthday);
        age = findViewById(R.id.inputAge);
        education = findViewById(R.id.inputEdu);
        firebaseDatabase = FirebaseDatabase.getInstance();
        user= new UserInformations();
        reference = firebaseDatabase.getReference().child("Members");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i17= new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i17);
            }
        });
        btnNewReg = findViewById(R.id.btnnewReg);
        auth = FirebaseAuth.getInstance();
        btnNewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = gmail.getText().toString();
                String pwd = password.getText().toString();
                String membername = name.getText().toString();
                String membersurname = surname.getText().toString();
                String memberage = age.getText().toString();
                String memberbirthday = birthday.getText().toString();
                String edu = education.getText().toString();


                user.setName(membername);
                user.setSurname(membersurname);
                user.setBirthday(memberbirthday);
                user.setAge(memberage);
                user.setEducation(edu);
                reference.push().setValue(user);

                if (!uname.equals("") && !pwd.equals("")) {
                    register(uname,pwd);
                    gmail.setText("");
                    password.setText("");
                }


            }
        });


    }


    private void register(String usn, String pass) {
        auth.createUserWithEmailAndPassword(usn, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    auth = FirebaseAuth.getInstance();
                    member = auth.getCurrentUser();
                    reference = firebaseDatabase.getReference().child("Members").child(member.getUid());



                    Toast.makeText(getApplicationContext(), "Registration is successful, returning to the main screen.", Toast.LENGTH_LONG).show();


                } else {

                    Toast.makeText(getApplicationContext(), "An error has occurred. Please check that you have entered the correct information.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}