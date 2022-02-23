package com.example.pokemonfinal.pokegame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokemonfinal.R;
import com.example.pokemonfinal.pantallas.MenuActivity;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {

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
                Intent i = new Intent( JuegoActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        iniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( JuegoActivity.this, Tictactoe.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
