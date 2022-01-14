package com.example.cevredostumapp;
//adem kalpakli
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cevredostumapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    Button joinEvent;
    Button returnHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Events event = getIntent().getParcelableExtra("event");
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        fts.add(R.id.container, DetailsFragment.newInstance(event));
        fts.commit();



        joinEvent = findViewById(R.id.joinButton);
        joinEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You joined this event!",Toast.LENGTH_LONG).show();
            }
        });

        returnHome = findViewById(R.id.returnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10 = new Intent(DetailsActivity.this, HomeActivity.class);
                startActivity(i10);
            }
        });

    }
}