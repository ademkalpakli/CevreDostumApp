package com.example.cevredostumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
//gizemozgen

public class HomeActivity extends AppCompatActivity implements EventFragment.OnEventSelected{
    Button createEvent;    Button buttonProfile;
    Button btnSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        createEvent = findViewById(R.id.btnCreateEvent);
        buttonProfile = findViewById(R.id.buttonProfile);
        btnSettings=findViewById(R.id.buttonSettings);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i9= new Intent(HomeActivity.this, Settings.class);
                startActivity(i9);

            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this, CreateEventActivity.class);
                startActivity(i);
            }
        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4= new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(i4);
            }
        });


    }


    @Override
    public void eventSelected(Events event) {
        Log.d("Home Activity" , event.getName());

        Intent i11 = new Intent(HomeActivity.this, DetailsActivity.class);
        i11.putExtra("event",event);
        startActivity(i11);
    }
}