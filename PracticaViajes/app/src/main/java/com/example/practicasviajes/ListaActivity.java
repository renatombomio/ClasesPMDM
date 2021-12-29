package com.example.practicasviajes;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.practicasviajes.adapter.Destino;
import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList <Destino> listaDestinos;
    private AdaptadorLista adaptadorLista;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_lista);
        instancias();
        rellenarListas();
        asociarElementos();
    }


    private void rellenarListas() {
        listaDestinos.add(new Destino("Chicago", R.drawable.chicago));
        listaDestinos.add(new Destino("Lisboa", R.drawable.lisboa));
        listaDestinos.add(new Destino("Londres", R.drawable.londres));
        listaDestinos.add(new Destino("Madrid", R.drawable.madrid));
        listaDestinos.add(new Destino("Malabo", R.drawable.malabo));
        listaDestinos.add(new Destino("Paris", R.drawable.paris));
        listaDestinos.add(new Destino("Roma", R.drawable.roma));
    }

    private void asociarElementos() {
        lista.setAdapter(adaptadorLista);
    }

    private void instancias() {
        lista = findViewById(R.id.list_item);
        listaDestinos = new ArrayList<>();
        adaptadorLista = new AdaptadorLista(listaDestinos, getApplicationContext());
    }
}
