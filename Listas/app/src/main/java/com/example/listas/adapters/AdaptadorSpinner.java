package com.example.listas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listas.R;
import com.example.listas.utils.Coche;

import java.util.List;

public class AdaptadorSpinner  extends BaseAdapter {

    private List <Coche> listaCoches;
    private Context context;


    public void addCoche(Coche coche){
        listaCoches.add(coche);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return listaCoches.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCoches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public AdaptadorSpinner(List<Coche> listaCoches, Context context) {
        this.listaCoches = listaCoches;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_layout, parent, false);

        ImageView imagen = convertView.findViewById(R.id.imagen_fila_spinner);
        TextView modelo = convertView.findViewById(R.id.modelo_fila_spinner);
        TextView cv = convertView.findViewById(R.id.cv_fila_spinner);

        Coche itemAux= listaCoches.get(position);
        imagen.setImageResource(itemAux.getImagen());
        modelo.setText(itemAux.getModelo());
        cv.setText(String.valueOf(itemAux.getCv()));


        return convertView;
    }
}
