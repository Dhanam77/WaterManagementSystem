package com.example.watermanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Reservoirs extends AppCompatActivity {

    private DatabaseReference Ref;
    private String waterLevelData;
    private Toolbar mToolbar;
    private TextView showData, waterlevelText, lowWaterWarning;
    private ProgressBar loadingBar;
    private String reservoirName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservoirs);

        InitializeFields();

        Ref.child("WaterLevel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (reservoirName.equals("a")) {
                    waterLevelData = dataSnapshot.child("ReservoirA").getValue().toString();
                }
                else if (reservoirName.equals("b")) {
                    waterLevelData = dataSnapshot.child("ReservoirB").getValue().toString();
                }
                else if (reservoirName.equals("c")) {
                    waterLevelData = dataSnapshot.child("ReservoirC").getValue().toString();
                }
                showData.setText(waterLevelData);
                loadingBar.setVisibility(View.INVISIBLE);

                if (Integer.parseInt(waterLevelData) < 100) {
                    blink();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Reservoirs.this, "Error", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void blink() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in milissegunds
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (lowWaterWarning.getVisibility() == View.VISIBLE) {
                            lowWaterWarning.setVisibility(View.INVISIBLE);
                        } else {
                            lowWaterWarning.setVisibility(View.VISIBLE);
                        }
                        blink();
                    }
                });
            }
        }).start();
    }


    private void InitializeFields() {

        //Setting the toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Reservoir Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        reservoirName = getIntent().getStringExtra("reservoirName");


        Ref = FirebaseDatabase.getInstance().getReference();

        showData = (TextView) findViewById(R.id.show_data);
        waterlevelText = (TextView) findViewById(R.id.waterlevel_text);
        lowWaterWarning = (TextView) findViewById(R.id.blink_warning);

        loadingBar = (ProgressBar) findViewById(R.id.load_water_level);

    }
}
