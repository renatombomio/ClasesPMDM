package com.example.practicasviajes;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.practicasviajes.adapter.Destino;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    ArrayList<Destino> listaDestinos;
    Context context;

    public AdaptadorLista(ArrayList<Destino> listaDestinos, Context context) {

        this.listaDestinos = listaDestinos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDestinos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDestinos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        Destino destinoSalida = listaDestinos.get(position);

        ImageView imagen= convertView.findViewById(R.id.img_item_lista);
        TextView texto = convertView.findViewById(R.id.texto_item_lista);

        texto.setText(destinoSalida.getNombre());
        imagen.setImageResource(destinoSalida.getImagen());

        return convertView;


    }
}
