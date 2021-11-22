package com.example.elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton toggle;
    private TextView textoToggle, textocheck, textogrupo;
    private CheckBox checkBox;
    RadioGroup gruporadios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        inicializarElementos();
        acciones();
    }

    private void inicializarElementos() {
        toggle.setChecked(true);
        textoToggle.setText("Texto seleccionado");
        checkBox.setChecked(true);
        textocheck.setText("Check seleccionado");
    }

    private void acciones() {
        toggle.setOnCheckedChangeListener(this);
        checkBox.setOnCheckedChangeListener(this);
        gruporadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.opn1:
                        //si hay accion diferente
                        Toast.makeText(getApplicationContext(), "Uno seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.opn2:
                        //si hay accion diferente
                        Toast.makeText(getApplicationContext(), "Dos seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.opn3:
                        //si hay accion diferente
                        Toast.makeText(getApplicationContext(), "Tres seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                }
                RadioButton bAux= findViewById(checkedId);
                textogrupo.setText(bAux.getText());
            }
        });

    }

    private void instancias() {
        toggle = findViewById(R.id.toggle_inicial);
        textoToggle = findViewById(R.id.texto_toggle);
        checkBox = findViewById(R.id.check_inicial);
        textocheck= findViewById(R.id.texto_check);
        textogrupo= findViewById(R.id.texto_grupo);
        gruporadios= findViewById(R.id.grupo_radios);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.check_inicial:

                if (isChecked) {
                    textocheck.setText("check" +getResources().getString (R.string.seleccionado));
                } else {
                    textocheck.setText("check" + getResources().getString (R.string.deseleccionado));
                }
                break;

            case R.id.toggle_inicial:

                if (isChecked) {
                    textoToggle.setText("Toggle" + getResources().getString(R.string.seleccionado));
                } else {
                    textoToggle.setText("Toggle" + getResources().getString(R.string.deseleccionado));
                }
                checkBox.setEnabled(isChecked);
                break;
        }
    }
}