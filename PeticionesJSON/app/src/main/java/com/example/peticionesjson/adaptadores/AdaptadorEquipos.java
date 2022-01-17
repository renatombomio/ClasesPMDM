package com.example.peticionesjson.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peticionesjson.R;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MyHolder> {

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView nombre, estadio;
        ImageView escudo;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_equipo);
            estadio = itemView.findViewById(R.id.estadio_equipo);
            escudo = itemView.findViewById(R.id.escudo_equipo);
        }
    }

}
