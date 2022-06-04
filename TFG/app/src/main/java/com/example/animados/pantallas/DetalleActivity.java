package com.example.animados.pantallas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animados.R;
import com.example.animados.utils.ItemLista;

public class DetalleActivity extends AppCompatActivity {

    private ImageView imgDetalle;
    private TextView txtNombreDet, txtSexoDet, txtEdadDet, txtRazaDet, txtPesoDet, txtDescripcionDet, txtUbicacionDet, txtEmailDet, txtNumeroDet;
    private ItemLista itemDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle(getClass().getSimpleName());

        imgDetalle = findViewById(R.id.imgItemDetalle);
        txtNombreDet = findViewById(R.id.txt_nombreDetalle);
        txtSexoDet = findViewById(R.id.txt_sexoDetalle);
        txtEdadDet = findViewById(R.id.txt_edadDetalle);
        txtRazaDet = findViewById(R.id.txt_razaDetalle);
        txtPesoDet = findViewById(R.id.txt_pesoDetalle);
        txtUbicacionDet = findViewById(R.id.txt_ubicacionDetalle);
        txtEmailDet = findViewById(R.id.txt_emailDetalle);
        txtNumeroDet = findViewById(R.id.txt_numeroDetalle);


        imgDetalle.setImageResource(getIntent().getIntExtra("imgResource",0));
        txtNombreDet.setText(getIntent().getStringExtra("nombre"));
        txtSexoDet.setText(getIntent().getStringExtra("sexo"));
        txtEdadDet.setText(getIntent().getStringExtra("edad"));
        txtRazaDet.setText(getIntent().getStringExtra("raza"));
        txtPesoDet.setText(getIntent().getStringExtra("peso"));
        txtDescripcionDet.setText(getIntent().getStringExtra("descripcion"));
        txtUbicacionDet.setText(getIntent().getStringExtra("ubicacion"));
        txtEmailDet.setText(getIntent().getStringExtra("email"));
        txtNumeroDet.setText(getIntent().getStringExtra("numero"));

    }
}