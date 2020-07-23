package com.divij.srmpharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


import java.util.ArrayList;

import static com.firebase.client.Firebase.*;

public class MainActivity extends AppCompatActivity {

    private SearchView mySearchView;
    private Firebase mref;
    private ListView mListView;
    private ArrayList<String> mUsernames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        mySearchView = (SearchView) findViewById(R.id.searchView);
        mref = new Firebase("https://srm-pharmacy-a21dc.firebaseio.com/Users");
        mListView = (ListView) findViewById(R.id.listview);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                mUsernames);
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = mUsernames.get(i).toString();
                Context context=getApplicationContext();
                CharSequence text = "Based on available sources this app provides about \"When should take a drug, food to take & avoid with your medicine\". The Clinical relevance of the same should be confirmed with your practitioner.";
                int duration= Toast.LENGTH_LONG;
                Toast toast=Toast.makeText(context,text,duration);
                toast.show();
                Intent intent = new Intent(MainActivity.this, secondactivity.class).putExtra("Listviewclickvalue",
                        selected);
                Log.e("Clicked:", "" + selected);
                startActivity(intent);
            }
        });

        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                final String value = dataSnapshot.getKey();

                mUsernames.add(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_navigation_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.navigation_reference:
                Intent intent = new Intent(MainActivity.this,Reference.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}