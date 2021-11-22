package com.example.listas.utils;

public class Marca {

    private String nombre;
    private int Imagen;

    public Marca(String nombre, int imagen) {
        this.nombre = nombre;
        Imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    @Override
    public String toString(){return nombre;}
}
