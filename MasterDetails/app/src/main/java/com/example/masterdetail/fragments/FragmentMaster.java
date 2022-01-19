package com.example.masterdetail.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.masterdetail.R;

import java.util.ArrayList;

public class FragmentMaster extends Fragment{

    private View view;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList datos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_master, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listView = view.findViewById(R.id.lista_master);
        datos = new ArrayList<>();
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, datos);
        for (int i = 0; i < 100; i++) {

        }
    }
}
