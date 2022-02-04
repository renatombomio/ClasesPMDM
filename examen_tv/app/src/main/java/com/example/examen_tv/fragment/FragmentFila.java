package com.example.examen_tv.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.examen_tv.R;
import com.example.examen_tv.utils.Juego;

public class FragmentFila extends Fragment {


    private View view;
    private TextView pregunta;
    private Juego preguntaRecuperada;


    public static FragmentFila newInstance(Juego juego){
        Bundle args = new Bundle();
        args.putSerializable("pregunta", juego);

        FragmentFila fragment = new FragmentFila();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments() != null){
            preguntaRecuperada = (Juego) this.getArguments().getSerializable("pregunta");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        initGUI();
    }

    private void initGUI() {
        pregunta.setText(preguntaRecuperada.getPregunta());
    }

    private void instancias() {
        pregunta =view.findViewById(R.id.pregunta_item);
    }

}
