package com.example.watermanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConnectedReservoirs extends AppCompatActivity {
    private Toolbar mToolbar;
    private Button reservoirA, reservoirB, reservoirC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected_reservoirs);

        Initialize();

        reservoirA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectedReservoirs.this, Reservoirs.class);
                intent.putExtra("reservoirName", "connected_reservoir_a");
                startActivity(intent);
            }
        });
        reservoirB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectedReservoirs.this, Reservoirs.class);
                intent.putExtra("reservoirName", "connected_reservoir_b");
                startActivity(intent);

            }
        });
        reservoirC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectedReservoirs.this, Reservoirs.class);
                intent.putExtra("reservoirName", "connected_reservoir_c");
                startActivity(intent);

            }
        });



    }

    private void Initialize() {
        //Setting the toolbar
        mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Rajasthan Reservoirs");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reservoirA = (Button) findViewById(R.id.connected_reservoir_a);
        reservoirB = (Button) findViewById(R.id.connected_reservoir_b);
        reservoirC = (Button) findViewById(R.id.connected_reservoir_c);

    }
}
