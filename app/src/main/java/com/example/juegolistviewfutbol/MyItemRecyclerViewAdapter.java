package com.example.juegolistviewfutbol;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juegolistviewfutbol.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.juegolistviewfutbol.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Jugador> mValues;

    public MyItemRecyclerViewAdapter(List<Jugador> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mPhoto.setImageBitmap(mValues.get(position).getFotoJugador());
        holder.mNombre.setText(mValues.get(position).getNombreJugador());
        holder.mPuntuacion.setText(String.valueOf(segundaLista.puntos));

        holder.mPhoto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                segundaLista.jugadorElegido = (String) holder.mNombre.getText();
                Toast.makeText(v.getContext(), "Mierda" + holder.mNombre.getText(), Toast.LENGTH_SHORT).show();
                Log.d("Jugador elegido" , " es: " + segundaLista.jugadorElegido);
                Intent i = new Intent(v.getContext(), ActividadJuego.class);
                v.getContext().startActivity(i);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mPhoto;
        public final TextView mNombre;
        public final TextView mPuntuacion;
        public Jugador mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mPhoto = binding.imageViewFotoJugador;
            mNombre = binding.textViewNombreJugador;
            mPuntuacion = binding.textViewPuntosJugador;
        }

        @Override
        public String toString() {
            return super.toString() + " '"  + "'";
        }
    }
}