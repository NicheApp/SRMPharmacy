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
    TextView description , Benefits;
    ImageView imageView3 , imageView4,imageView5,imageView6;
    private Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        Heading = findViewById(R.id.Heading);
        Name=findViewById(R.id.Name);
        description=findViewById(R.id.Description);
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
                description.setText(dataSnapshot.child(selected.toString()).child("Food_Avoided").getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };
        mref.addListenerForSingleValueEvent(selectedListener);
    }
}
