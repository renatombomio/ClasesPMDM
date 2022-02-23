package com.example.pokeworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pokeworld.fragments.Pokedex;
import com.example.pokeworld.fragments.interfaces.PokeapiService;
import com.example.pokeworld.fragments.utils.Pokemon;
import com.example.pokeworld.fragments.utils.PokemonRespuesta;
import com.example.pokeworld.pantallas.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.net.URI;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button inicio;
    private FirebaseAuth mAuth;
    private static final String TAG = "POKEDEX";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        inicio= (Button) findViewById(R.id.btnInicio);

        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();



        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        }


}

