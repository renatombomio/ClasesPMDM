package com.example.aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  public void botonDice(View view){
        Toast.makeText(this,"Iniciando juego Dados", Toast.LENGTH_SHORT).show();
      Intent intent = new Intent(getApplicationContext(), DadosActivity.class);
      startActivity(intent);
  }

    public void botonAward(View view){
        Toast.makeText(this,"Iniciando juego Ganador", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), GanadorActivity.class);
        startActivity(intent);
    }

    public void botonShuffle(View view){
        Toast.makeText(this,"Iniciando juego aleatorio", Toast.LENGTH_SHORT).show();
    }

}