package com.example.juegolistviewfutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class primeraLista extends AppCompatActivity {
    ListView listajugadores;
    ListAdapter adapter;
    public static String jugadorElegido;
    public static String[] jugadores= {"Mbappe", "Messi", "Benzemá!", "Cristiano!", "Luka Modric!"};
     public static int [] fotos = {
            R.drawable.mbappe,
            R.drawable.messi,
            R.drawable.karim,
            R.drawable.cristiano,
            R.drawable.luka
    };
     int [] puntuacion = {0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_lista);

        listajugadores = findViewById(R.id.listViewJugadores);

        adapter = new ListaAdapter(this, jugadores, fotos, puntuacion);

        listajugadores.setAdapter(adapter);

        listajugadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Jugador elegido " + jugadores[i], Toast.LENGTH_SHORT).show();
                jugadorElegido = jugadores[i];
                setContentView(new Juego((Activity) view.getContext()));
                return false;
            }
        });


    }
    }