package com.divij.srmpharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static com.divij.srmpharmacy.secondactivity.link1;
import static com.divij.srmpharmacy.secondactivity.link2;

public class Enlarge2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge2);
        final ImageView enlarge2 = findViewById(R.id.enlarge2);
        //Intent intent = getIntent();
        //link1 =intent.getStringExtra("link1");


        // mref=new Firebase("https://srm-pharmacy-a21dc.firebaseio.com/Users");


        // link2=dataSnapshot.child(selected.toString()).child("Food to take picture").getValue().toString();
        Picasso.get().load(link2).into(enlarge2);
    }
}