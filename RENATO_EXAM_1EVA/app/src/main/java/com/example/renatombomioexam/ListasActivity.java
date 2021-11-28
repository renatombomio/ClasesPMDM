package com.example.renatombomioexam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListasActivity extends AppCompatActivity implements View.OnClickListener {


    Spinner listaSpinner;
    ListView listviewSpinner;
    private ArrayAdapter adaptadorSpinner;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        instancias();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String [] valores = {"Fútbol", "Series", "Juegos"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView <?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
            public  void onNothingSelected(AdapterView<?> parent){

            }
        });

        /*listviewSpinner.add(new Categoria("Romario", "FC. Barcelona", R.drawable.romario,"Fútbol"));
        listviewSpinner.add(new Categoria("Ronaldo", "Brasil", R.drawable.ronaldo,"Fútbol"));
        listviewSpinner.add(new Categoria("Maradona", "Argentina", R.drawable.maradona,"Fútbol"));
        listviewSpinner.add(new Categoria("Zidane", "Francia", R.drawable.zidane,"Fútbol"));
        listviewSpinner.add(new Categoria("Metal Gear", "Sigilo", R.drawable.metal,"Juegos"));
        listviewSpinner.add(new Categoria("Gran Turismo", "Coches", R.drawable.gt,"Juegos"));
        listviewSpinner.add(new Categoria("God Of War", "Plataformas", R.drawable.god,"Juegos"));
        listviewSpinner.add(new Categoria("Final Fantasy X", "Rol", R.drawable.ffx,"Juegos"));
        listviewSpinner.add(new Categoria("Stranger Things", "Fantastica", R.drawable.stranger,"Series"));
        listviewSpinner.add(new Categoria("Juego de tronos", "Histórica", R.drawable.tronos,"Series"));
        listviewSpinner.add(new Categoria("Lost", "Fantastica", R.drawable.lost,"series"));
        listviewSpinner.add(new Categoria("La casa de papel", "Accion", R.drawable.papel,"Series"));
        acciones();*/
    }

    private void iniciarElementos() {


        //listviewSpinner.setAdapter();
    }

    private void acciones() {

    }

    private void instancias() {

        listaSpinner = findViewById(R.id.spinner);
        listviewSpinner = findViewById(R.id.listview_spinner);

    }
}
