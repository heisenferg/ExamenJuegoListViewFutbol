package com.example.juegolistviewfutbol;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

public class Jugador {

    Bitmap fotoJugador;
    String nombreJugador;
    int puntosJugador;

    public Jugador(Bitmap fotoJugador, String nombreJugador, int puntosJugador) {
        this.fotoJugador = fotoJugador;
        this.nombreJugador = nombreJugador;
        this.puntosJugador = puntosJugador;
    }

    public Jugador() {

    }

    public Bitmap getFotoJugador() {
        return fotoJugador;
    }

    public void setFotoJugador(Bitmap fotoJugador) {
        this.fotoJugador = fotoJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntosJugador() {
        return puntosJugador;
    }

    public void setPuntosJugador(int puntosJugador) {
        this.puntosJugador = puntosJugador;
    }
}