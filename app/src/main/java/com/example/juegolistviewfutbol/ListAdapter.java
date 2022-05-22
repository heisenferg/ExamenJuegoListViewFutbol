package com.example.juegolistviewfutbol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ListaAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    String[] jugadores;
    int[] imagenes;
    public static int [] puntuacion;
    LayoutInflater inflater;
    public static String jugadorElegido;

    public ListaAdapter(Context context, String[] titulos, int[] imagenes, int [] puntuacion) {
        this.context = context;
        this.jugadores = titulos;
        this.imagenes = imagenes;
        this.puntuacion = puntuacion;
    }

    @Override
    public int getCount() {
        return jugadores.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle;
        ImageView imgImg;
        TextView puntos;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.filaslist, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.textViewNombre);
        imgImg = (ImageView) itemView.findViewById(R.id.imageViewFila);
        puntos = itemView.findViewById((R.id.textViewPuntos));

        // Capture position and set to the TextViews
        txtTitle.setText(jugadores[position]);
        imgImg.setImageResource(imagenes[position]);
        puntos.setText(String.valueOf(puntuacion[position]));
        jugadorElegido = String.valueOf(jugadores[position]);
        return itemView;
    }
}
