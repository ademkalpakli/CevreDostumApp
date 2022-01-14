package com.example.cevredostumapp;
//ademkalpakli and gizem ozgen
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

public class MainActivity extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth auth;

    EditText username, password;
    Button btnLogin;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        username = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.editLoginBtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gmailText =username.getText().toString();
                username.setText("");
                String passwordText =password.getText().toString();
                password.setText("");
                if(!gmailText.equals("") && !passwordText.equals("")){
                    loginUser(gmailText,passwordText);
                }
            }
        });


        if (user == null)

            registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i15 = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i15);
            }
        });


    }

    private void loginUser(String userGmail, String userPass) {
        auth.signInWithEmailAndPassword(userGmail, userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                    Intent i18 = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i18);

                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect user, please make sure you entered it correctly.", Toast.LENGTH_LONG).show();


                }
            }
        });

    }


}