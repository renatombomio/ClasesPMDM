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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.protobuf.DescriptorProtos;

public class Login extends AppCompatActivity {

    Button btn_inicio;
    private EditText correoL, contrasenaL;
    private TextView recuperar, registro;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        correoL = findViewById(R.id.txt_email);
        contrasenaL = findViewById(R.id.txt_contrasena);
        recuperar = findViewById(R.id.label_olvido);
        registro = findViewById(R.id.label_registro);
        btn_inicio = findViewById(R.id.btn_login);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openRegistroActivity();}

        });

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoLogin = correoL.getText().toString().trim();
                String contraLogin = contrasenaL.getText().toString().trim();

                if (correoLogin.isEmpty() &&contraLogin.isEmpty()){
                    Toast.makeText(Login.this, "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else {
                    loginUsuario (correoLogin, contraLogin);
                }
            }

            private void loginUsuario(String correoLogin, String contraLogin) {
                mAuth.signInWithEmailAndPassword(correoLogin, contraLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()) {
                          finish();
                          startActivity(new Intent(Login.this, MainActivity.class));
                          Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                      }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void openRegistroActivity() {
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
    }
}