package com.example.pokemonfinal.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokemonfinal.R;
import com.example.pokemonfinal.utilspokemon.Pokedex;

public class MenuActivity extends AppCompatActivity {

    Button pokeGame, pokedex, salir;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pokeGame = (Button) findViewById(R.id.btn_pokegame);
        pokedex = (Button) findViewById(R.id.btn_pokedex);
        salir = (Button) findViewById(R.id.btn_salirM);


        pokedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MenuActivity.this, Pokedex.class);
                startActivity(i);
            }
        });


        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MenuActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });



    }
}
