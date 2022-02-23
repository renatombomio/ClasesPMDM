package com.example.pokeworld.fragments.interfaces;

import com.example.pokeworld.fragments.utils.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {

    @GET("pokemon")
    Call <PokemonRespuesta> obtenerListaPokemon();
}
