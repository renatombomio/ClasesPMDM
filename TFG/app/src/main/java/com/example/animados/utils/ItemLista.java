package com.example.animados.utils;

import java.io.Serializable;

public class ItemLista implements Serializable {

    private String nombre, sexo, peso, raza, descripcion, ubicacion, edad, estado, email, numero;
    private int imgResource;


    public ItemLista (String nombre,String estado, String sexo, String peso, String raza, String ubicacion, String edad, int imgResource,String descripcion, String email,String numero){
        this.nombre = nombre;
        this.estado = estado;
        this.sexo = sexo;
        this.peso = peso;
        this.raza = raza;
        this.ubicacion = ubicacion;
        this.edad = edad;
        this.imgResource = imgResource;
        this.descripcion = descripcion;
        this.email = email;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {return estado; }

    public String getSexo() {
        return sexo;
    }

    public String getPeso() {
        return peso;
    }

    public String getRaza() {
        return raza;
    }

    public String getUbicacion() {return ubicacion;}

    public String getEdad() {return edad;}

    public int getImgResource() {
        return imgResource;
    }

    public String getDescripcion() {return descripcion;}

    public String getEmail() {return email;}

    public String getNumero() {return numero;}


}
