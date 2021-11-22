package com.example.configuraciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnResultado, btnMasUno, btnMasDos, btnMenosUno, btnMenosDos, btnBorrar;
    private EditText ediResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

        }
    }

    private void acciones (){
        btnMasUno.setOnClickListener(this);
        btnMasDos.setOnClickListener(this);
        btnMenosUno.setOnClickListener(this);
        btnMenosDos.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnResultado.setOnClickListener(this);
    }

    private void instancias() {
        btnBorrar = findViewById(R.id.btn_borrar);
        btnResultado = findViewById(R.id.btn_resultado);
        btnMasUno = findViewById(R.id.btn_mas_uno);
        btnMasDos = findViewById(R.id.btn_mas_dos);
        btnMenosUno = findViewById(R.id.btn_menos_uno);
        btnMenosDos = findViewById(R.id.btn_menos_dos);
    }

    @Override
    public void onClick(View v) {

    }
}