package com.divij.srmpharmacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Images extends Fragment {
    @Nullable
    private Firebase mref;
    GridView gridView;
    public static List<String> allimages;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.images, container, false);
        gridView =  view.findViewById(R.id.gridview);
      allimages=new ArrayList<>();
        Firebase.setAndroidContext(getContext());
        mref=new Firebase("https://srm-pharmacy-a21dc.firebaseio.com/Users");


        ValueEventListener selectedListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                 String imagelink=  postSnapshot.child("Food to avoid picture").getValue(String.class) ;

                 allimages.add(imagelink);


                }


                gridView.setAdapter(new ImageAdapter(getContext(),allimages));
                // DatabaseReference databaseReference=fdata.getReference().child("Users").child("A");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };
        mref.addListenerForSingleValueEvent(selectedListener);

       return view;
    }
}
