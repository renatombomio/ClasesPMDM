package com.example.renatombomioexam;

import android.widget.ImageView;

public class Categoria {

    private String nombre, origen, categoria;
    int imageSpinner;



    public Categoria(String nombre, String origen, int imageSpinner, String categoria) {
        this.nombre = nombre;
        this.origen = origen;
        this.imageSpinner = imageSpinner;
        this.categoria =categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getImageSpinner() {
        return imageSpinner;
    }

    public void setImageSpinner(int imageSpinner) {
        this.imageSpinner = imageSpinner;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
