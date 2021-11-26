package com.example.renatombomioexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    private List <Categoria> listaCategoria;
    private Context context;

    public void addCategoria (Categoria categoria){
        listaCategoria.add(categoria);
    }


    @Override
    public int getCount() { return listaCategoria.size();}

    @Override
    public Object getItem(int position) {
        return listaCategoria.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public AdaptadorSpinner (List <Categoria> listaCategoria, Context context){
        this.listaCategoria =listaCategoria;
        this.context = context;
    }

}
