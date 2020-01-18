package com.example.watermanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MumbaiIndividualReservoirs extends AppCompatActivity {

    private Button ReservoirAButton, ReservoirBButton, ReservoirCButton;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai_individual_reservoirs);

       InitializeFields();

       ReservoirAButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MumbaiIndividualReservoirs.this, Reservoirs.class);
               intent.putExtra("reservoirName", "a");
               startActivity(intent);
           }
       });

        ReservoirBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MumbaiIndividualReservoirs.this, Reservoirs.class);
                intent.putExtra("reservoirName", "b");
                startActivity(intent);
            }
        });

        ReservoirCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MumbaiIndividualReservoirs.this, Reservoirs.class);
                intent.putExtra("reservoirName", "c");
                startActivity(intent);
            }
        });

    }



    private void InitializeFields() {

        //Setting the toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Reservoir A");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ReservoirAButton = (Button) findViewById(R.id.reservoir_a);
        ReservoirBButton = (Button) findViewById(R.id.reservoir_b);
        ReservoirCButton = (Button) findViewById(R.id.reservoir_c);


    }

}
