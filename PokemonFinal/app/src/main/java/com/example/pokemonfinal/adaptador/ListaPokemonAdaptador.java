package com.example.pokemonfinal.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokemonfinal.R;
import com.example.pokemonfinal.utilspokemon.Pokemon;

import java.util.ArrayList;

public class ListaPokemonAdaptador extends RecyclerView.Adapter<ListaPokemonAdaptador.ViewHolder> {

    private ArrayList<Pokemon> database;
    private Context context;

    public ListaPokemonAdaptador( Context context){
        this.context = context;
        database= new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_pokedex, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Pokemon p = database.get(position);
        holder.nombrePokedex.setText(p.getName());

        Glide.with(context).load("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/00" + p.getNumber()+".png")
                .centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imgenPokedex);
    }

    @Override
    public int getItemCount() {
        return database.size();
    }

    public void meterListaPokemon(ArrayList<Pokemon> listaPokemon) {
        database.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgenPokedex;
        private TextView nombrePokedex;


        public ViewHolder (View itemView){
            super(itemView);

            imgenPokedex = (ImageView) itemView.findViewById(R.id.img_pokedex);
            nombrePokedex = (TextView) itemView.findViewById(R.id.nombre_pokedex);
        }
    }


}
