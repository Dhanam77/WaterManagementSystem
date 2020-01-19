package com.example.watermanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Reservoirs extends AppCompatActivity {

    private DatabaseReference Ref;
    private String waterLevelData, reservoirCapacity, reservoirDemand, name;
    private Toolbar mToolbar;
    private TextView showData, waterlevelText, lowWaterWarning, capacity, demand, showName, requiredWater, extraWater1, extraWater2;
    private ProgressBar loadingBar;
    private RelativeLayout connectedData;
    private String reservoirName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservoirs);

        InitializeFields();

        Ref.child("Reservoirs").child("IndividualReservoirs").child("Mumbai").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (reservoirName.equals("a")) {
                    waterLevelData = dataSnapshot.child("ReservoirA").child("Level").getValue().toString();
                    reservoirCapacity = dataSnapshot.child("ReservoirA").child("Capacity").getValue().toString();
                    reservoirDemand = dataSnapshot.child("ReservoirA").child("Demand").getValue().toString();
                    name = dataSnapshot.child("ReservoirA").child("Name").getValue().toString();

                }
                else if (reservoirName.equals("b")) {
                    waterLevelData = dataSnapshot.child("ReservoirB").child("Level").getValue().toString();
                    reservoirCapacity = dataSnapshot.child("ReservoirB").child("Capacity").getValue().toString();
                    reservoirDemand = dataSnapshot.child("ReservoirB").child("Demand").getValue().toString();
                    name = dataSnapshot.child("ReservoirB").child("Name").getValue().toString();
                }
                else if (reservoirName.equals("c")) {
                    waterLevelData = dataSnapshot.child("ReservoirC").child("Level").getValue().toString();
                    reservoirCapacity = dataSnapshot.child("ReservoirC").child("Capacity").getValue().toString();
                    reservoirDemand = dataSnapshot.child("ReservoirC").child("Demand").getValue().toString();
                    name = dataSnapshot.child("ReservoirC").child("Name").getValue().toString();
                }
                else if (reservoirName.equals("connected_reservoir_a")) {
                    waterLevelData = dataSnapshot.child("ReservoirA").child("Level").getValue().toString();
                    reservoirCapacity = dataSnapshot.child("ReservoirA").child("Capacity").getValue().toString();
                    reservoirDemand = dataSnapshot.child("ReservoirA").child("Demand").getValue().toString();
                    name = dataSnapshot.child("ReservoirA").child("Name").getValue().toString();
                    connectedData.setVisibility(View.VISIBLE);


                    if (Integer.parseInt(waterLevelData) < Integer.parseInt(reservoirDemand)) {

                        int reqd = Integer.parseInt(reservoirDemand) - Integer.parseInt(waterLevelData);
                        requiredWater.setText("Water required is " + reqd + " mm");
                        String waterLevelDataC = dataSnapshot.child("ReservoirC").child("Level").getValue().toString();
                        String waterLevelDataB = dataSnapshot.child("ReservoirB").child("Level").getValue().toString();
                        String demandC = dataSnapshot.child("ReservoirC").child("Demand").getValue().toString();
                        String demandB = dataSnapshot.child("ReservoirB").child("Demand").getValue().toString();

                        if(Integer.parseInt(waterLevelDataC) > Integer.parseInt(demandC))
                        {
                            int extra = Integer.parseInt(waterLevelDataC) - Integer.parseInt(demandC);
                            extraWater1.setText("Extra Amount of " + extra + " mm water is available in Reservoir C");
                        }

                        if(Integer.parseInt(waterLevelDataB) > Integer.parseInt(demandB))
                        {
                            int extra = Integer.parseInt(waterLevelDataB) - Integer.parseInt(demandB);
                            extraWater1.setText("Extra Amount of " + extra + " mm water is available in Reservoir B");
                        }



                    }
                    else
                    {
                        int reqd = Integer.parseInt(waterLevelData) - Integer.parseInt(reservoirDemand);

                        requiredWater.setText("Capable to transfer " + reqd + "mm of water");
                    }

                }
                else if (reservoirName.equals("connected_reservoir_b")) {
                    waterLevelData = dataSnapshot.child("ReservoirB").child("Level").getValue().toString();
                    reservoirCapacity = dataSnapshot.child("ReservoirB").child("Capacity").getValue().toString();
                    reservoirDemand = dataSnapshot.child("ReservoirB").child("Demand").getValue().toString();
                    name = dataSnapshot.child("ReservoirB").child("Name").getValue().toString();

                    connectedData.setVisibility(View.VISIBLE);


                    if (Integer.parseInt(waterLevelData) < Integer.parseInt(reservoirDemand)) {

                        int reqd = Integer.parseInt(reservoirDemand) - Integer.parseInt(waterLevelData);
                        requiredWater.setText("Water required is " + reqd + " mm");
                        String waterLevelDataC = dataSnapshot.child("ReservoirC").child("Level").getValue().toString();
                        String waterLevelDataA = dataSnapshot.child("ReservoirA").child("Level").getValue().toString();
                        String demandC = dataSnapshot.child("ReservoirC").child("Demand").getValue().toString();
                        String demandA = dataSnapshot.child("ReservoirA").child("Demand").getValue().toString();

                        if(Integer.parseInt(waterLevelDataC) > Integer.parseInt(demandC))
                        {
                            int extra = Integer.parseInt(waterLevelDataC) - Integer.parseInt(demandC);
                            extraWater1.setText("Extra Amount of " + extra + " mm water is available in Reservoir C");
                        }

                        if(Integer.parseInt(waterLevelDataA) > Integer.parseInt(demandA))
                        {
                            int extra = Integer.parseInt(waterLevelDataA) - Integer.parseInt(demandA);
                            extraWater1.setText("Extra Amount of " + extra + " mm water is available in Reservoir A");
                        }



                    }

                    else
                    {
                        int reqd = Integer.parseInt(waterLevelData) - Integer.parseInt(reservoirDemand);

                        requiredWater.setText("Capable to transfer " + reqd + "mm of water");
                    }
                }
                else if (reservoirName.equals("connected_reservoir_c")) {
                    waterLevelData = dataSnapshot.child("ReservoirC").child("Level").getValue().toString();
                    reservoirCapacity = dataSnapshot.child("ReservoirC").child("Capacity").getValue().toString();
                    reservoirDemand = dataSnapshot.child("ReservoirC").child("Demand").getValue().toString();
                    name = dataSnapshot.child("ReservoirC").child("Name").getValue().toString();

                    connectedData.setVisibility(View.VISIBLE);


                    if (Integer.parseInt(waterLevelData) < Integer.parseInt(reservoirDemand)) {

                        int reqd = Integer.parseInt(reservoirDemand) - Integer.parseInt(waterLevelData);
                        requiredWater.setText("Water required is " + reqd + " mm");
                        String waterLevelDataA = dataSnapshot.child("ReservoirA").child("Level").getValue().toString();
                        String waterLevelDataB = dataSnapshot.child("ReservoirB").child("Level").getValue().toString();
                        String demandA = dataSnapshot.child("ReservoirA").child("Demand").getValue().toString();
                        String demandB = dataSnapshot.child("ReservoirB").child("Demand").getValue().toString();

                        if(Integer.parseInt(waterLevelDataA) > Integer.parseInt(demandA))
                        {
                            int extra = Integer.parseInt(waterLevelDataA) - Integer.parseInt(demandA);
                            extraWater1.setText("Extra Amount of " + extra + " mm water is available in Reservoir A");
                        }

                        if(Integer.parseInt(waterLevelDataB) > Integer.parseInt(demandB))
                        {
                            int extra = Integer.parseInt(waterLevelDataB) - Integer.parseInt(demandB);
                            extraWater1.setText("Extra Amount of " + extra + " mm water is available in Reservoir B");
                        }



                    }
                    else
                    {
                        int reqd = Integer.parseInt(waterLevelData) - Integer.parseInt(reservoirDemand);

                        requiredWater.setText("Capable to transfer " + reqd + "mm of water");
                    }


                }
                showData.setText(waterLevelData);
                showName.setText(name);
                capacity.setText(reservoirCapacity);
                demand.setText(reservoirDemand);

                loadingBar.setVisibility(View.INVISIBLE);

                if (Integer.parseInt(waterLevelData) < Integer.parseInt(reservoirDemand)) {
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
                int timeToBlink = 500;    //in milliseconds
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

        requiredWater = (TextView)findViewById(R.id.required_water);
        extraWater1 = (TextView)findViewById(R.id.extra_reservoir_1);
        extraWater2 = (TextView)findViewById(R.id.extra_reservoir_2);
        Ref = FirebaseDatabase.getInstance().getReference();

        showData = (TextView) findViewById(R.id.show_data);
        capacity = (TextView) findViewById(R.id.show_capacity);
        demand = (TextView) findViewById(R.id.show_demand);
        showName = (TextView) findViewById(R.id.show_name);
        waterlevelText = (TextView) findViewById(R.id.waterlevel_text);
        lowWaterWarning = (TextView) findViewById(R.id.blink_warning);
        connectedData = (RelativeLayout)findViewById(R.id.connected_data);
        loadingBar = (ProgressBar) findViewById(R.id.load_water_level);

    }
}
