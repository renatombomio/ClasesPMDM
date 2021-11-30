package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.repaso.utils.Marca;

public class DetailActivity extends AppCompatActivity {

    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imagen = findViewById(R.id.imagen_detalle);
        Marca marcaRecuperada = (Marca) getIntent().getExtras().getSerializable("marca");
        //Que imagen pongo aquí

        imagen.setImageResource(marcaRecuperada.getImagen());
    }
}