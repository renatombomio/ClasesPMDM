package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Creamos las variables correspondientes para luego instanciarlos

    TextView pantalla;
    Button ac, negativo, elevado, dividir, siete, ocho , nueve, multiplicar, cuatro, cinco, seis, restar,
    uno, dos, tres, sumar, cero, punto, borrar, igual;
    String poner, respuesta;


    //No he generado metodo acciones();, no ha sido necesario porque he puesto las acciones directamente a los botones.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    //intancio los Id con sus variables correspondientes para que funcionen


    private void instancias() {
        pantalla = findViewById(R.id.txt_pantalla);
        ac = findViewById(R.id.btn_ac);
        negativo = findViewById(R.id.btn_negativo);
        elevado = findViewById(R.id.btn_elevado);
        dividir = findViewById(R.id.btn_dividir);
        multiplicar = findViewById(R.id.btn_multiplicar);
        sumar = findViewById(R.id.btn_suma);
        restar = findViewById(R.id.btn_restar);
        borrar = findViewById(R.id.btn_borrar);
        igual = findViewById(R.id.btn_igual);
        punto = findViewById(R.id.btn_punto);
        cero = findViewById(R.id.btn_cero);
        uno = findViewById(R.id.btn_uno);
        dos = findViewById(R.id.btn_dos);
        tres = findViewById(R.id.btn_tres);
        cuatro = findViewById(R.id.btn_cuatro);
        cinco = findViewById(R.id.btn_cinco);
        seis = findViewById(R.id.btn_seis);
        siete = findViewById(R.id.btn_siete);
        ocho = findViewById(R.id.btn_ocho);
        nueve = findViewById(R.id.btn_nueve);

    }

    //Poniendo las variables que vamos a poder ver en la pantalla al pulsar

    public void botonClick(View view){
        Button boton = (Button) view;
        String datos = boton.getText().toString();
        switch (datos){
            case "AC":
                poner="";
                break;
            case "C":
                String nuevoTexto = poner.substring(0,poner.length()-1);
                poner = nuevoTexto;
                break;
            case "x":
                solucion();
                poner+="*";
                break;
            case "^":
                solucion();
                poner+= "^";
                break;
            case "+/-":
                solucion();
                poner+= "-";
            case "=":
                solucion();
                respuesta=poner;
                break;
            default:
                if (poner ==null){
                    poner="";
                }
                if (datos.equals("+") || datos.equals("-") || datos.equals("/")){
                    solucion();
                }
                 poner+=datos;
        }
        pantalla.setText(poner);
    }

    //operaciones lógicas para la calculadora

    private void solucion() {
        if (poner.split("\\*").length==2){
            String number [] = poner.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                poner = mul+"";
            }
            catch (Exception e){

            }
        }
        else if (poner.split("/").length==2){
            String number [] = poner.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                poner = div+"";
            }
            catch (Exception e){

            }
        }
        else if (poner.split("\\^").length==2){
            String number [] = poner.split("\\^");
            try {
                double por = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                poner = por+"";
            }
            catch (Exception e){

            }
        }
        else if (poner.split("\\+").length==2){
            String number [] = poner.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                poner = sum+"";
            }
            catch (Exception e){

            }
        }
        else if (poner.split("-").length>1){
            String number [] = poner.split("-");
            if (number[0] =="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double res=0;
                if (number.length==2){
                    res = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if (number.length == 3){
                    res = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                poner = res+"";
            }
            catch (Exception e){

            }
        }
        String n[] = poner.split("\\.");
        if (n.length>1){
            if (n [1].equals("0")) {
                poner=n[0];
            }
        }
    }
}