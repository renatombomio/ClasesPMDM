package com.example.animados.adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animados.R;
import com.example.animados.pantallas.DetalleActivity;
import com.example.animados.utils.ItemLista;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerHolder> {

    private List <ItemLista> items;
    public Context context;
    private List <ItemLista> listaOriginal;


    public RecyclerAdapter (List<ItemLista> items, Context context) {
        this.items = items;
        this.context = context;
        this.listaOriginal = new ArrayList<>();
        listaOriginal.addAll(items);
    }


    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_view, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, @SuppressLint("RecyclerView") int position) {
        final ItemLista item = items.get(position);
        holder.imgItemView.setImageResource(item.getImgResource());
        holder.pgNombre.setText(item.getNombre());
        holder.pgEstado.setText(item.getEstado());
        holder.pgSexo.setText(item.getSexo());
        holder.pgEdad.setText(item.getEdad());
        holder.pgPeso.setText(item.getPeso());
        holder.pgRaza.setText(item.getRaza());
        holder.pgUbicacion.setText(item.getUbicacion());
        holder.pgNumero.setText(item.getNumero());
        holder.pgEmail.setText(item.getEmail());


        holder.imgItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra("imgResource", items.get(position).getImgResource());
                intent.putExtra("nombre", items.get(position).getNombre());
                intent.putExtra("sexo", items.get(position).getSexo());
                intent.putExtra("peso", items.get(position).getPeso());
                intent.putExtra("raza", items.get(position).getRaza());
                intent.putExtra("descripcion", items.get(position).getDescripcion());
                intent.putExtra("ubicacion", items.get(position).getUbicacion());
                intent.putExtra("edad", items.get(position).getEdad());
                intent.putExtra("estado", items.get(position).getEstado());
                intent.putExtra("email", items.get(position).getEmail());
                intent.putExtra("numero", items.get(position).getNumero());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    public void filtrado(String textoBuscado){

        int longitud = textoBuscado.length();
        if (longitud == 0){
            items.clear();
            items.addAll(listaOriginal);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<ItemLista> coleccion = items.stream().filter(i -> i.getNombre().toLowerCase().contains(textoBuscado.toLowerCase())).collect(Collectors.toList());
                items.clear();
                items.addAll(coleccion);
            } else {
                    for (ItemLista c : listaOriginal) {
                        if (c.getNombre().toLowerCase().contains(textoBuscado.toLowerCase())) {
                            items.add(c);
                        }
                    }
                }
            }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItemView;
        private TextView pgNombre, pgSexo, pgEdad, pgPeso, pgRaza, pgUbicacion, pgEstado, pgNumero, pgEmail;

        public RecyclerHolder(@NonNull View itemView){
            super(itemView);
            imgItemView = itemView.findViewById(R.id.imgItem);
            pgNombre = itemView.findViewById(R.id.txt_nombreItem);
            pgEstado = itemView.findViewById(R.id.txt_estadoItem);
            pgSexo = itemView.findViewById(R.id.txt_sexoItem);
            pgEdad = itemView.findViewById(R.id.txt_edadItem);
            pgPeso = itemView.findViewById(R.id.txt_pesoItem);
            pgRaza = itemView.findViewById(R.id.txt_razaItem);
            pgUbicacion = itemView.findViewById(R.id.txt_ubicacionItem);
            pgNumero = itemView.findViewById(R.id.txt_numeroItem);
            pgEmail = itemView.findViewById(R.id.txt_emailItem);
        }
    }

}
