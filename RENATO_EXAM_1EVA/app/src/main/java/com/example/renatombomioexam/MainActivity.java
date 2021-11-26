package com.example.renatombomioexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIniciar;

    @Override
    public void onClick(View v) {
    Intent intent = new Intent(getApplicationContext(), ListasActivity.class);
    startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListasActivity.class);
                startActivity(intent);
            }
        });
        acciones();
    }

    private void acciones()  {
        btnIniciar.setOnClickListener(this);
    }

    private void instancias() {
        btnIniciar = findViewById(R.id.btn_Iniciar);
    }


}