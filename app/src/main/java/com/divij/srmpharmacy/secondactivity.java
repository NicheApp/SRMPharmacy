package com.divij.srmpharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class secondactivity extends AppCompatActivity {
    TextView Heading;
    TextView Name;
    TextView description;
    TextView time_taken;
    TextView interaction;
    TextView time;
    TextView describe;
    TextView interact;

    private Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        Heading = findViewById(R.id.Heading);
        Name=findViewById(R.id.Name);
        time_taken=findViewById(R.id.Time_Taken);
        interaction=findViewById(R.id.Interaction);
        description=findViewById(R.id.Description);
        time = findViewById(R.id.time);
        describe=findViewById(R.id.describe);
        interact=findViewById(R.id.interact);
        //Benefits=findViewById(R.id.Benefits);
        mref=new Firebase("https://srm-pharmacy-a21dc.firebaseio.com/Users");
//        imageView3 = findViewById(R.id.imageView3);
//        imageView4=findViewById(R.id.imageView4);
//        imageView5=findViewById(R.id.imageView5);
//        imageView6=findViewById(R.id.imageView6);

        final String selected =getIntent().getStringExtra("Listviewclickvalue");

        Name.setText(selected);
        ValueEventListener selectedListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //.setText(dataSnapshot.child(selected.toString()).child("Food_Avoided").getValue().toString());
                time_taken.setText(dataSnapshot.child(selected.toString()).child("When should take").getValue().toString());
                interaction.setText(dataSnapshot.child(selected.toString()).child("Interacting with").getValue().toString());
                description.setText(dataSnapshot.child(selected.toString()).child("Description of drug-food interaction effect").getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };
        mref.addListenerForSingleValueEvent(selectedListener);
    }
}