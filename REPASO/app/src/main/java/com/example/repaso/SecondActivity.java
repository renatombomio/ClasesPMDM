package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.repaso.adaptador.AdaptadorAvanzadoSpinner;
import com.example.repaso.utils.Marca;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity{

    private String nombreRecuperado;
    private int edadRecuperada;
    private Spinner spinner;
    private ArrayList <Marca> listaSpinner;
    private AdaptadorAvanzadoSpinner adaptadorAvanzadoSpinner;
    private AdaptadorAvanzadoSpinner adaptadorAvanzadoListView;
    private ArrayAdapter adapterSpinner;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        asociarElementos();
        getIntent().getExtras().getString("nombre");
        getIntent().getExtras().getInt("Edad");
        acciones();

    }

    private void asociarElementos() {
        listaSpinner.add(new Marca(R.drawable.audi, "Audi"));
        listaSpinner.add(new Marca(R.drawable.mercedes, "mercedes"));
        listaSpinner.add(new Marca(R.drawable.bmw, "BMW"));
        listaSpinner.add(new Marca(R.drawable.vw, "Volkswagen"));
        spinner.setAdapter(adaptadorAvanzadoSpinner);
        listView.setAdapter(adaptadorAvanzadoListView);
        adaptadorAvanzadoSpinner.notifyDataSetChanged();
        adaptadorAvanzadoListView.notifyDataSetChanged();


        //spinner.setAdapter(adapterSpinner);
        //adapterSpinner.notifyDataSetChanged();
    }


    private void acciones(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Marca marcaseleccionada = (Marca) adapterSpinner.getItem(position);
                Toast.makeText(getApplicationContext(), marcaseleccionada.getNombre(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Marca marcaSeleccionada = (Marca) adaptadorAvanzadoListView.getItem(position);
                /*Toast.makeText(getApplicationContext(), marcaSeleccionada.getNombre(), Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("marca",marcaSeleccionada);
                startActivity(intent);
            }
        });
    }

    private void instancias() {
        listaSpinner= new ArrayList();
        adapterSpinner = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaSpinner);
        adaptadorAvanzadoSpinner = new AdaptadorAvanzadoSpinner(listaSpinner, getApplicationContext());
        adaptadorAvanzadoListView = new AdaptadorAvanzadoSpinner(listaSpinner, getApplicationContext());
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.list_view);

    }

    public void rellenarCosas(){
        //por cualquier lógica quiero contestar a la actividad main
        Intent intent = new Intent();
        intent.putExtra("examen", 6);

        if (true){
            setResult(1, intent);
        }else {
            setResult(2, intent);
        }

        finish();
    }
}