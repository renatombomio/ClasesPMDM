package com.example.examen_tv.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examen_tv.R;
import com.example.examen_tv.utils.Juego;

import java.util.ArrayList;

public class AdaptadorJuego extends RecyclerView.Adapter<AdaptadorJuego.MyHolder>{

    private ArrayList<Juego> listaPreguntas;
    private Context context;
    private OnEquipoListener listener;

    public AdaptadorJuego(Context context) {
        this.listaPreguntas = new ArrayList<>();
        this.context = context;
        this.listener = (OnEquipoListener) context;
    }

    public void agregarPregunta (Juego juego){
        this.listaPreguntas.add(juego);
        this.notifyDataSetChanged();
    }



    @NonNull
    @Override
    public AdaptadorJuego.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Juego preguntaActual = listaPreguntas.get(position);
        holder.pregunta.setText(preguntaActual.getPregunta());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ejecutado con la pulsacion de la fila
                listener.onEquipoSelected(preguntaActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPreguntas.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView pregunta;
        LinearLayout linearLayout;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            pregunta = itemView.findViewById(R.id.pregunta_item);
        }
    }

    private interface OnEquipoListener {

        void onEquipoSelected(Juego juego);
    }
}
