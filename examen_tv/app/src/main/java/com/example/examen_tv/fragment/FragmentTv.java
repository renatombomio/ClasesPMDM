package com.example.examen_tv.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.examen_tv.R;
import com.example.examen_tv.adaptadores.AdaptadorJuego;
import com.example.examen_tv.utils.Juego;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentTv extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdaptadorJuego adaptadorJuego;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_sport, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        asociarDatos();
        realizarPeticion();
    }

    private void realizarPeticion() {
        String url = "https://opentdb.com/api.php?amount=10&category=11&type=boolean";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);
    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray juegos = response.getJSONArray("response_code");
            for (int i = 0; i < juegos.length(); i++) {
                JSONObject juego = juegos.getJSONObject(i);
                String categoria = juego.getString("category");
                String tipo = juego.getString("type");
                String dificultad = juego.getString("difficulty");
                String pregunta = juego.getString("question");
                String respuestaC = juego.getString("correct_answer");
                String respuestaI = juego.getString("incorrect_answers");
                Juego preguntaActual = new Juego(categoria, tipo, dificultad ,pregunta, respuestaC, respuestaI);
                adaptadorJuego.agregarPregunta(preguntaActual);


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void asociarDatos() {
        recyclerView.setAdapter(adaptadorJuego);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void instancias() {
        recyclerView = view.findViewById(R.id.lista_tv);
        adaptadorJuego = new AdaptadorJuego(getContext());
    }
}
