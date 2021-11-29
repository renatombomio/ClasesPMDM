package com.example.repaso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //asocia lógico con gráfico
        setContentView(R.layout.activity_main);
        instancias();
        botonPasar.setOnClickListener(this);

    }

    private void instancias() {
        botonPasar = findViewById(R.id.boton_pasar_pantalla);
    }

    @Override
    public void onClick(View v) {
        //hace referencia al this de la linea 19 botonpasar.setOnClicklistener(this);
        switch (v.getId()){
            case R.id.boton_pasar_pantalla:
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Nombre", "Renato");
                intent.putExtra("Edad", 24);
                startActivity(intent);

                /*if (true){
                    startActivityForResult(intent,0);
                }else {
                    startActivityForResult(intent,1);
                }*/
                break;
        }
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}