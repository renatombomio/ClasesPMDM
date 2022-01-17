package com.example.peticionesjson.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peticionesjson.R;

public class FragmentLista extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_lista, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart (){
        super.onStart();
        instancias();
    }

    private void instancias() {
        recyclerView = view.findViewById(R.id.lista_equipo);
    }
}
