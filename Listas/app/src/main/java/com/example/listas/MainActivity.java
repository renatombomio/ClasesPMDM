package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listas.adapters.AdaptadorSpinner;
import com.example.listas.utils.Coche;
import com.example.listas.utils.Marca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerCoches;
    private  TextView textoCoches, textoMarca, textomodelo, textoCv;
    private EditText editMarca, editModelo, editCv;
    private ImageView imagenCoches;
    private Button botonComprobar, botonAnadirMarca;
    private ArrayAdapter adaptadorSpinner;
    private ArrayList <Marca> listaMarcas;
    private ArrayList <Coche> listaCoches;
    private AdaptadorSpinner adaptadorSpinnerAvanzado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        iniciarListas();
        iniciarElementos();
        acciones();
    }

    private void acciones() {

        botonComprobar.setOnClickListener(this);
        botonAnadirMarca.setOnClickListener(this);
        spinnerCoches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Algo seleccionado",Toast.LENGTH_SHORT).show();
                Coche coche = (Coche) adaptadorSpinnerAvanzado.getItem(position);
                textoMarca.setText(coche.getMarca());
                textomodelo.setText(coche.getModelo());
                textoCv.setText(String.valueOf(coche.getCv()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"No hay nada seleccionado", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void iniciarElementos() {

        //spinnerCoches.setAdapter(adaptadorSpinner);
        spinnerCoches.setAdapter(adaptadorSpinnerAvanzado);
    }

    private void iniciarListas() {
        listaCoches.add(new Coche("EQE", "Mercedes", R.drawable.eqe, 100));
        listaCoches.add(new Coche("A7", "Audi", R.drawable.a7, 200));
        listaCoches.add(new Coche("M135i", "BMW", R.drawable.m13, 100));
        listaCoches.add(new Coche("T-Roc", "Volkswagen", R.drawable.troc, 100));

    }

    private void instancias() {
        editCv= findViewById(R.id.edit_cv);
        editMarca= findViewById(R.id.edit_marca);
        editModelo= findViewById(R.id.edit_modelo);
        spinnerCoches= findViewById(R.id.spinner_coches);
        textoMarca= findViewById(R.id.texto_marca);
        textomodelo= findViewById(R.id.texto_modelo);
        textoCv= findViewById(R.id.texto_cv);
        imagenCoches= findViewById(R.id.imagen_coche);
        botonComprobar= findViewById(R.id.boton_comprobar);
        botonAnadirMarca= findViewById(R.id.boton_anadir);
        listaMarcas = new ArrayList();
        listaCoches= new ArrayList<>();
        adaptadorSpinner = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaMarcas);
        adaptadorSpinnerAvanzado = new AdaptadorSpinner(listaCoches, getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_comprobar:
                //textoCoches.setText(String.valueOf(spinnerCoches.getSelectedItem()));
                //adaptadorSpinner
                //spinnerCoches.getAdapter()
                /*textoCoches.setText(
                        adaptadorSpinner.
                                getItem(spinnerCoches.getSelectedItemPosition()).toString());*/

                Coche coche = (Coche) adaptadorSpinnerAvanzado.getItem(spinnerCoches.getSelectedItemPosition());
                textomodelo.setText(coche.getModelo());
                textoMarca.setText(coche.getMarca());
                textoCv.setText(String.valueOf(coche.getCv()));

                imagenCoches.setImageResource(coche.getImagen());
                break;


            case R.id.boton_anadir:

                //listaMarcas.add(new Marca("Marca nueva", R.drawable.def));
                //adaptadorSpinner.notifyDataSetChanged();

                Coche cocheAdd= new Coche(editModelo.getText().toString(), editMarca.getText().toString(),
                        R.drawable.def,
                        Integer.valueOf(editCv.getText().toString()));


                adaptadorSpinnerAvanzado.addCoche(cocheAdd);

                break;

        }
    }
}