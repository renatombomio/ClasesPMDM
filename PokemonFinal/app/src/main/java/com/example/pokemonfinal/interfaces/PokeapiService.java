package com.example.pokemonfinal.interfaces;

import com.example.pokemonfinal.utilspokemon.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
