package com.example.renatombomioexam;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListasActivity extends AppCompatActivity implements View.OnClickListener {


    Spinner listaSpinner;
    ListView listviewSpinner;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        instancias();
        acciones();
    }

    private void acciones() {

    }

    private void instancias() {

        listaSpinner = findViewById(R.id.spinner);
        listviewSpinner = findViewById(R.id.listview_spinner);

    }
}
