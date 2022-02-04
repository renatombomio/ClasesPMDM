package com.example.examen_tv.utils;

import java.io.Serializable;

public class Juego implements Serializable {
    private String categoria, tipo, dificultad, pregunta, respuestaC, respuestaI;


    public Juego (String categoria, String tipo, String dificultad, String pregunta, String respuestaC, String respuestaI){
        this.categoria = categoria;
        this.tipo = tipo;
        this.dificultad = dificultad;
        this.pregunta = pregunta;
        this.respuestaC = respuestaC;
        this.respuestaI = respuestaI;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String isRespuestaC() {
        return respuestaC;
    }

    public void setRespuestaC(String respuestaC) {
        this.respuestaC = respuestaC;
    }

    public String isRespuestaI() {
        return respuestaI;
    }

    public void setRespuestaI(String respuestaI) {
        this.respuestaI = respuestaI;
    }
}
