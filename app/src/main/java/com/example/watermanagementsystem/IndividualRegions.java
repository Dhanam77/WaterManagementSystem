package com.example.watermanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IndividualRegions extends AppCompatActivity {

    private Button mumbaiRegion, rajasthanRegion;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_regions);

        Initialize();

        mumbaiRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndividualRegions.this, MumbaiIndividualReservoirs.class);

                startActivity(intent);
            }
        });

        rajasthanRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IndividualRegions.this,"Coming Soon!", Toast.LENGTH_LONG).show();

            }
        });


    }

    private void Initialize() {
        //Setting the toolbar
        mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Individual Reservoirs");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mumbaiRegion = (Button) findViewById(R.id.mumbai_region);
        rajasthanRegion = (Button) findViewById(R.id.rajasthan_region);
    }
}
