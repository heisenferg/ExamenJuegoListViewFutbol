package com.example.juegolistviewfutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.juegolistviewfutbol.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

public class segundaLista extends AppCompatActivity {

    public static List<Jugador> listaJugador = new ArrayList<Jugador>();
    public static String jugadorElegido;
    public static int puntos=0;
    Bitmap imagenJugador;
    int[] fotos = {R.drawable.cristiano,
            R.drawable.karim,
            R.drawable.luka,
            R.drawable.mbappe,
            R.drawable.messi
    };
    public static int [] puntuacion = {0,0,0,0,0};
    String[] jugadores= {"Cristiano Ronaldo", "Benzema", "Luka Modric", "Mbappe", "Messi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_lista);
        rellenoArray();

    }
/*
    public void rellenoArray(){
        Bitmap benzema = BitmapFactory.decodeResource(getResources(),R.drawable.karim);
        Bitmap ronaldo =BitmapFactory.decodeResource(getResources(),  R.drawable.cristiano);
        Bitmap messi = BitmapFactory.decodeResource(getResources(), R.drawable.messi);
        Bitmap mbape = BitmapFactory.decodeResource(getResources(), R.drawable.mbappe);
        Jugador numero1 = new Jugador(ronaldo,"Cristiano Ronaldo",0);
        Jugador numero2 = new Jugador(benzema,"Benzema",0);
        Jugador numero3 = new Jugador(messi,"Messi",0);
        Jugador numero4 = new Jugador(mbape,"mbbape RATA",0);
        listaJugador.add(numero1);
        listaJugador.add(numero2);
        listaJugador.add(numero3);
        listaJugador.add(numero4);
    }
*/
    public void rellenoArray(){
        PlaceholderContent.ITEMS.clear();
        for (int i =0; i<5; i++){
            imagenJugador = BitmapFactory.decodeResource(getResources(),fotos[i]);
            Jugador jugador = new Jugador(imagenJugador, jugadores[i], puntuacion[i]);
            listaJugador.add(jugador);
        }
    }


}