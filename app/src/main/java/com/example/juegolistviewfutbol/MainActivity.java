package com.example.juegolistviewfutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonRecycler;
    Button botonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonListView = findViewById(R.id.buttonListView);
        botonRecycler = findViewById(R.id.buttonRecycler);

    botonListView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), primeraLista.class);
            startActivity(i);
        }
    });

    botonRecycler.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), segundaLista.class);
            startActivity(i);
        }
    });
    }
}