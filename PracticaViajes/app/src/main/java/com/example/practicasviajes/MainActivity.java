package com.example.practicasviajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.practicasviajes.adapter.Destino;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner spinnerDestinos;
    private Button botonReservar;
    private EditText  editSalida, editRegreso, editHoraSalida, editHoraRegreso;
    private ArrayList <ListaActivity> listaDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarListas();
        acciones();
    }

    private void acciones() {

    }

    private void iniciarListas() {
    }

    private void instancias() {
        editSalida = findViewById(R.id.salida_spinner);
        editRegreso = findViewById(R.id.regreso_spinner);
        editHoraSalida = findViewById(R.id.hora_salida_spinner);
        editHoraSalida = findViewById(R.id.hora_salida2_spinner);
        botonReservar= findViewById(R.id.boton_agregar);
        listaDestino = new ArrayList();
    }

    @Override
    public void onClick(View v) {

    }
}