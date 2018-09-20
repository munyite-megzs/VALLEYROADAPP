package com.example.msitati.valleyroadapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

     Button btnAdd;
     EditText editTextname;
     Spinner gnd;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtists = database.getInstance().getReference("artists");

        editTextname= (EditText) findViewById(R.id.editText);
        gnd = (Spinner) findViewById(R.id.spinner2);
        btnAdd = (Button) findViewById((R.id.button2));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addList();

            }
        });

    }
    private void addList(){
        String name = editTextname.toString().trim();
        String gend = gnd.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name)){

            //create a unique id for our artists. stored inside id
            String id= databaseArtists.push().getKey();
            Artist artist = new Artist(id,name,gend);
            databaseArtists.child(id).setValue(artist);
            Toast.makeText(this,"Toast Added",Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this,"You should enter a name!!",Toast.LENGTH_LONG).show();
        }
    }


    }

