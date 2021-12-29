package com.example.practicasviajes.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.practicasviajes.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    private ArrayList <Destino> listaDestino;
    private Context context;

    public AdaptadorSpinner(ArrayList<Destino> listaDestino, Context context){
        this.listaDestino = listaDestino;
        this.context = context;
    }

    public  AdaptadorSpinner (Context context){
        this.listaDestino = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDestino.size();
    }

    @Override
    public Object getItem(int position) {
        return  listaDestino.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.reservas, parent, false);

        ImageView imagenS = convertView.findViewById(R.id.imagen_fila_salida_spinner);
        ImageView imagenR = convertView.findViewById(R.id.imagen_fila_regreso_spinner);
        EditText editSalida = convertView.findViewById(R.id.salida_spinner);
        EditText editRegreso = convertView.findViewById(R.id.regreso_spinner);
        EditText editHoraSalida = convertView.findViewById(R.id.hora_salida_spinner);
        EditText editHoraRegreso = convertView.findViewById(R.id.hora_salida2_spinner);

        Destino itemAux= listaDestino.get(position);
        imagenS.setImageResource(itemAux.getImagen());
        imagenR.setImageResource(itemAux.getImagen());

        return convertView;
    }
}
