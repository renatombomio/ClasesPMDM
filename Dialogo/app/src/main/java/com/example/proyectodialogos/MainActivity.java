package com.example.proyectodialogos;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dialogo.R;
import com.example.proyectodialogos.dialog.DialogoConfirmacion;
import com.example.proyectodialogos.dialog.DialogoInformacion;
import com.example.proyectodialogos.dialog.DialogoListas;
import com.example.proyectodialogos.dialog.DialogoPersonalizado;
import com.example.proyectodialogos.utils.Persona;

public class MainActivity extends AppCompatActivity implements DialogoPersonalizado.OnDialogoPersoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_op1:
                //Toast.makeText(getApplicationContext(),"Opcion1", Toast.LENGTH_SHORT).show();
                // dialogo info
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "informacion");

                break;
            case R.id.menu_op2:
                //Toast.makeText(getApplicationContext(),"Opcion2", Toast.LENGTH_SHORT).show();
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(), "confirmacion");
                break;
            case R.id.menu_op3:
                //Toast.makeText(getApplicationContext(),"Opcion3", Toast.LENGTH_SHORT).show();
                DialogoListas dialogoListas = new DialogoListas();
                dialogoListas.show(getSupportFragmentManager(),"listas");

                break;
            case R.id.menu_op4:
                Toast.makeText(getApplicationContext(),"Opcion4", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onPersonaSelected(Persona persona) {
        Toast.makeText(getApplicationContext(),"comunicacion ok",Toast.LENGTH_SHORT).show();
    }
}