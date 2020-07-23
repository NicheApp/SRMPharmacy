package com.divij.srmpharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import static com.divij.srmpharmacy.secondactivity.link1;

public class Enlarge extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);
        final ImageView enlarge = findViewById(R.id.enlarge);
        //Intent intent = getIntent();
        //link1 =intent.getStringExtra("link1");


       // mref=new Firebase("https://srm-pharmacy-a21dc.firebaseio.com/Users");


       // link2=dataSnapshot.child(selected.toString()).child("Food to take picture").getValue().toString();
        Picasso.get().load(link1).into(enlarge);
    }
}