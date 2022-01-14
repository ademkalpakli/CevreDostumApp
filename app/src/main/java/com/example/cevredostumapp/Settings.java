package com.example.cevredostumapp;
//gizemozgen
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    Button saveSettings;
    Button rtnHome;
    Button imgCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        define();
        call();


        rtnHome = findViewById(R.id.rtnHome);
        rtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7= new Intent(Settings.this,HomeActivity.class);
                startActivity(i7);
            }
        });

        saveSettings= findViewById(R.id.savesettings);
        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Settings saved!",Toast.LENGTH_LONG).show();


            }
        });
    }


    public void define(){


        imgCall = findViewById(R.id.imgCall);


    }
    public void call(){
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_DIAL);
                String num= "05312667520";
                intent.setData(Uri.parse("tel:"+num));
                startActivity(intent);
            }
        });

    }
}