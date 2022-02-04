package com.example.examen_tv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.examen_tv.fragment.FragmentFila;
import com.example.examen_tv.fragment.FragmentSp;
import com.example.examen_tv.fragment.FragmentTv;
import com.example.examen_tv.fragment.FragmentVg;
import com.example.examen_tv.utils.Juego;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lista_sport, new FragmentSp());
        fragmentTransaction.replace(R.id.lista_tv, new FragmentTv());
        fragmentTransaction.replace(R.id.lista_videogame, new FragmentVg());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray arrayResultado = response.getJSONArray("response_code");
            for (int i = 0; i < arrayResultado.length(); i++) {
                JSONObject juego = arrayResultado.getJSONObject(i);
                String nombre = juego.getString("question");
                Log.v("pregunta",nombre);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

   public void onEquipoSelected (Juego juego){
       fragmentManager = getSupportFragmentManager();
       fragmentTransaction = fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.lista_sport, FragmentFila.newInstance(juego));
       fragmentTransaction.replace(R.id.lista_tv, FragmentFila.newInstance(juego));
       fragmentTransaction.replace(R.id.lista_videogame, FragmentFila.newInstance(juego));
       fragmentTransaction.addToBackStack("pregunta");
       fragmentTransaction.commit();
   }
}