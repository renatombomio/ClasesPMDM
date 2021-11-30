package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class DadosActivity extends AppCompatActivity {

    Button btnCambiarDado;
    ImageView imgDados;

    private int [] dadosAleatorios= {R.drawable.dado_uno, R.drawable.dado_dos, R.drawable.dado_tres, R.drawable.dado_cuatro, R.drawable.dado_cinco, R.drawable.dado_seis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instancias();
        dadoAleatorio();

    }

    private void instancias() {
        btnCambiarDado = findViewById(R.id.btn_tirar_dados);
        imgDados = findViewById(R.id.img_dados);
    }

    private void dadoAleatorio(){
        ImageView imgDado = (ImageView) findViewById(R.id.img_dados);

        Random numeros = new Random();
        int posicion = numeros.nextInt(7);

        imgDado.setImageResource(dadosAleatorios[posicion]);
    }

    public void btnCambiarImagen_Click(View view){
        imgDados.setImageResource(dadosAleatorios[6]);
        Collections.shuffle(new ArrayList(Collections.singleton(dadosAleatorios)));
    }
}