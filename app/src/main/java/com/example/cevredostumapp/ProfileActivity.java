package com.example.cevredostumapp;
//ademkalpakli and gizem ozgen
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Member;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser user;
    CircleImageView image;
    DatabaseReference reference;
    TextView name,surname,birthday,age,education,txtviewData;
    Button btnPhome,btnChangePic, btnLout;
    ImageView profilePic;
    FirebaseFirestore db;
    DocumentReference documentReference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //db=FirebaseFirestore.getInstance();
        //loadEvent();

           /* define();
            getInfo();
        profilePic = findViewById(R.id.profile_image);

        btnPhome = findViewById(R.id.btnPHome);
        btnPhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(i1);
            }
        });

        btnChangePic = findViewById(R.id.btnChangeProfilePic);
        btnChangePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);
            }
        });
       txtviewData = findViewById(R.id.txtViewData);
       */ btnLout = findViewById(R.id.btnLogOut);
        btnLout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(i2);
            }
        });



/*
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String a=snapshot.child("Members").child("name").getValue().toString();
                    name.setText(a);

                    String b=snapshot.child("Members").child("surname").getValue().toString();
                    surname.setText(b);

                    String c=snapshot.child("Members").child("birthday").getValue().toString();
                    birthday.setText(c);

                    String d=snapshot.child("Members").child("age").getValue().toString();
                    age.setText(d);

                    String f=snapshot.child("Members").child("education").getValue().toString();
                    education.setText(f);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            }); */


        btnPhome = findViewById(R.id.btnPHome);
        btnPhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5= new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(i5);
            }
        });
    }
   /* public void loadEvent(){
        documentReference = db.collection("Events").document("name");

        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(@NonNull DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            txtviewData.setText(documentSnapshot.getString("name"));

                        }else {
                            Toast.makeText(ProfileActivity.this,"Document does note exist",Toast.LENGTH_SHORT);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });



    }
    //to set the image for profile pic
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                profilePic.setImageURI(imageUri);
            }
        }
    }

    public void define(){
        name = findViewById(R.id.txtPName);
        surname = findViewById(R.id.txtPSurname);
        age = findViewById(R.id.txtPAge);
        birthday = findViewById(R.id.txtPBirthday);
        education = findViewById(R.id.txtPEdu);
        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Members").child(user.getUid());
        Log.d("log",user.getUid()+ "");


    }

    public void getInfo(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserInformations Users = snapshot.getValue(UserInformations.class);
                name.setText(Users.getName());
                surname.setText(Users.getSurname());
                age.setText(Users.getAge());
                birthday.setText(Users.getBirthday());
                education.setText(Users.getEducation());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }*/
}

