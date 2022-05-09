package com.example.pokeworld.fragments.PokeGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokeworld.MainActivity;
import com.example.pokeworld.R;
import com.example.pokeworld.pantallas.LoginActivity;
import com.example.pokeworld.pantallas.MenuActivity;

public class Juego extends AppCompatActivity implements View.OnClickListener {

    Button salirJuego, iniciarJuego;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        salirJuego = (Button) findViewById(R.id.btn_salirJ);
        iniciarJuego = (Button) findViewById(R.id.btn_inicioJ);



        salirJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Juego.this, MenuActivity.class);
                startActivity(i);
            }
        });

        iniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Juego.this, Tictactoe.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btn_salirJ:
                Intent i = new Intent(Juego.this, MenuActivity.class);
                startActivity(i);

            case R.id.btn_inicioJ:
                Toast.makeText(this, "Iniciar juego", Toast.LENGTH_SHORT).show();

        }
    }
}
