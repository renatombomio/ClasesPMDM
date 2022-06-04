package com.example.animados.pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animados.MainActivity;
import com.example.animados.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    Button btn_register;
    private EditText nombre, correo, contrasena, numero;
    private TextView inicio;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        nombre = findViewById(R.id.txt_nombreR);
        correo = findViewById(R.id.txt_correoR);
        contrasena = findViewById(R.id.txt_contrasenaR);
        numero = findViewById(R.id.txt_numeroR);
        btn_register = findViewById(R.id.btn_registro);
        inicio = findViewById(R.id.lbl_login);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openLoginActivity();}

        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = nombre.getText().toString().trim();
                String correoUsuario = correo.getText().toString().trim();
                String contraUsuario = contrasena.getText().toString().trim();
                String numeroUsuario = numero.getText().toString().trim();

                if (nombreUsuario.isEmpty() && correoUsuario.isEmpty() &&contraUsuario.isEmpty() && numeroUsuario.isEmpty()){
                    Toast.makeText(Registro.this, "Complete los datos", Toast.LENGTH_SHORT).show();
                }else {
                    registroUsuario(nombreUsuario, correoUsuario, contraUsuario, numeroUsuario);
                }

            }

            private void registroUsuario(String nombreUsuario, String correoUsuario, String contraUsuario, String numeroUsuario) {
                mAuth.createUserWithEmailAndPassword(correoUsuario, contraUsuario).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String id = mAuth.getCurrentUser().getUid();
                        Map <String, Object> map = new HashMap<>();
                        map.put("id", id);
                        map.put("nombre", nombreUsuario);
                        map.put("correo", correoUsuario);
                        map.put("numero", numeroUsuario);
                        map.put("contraseña", contraUsuario);

                        firebaseFirestore.collection("Usuarios").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                finish();
                                startActivity(new Intent(Registro.this, MainActivity.class));
                                Toast.makeText(Registro.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Registro.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Registro.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }

    private void openLoginActivity(){
        Intent intent = new Intent(Registro.this, Login.class);
        startActivity(intent);
    }
}