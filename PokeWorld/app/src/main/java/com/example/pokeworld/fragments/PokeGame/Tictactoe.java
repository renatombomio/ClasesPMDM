package com.example.pokeworld.fragments.PokeGame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokeworld.R;
import com.example.pokeworld.pantallas.MenuActivity;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class Tictactoe extends AppCompatActivity implements View.OnClickListener {

    private Chronometer cronometroj;
    private boolean running;
    private long pausaOff;
    boolean squirtleGana = false, meowGana = false;
    TextView jugador1j, jugador2j;
    int[] espacios = new int[9];
    int random;
    ImageView unoj, dosj, tresj, cuatroj, cincoj, seisj, sietej, ochoj, nuevej;
    Button salidaj, btn_iniciarJ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_juego);
        instancias();
        acciones();
        iniciar();
        pausar();
        reiniciar();




    }

    private void acciones() {

        unoj.setOnClickListener(this);
        dosj.setOnClickListener(this);
        tresj.setOnClickListener(this);
        cuatroj.setOnClickListener(this);
        cincoj.setOnClickListener(this);
        seisj.setOnClickListener(this);
        sietej.setOnClickListener(this);
        ochoj.setOnClickListener(this);
        nuevej.setOnClickListener(this);

    }

    private void instancias() {

        unoj = (ImageView) findViewById(R.id.uno);
        dosj = (ImageView) findViewById(R.id.dos);
        tresj = (ImageView) findViewById(R.id.tres);
        cuatroj = (ImageView) findViewById(R.id.cuatro);
        cincoj = (ImageView) findViewById(R.id.cinco);
        seisj = (ImageView) findViewById(R.id.seis);
        sietej = (ImageView) findViewById(R.id.siete);
        ochoj = (ImageView) findViewById(R.id.ocho);
        nuevej = (ImageView) findViewById(R.id.nueve);

        jugador1j = (TextView) findViewById(R.id.squirtle);
        jugador2j = (TextView) findViewById(R.id.meow);

        cronometroj = (Chronometer) findViewById(R.id.cronometro);
        cronometroj.setFormat("Time: %");
        cronometroj.setBase(SystemClock.elapsedRealtime());

        salidaj = (Button) findViewById(R.id.btn_salidaJ);
        btn_iniciarJ = findViewById(R.id.btn_iniciarJuegoJ);

    }

    public void iniciar() {
        if (!running) {
            cronometroj.setBase(SystemClock.elapsedRealtime() - pausaOff);
            cronometroj.start();
            jugador1j.setText("Squirtle");
            jugador2j.setText("Meow");
            running = true;
        }
    }




    public void pausar() {
        if (running) {
            cronometroj.stop();
            pausaOff = SystemClock.elapsedRealtime() - cronometroj.getBase();
            running = false;
        }
    }

    public void reiniciar() {

        cronometroj.setBase(SystemClock.elapsedRealtime());
        pausaOff = 0;
        cronometroj.start();

        jugador1j.setText("Squirtle");
        jugador2j.setText("Meow");

        unoj.setImageDrawable(null);
        dosj.setImageDrawable(null);
        tresj.setImageDrawable(null);
        cuatroj.setImageDrawable(null);
        cincoj.setImageDrawable(null);
        seisj.setImageDrawable(null);
        sietej.setImageDrawable(null);
        ochoj.setImageDrawable(null);
        nuevej.setImageDrawable(null);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.uno:
                if (espacios[0] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[0] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;

            case R.id.dos:
                if (espacios[1] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[1] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();

                }
                break;
            case R.id.tres:
                if (espacios[2] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[2] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.cuatro:
                if (espacios[3] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[3] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.cinco:
                if (espacios[4] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[4] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.seis:
                if (espacios[5] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[5] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.siete:
                if (espacios[6] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[6] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.ocho:
                if (espacios[7] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[7] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.nueve:
                if (espacios[8] == 0) {
                    unoj.setImageResource(R.drawable.squirtle);
                    espacios[8] = 1;
                    ComprobarSiGanaSquirtle();
                    TurnoDeMeow();
                }
                break;
            case R.id.btn_salidaJ:
                Intent i = new Intent(Tictactoe.this, Juego.class);
                startActivity(i);

            case R.id.btn_iniciarJuegoJ:
                Toast.makeText(this, "Iniciar juego", Toast.LENGTH_SHORT).show();
        }
    }

    public void TurnoDeMeow(){
        if (meowGana ==false){
            random = (int)(8 * Math.random()) +1;
            if (espacios [random]==0){
                switch (random){
                    case 0: unoj.setImageResource(R.drawable.meow); break;
                    case 1: dosj.setImageResource(R.drawable.meow); break;
                    case 2: tresj.setImageResource(R.drawable.meow); break;
                    case 3: cuatroj.setImageResource(R.drawable.meow); break;
                    case 4: cincoj.setImageResource(R.drawable.meow); break;
                    case 5: seisj.setImageResource(R.drawable.meow); break;
                    case 6: sietej.setImageResource(R.drawable.meow); break;
                    case 7: ochoj.setImageResource(R.drawable.meow); break;
                    case 8: nuevej.setImageResource(R.drawable.meow); break;
                }

                espacios [random] = 2;
                ComprobarSiGanaSquirtle();
            }
            else {
                TurnoDeMeow();
            }
        }
    }

    public void ComprobarSiGanaSquirtle(){

        if (espacios[0] == 1 && espacios[1]==1 && espacios [2] == 1) squirtleGana= true;
        if (espacios[3] == 1 && espacios[4]==1 && espacios [5] == 1) squirtleGana= true;
        if (espacios[6] == 1 && espacios[7]==1 && espacios [8] == 1) squirtleGana= true;

        if (espacios[5] == 1 && espacios[7]==1 && espacios [8] == 1) squirtleGana= true;
        if (espacios[3] == 1 && espacios[4]==1 && espacios [5] == 1) squirtleGana= true;
        if (espacios[0] == 1 && espacios[1]==1 && espacios [2] == 1) squirtleGana= true;

        if (espacios[0] == 1 && espacios[3]==1 && espacios [6] == 1) squirtleGana= true;
        if (espacios[1] == 1 && espacios[4]==1 && espacios [7] == 1) squirtleGana= true;
        if (espacios[2] == 1 && espacios[5]==1 && espacios [8] == 1) squirtleGana= true;

        if (espacios[6] == 1 && espacios[3]==1 && espacios [0] == 1) squirtleGana= true;
        if (espacios[7] == 1 && espacios[4]==1 && espacios [1] == 1) squirtleGana= true;
        if (espacios[8] == 1 && espacios[5]==1 && espacios [2] == 1) squirtleGana= true;

        if (espacios[8] == 1 && espacios[4]==1 && espacios [0] == 1) squirtleGana= true;
        if (espacios[6] == 1 && espacios[4]==1 && espacios [2] == 1) squirtleGana= true;
        if (espacios[2] == 1 && espacios[4]==1 && espacios [6] == 1) squirtleGana= true;
        if (espacios[0] == 1 && espacios[4]==1 && espacios [8] == 1) squirtleGana= true;


        if (squirtleGana == true) {
            Toast menssaje = Toast.makeText(this, "¡Gana Squirtle!",Toast.LENGTH_SHORT);
            menssaje.show();
            cronometroj.stop();
            borrar();
        }

        if (espacios[0] == 1 && espacios[1]==1 && espacios [2] == 1) squirtleGana= true;
        if (espacios[3] == 1 && espacios[4]==1 && espacios [5] == 1) squirtleGana= true;
        if (espacios[6] == 1 && espacios[7]==1 && espacios [8] == 1) squirtleGana= true;

        if (espacios[5] == 1 && espacios[7]==1 && espacios [8] == 1) squirtleGana= true;
        if (espacios[3] == 1 && espacios[4]==1 && espacios [5] == 1) squirtleGana= true;
        if (espacios[0] == 1 && espacios[1]==1 && espacios [2] == 1) squirtleGana= true;

        if (espacios[0] == 1 && espacios[3]==1 && espacios [6] == 1) squirtleGana= true;
        if (espacios[1] == 1 && espacios[4]==1 && espacios [7] == 1) squirtleGana= true;
        if (espacios[2] == 1 && espacios[5]==1 && espacios [8] == 1) squirtleGana= true;

        if (espacios[6] == 1 && espacios[3]==1 && espacios [0] == 1) squirtleGana= true;
        if (espacios[7] == 1 && espacios[4]==1 && espacios [1] == 1) squirtleGana= true;
        if (espacios[8] == 1 && espacios[5]==1 && espacios [2] == 1) squirtleGana= true;

        if (espacios[8] == 1 && espacios[4]==1 && espacios [0] == 1) squirtleGana= true;
        if (espacios[6] == 1 && espacios[4]==1 && espacios [2] == 1) squirtleGana= true;
        if (espacios[2] == 1 && espacios[4]==1 && espacios [6] == 1) squirtleGana= true;
        if (espacios[0] == 1 && espacios[4]==1 && espacios [8] == 1) squirtleGana= true;


        if (meowGana == true) {
            Toast menssaje = Toast.makeText(this, "¡Gana Meow!",Toast.LENGTH_SHORT);
            menssaje.show();
            cronometroj.stop();
            borrar();
        }

    }

    public void borrar(){

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                unoj.setImageDrawable(null);
                dosj.setImageDrawable(null);
                tresj.setImageDrawable(null);
                cuatroj.setImageDrawable(null);
                cincoj.setImageDrawable(null);
                seisj.setImageDrawable(null);
                sietej.setImageDrawable(null);
                ochoj.setImageDrawable(null);
                nuevej.setImageDrawable(null);

                squirtleGana = false;
                meowGana = false;
                cronometroj.setText("00:00");
                jugador1j.setText("");
                jugador2j.setText("");

                for (int i = 0; i <=8; i++) {
                    espacios [i] = 0;
                }
            }
        },3000);
    }
}
