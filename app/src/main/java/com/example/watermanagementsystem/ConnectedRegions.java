package com.example.watermanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConnectedRegions extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button rajasthanButton, mumbaiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected_regions);

        Initialize();

        rajasthanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConnectedRegions.this, ConnectedReservoirs.class));
            }
        });
        mumbaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConnectedRegions.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Initialize() {
        //Setting the toolbar
        mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Connected Reservoirs");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rajasthanButton = (Button)findViewById(R.id.rajasthan_region);
        mumbaiButton = (Button)findViewById(R.id.mumbai_region);

    }
}
