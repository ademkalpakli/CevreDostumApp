package com.example.cevredostumapp;
//author = adem kalpakli

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateEventActivity extends AppCompatActivity {
    EditText createName, createDesc,createDate,createTime,createlocaiton,createuserNum;
    Button createdEvent;
    Button homePage;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        createdEvent=findViewById(R.id.createdEvent);
        homePage=findViewById(R.id.homePage);
        createName = findViewById(R.id.createName);
        createDesc = findViewById(R.id.createDesc);
        createTime = findViewById(R.id.createTime);
        createDate = findViewById(R.id.createDate);
        createlocaiton = findViewById(R.id.createlocation);
        createuserNum = findViewById(R.id.createuserNum);

        db=FirebaseFirestore.getInstance();

        createdEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = createName.getText().toString().trim();
                String description = createDesc.getText().toString().trim();
                String time = createTime.getText().toString().trim();
                String date = createDate.getText().toString().trim();
                String location = createlocaiton.getText().toString().trim();
                String usernum = createuserNum.getText().toString().trim();

                CollectionReference dbEvents = db.collection("Events");

                Events event = new Events(name,description,date,Double.parseDouble(time),location,Integer.parseInt(usernum));
                dbEvents.add(event)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(@NonNull DocumentReference documentReference) {
                        Toast.makeText(CreateEventActivity.this,"Event Created",Toast.LENGTH_LONG).show();
                    }
                })
                  .addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Toast.makeText(CreateEventActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                      }
                  });


            }
        });

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(CreateEventActivity.this,HomeActivity.class);
                startActivity(i2);
            }
        });

    }
}