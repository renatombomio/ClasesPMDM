package com.example.practicasviajes.adapter;

public class Destino {

    private String nombre;
    private int imagen;

    public Destino (String nombre, int imagen){
        this.nombre= nombre;
        this.imagen= imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
