package com.example.pokeworld.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokeworld.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    private EditText txtUsuario, txtNumero;
    private EditText txtCorreo;
    private TextInputLayout txtContrasena;
    private Button btnRegistro;
    private TextView labelLogin;

    private String usuarioID;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtUsuario = findViewById(R.id.txt_nombreR);
        txtCorreo = findViewById(R.id.txt_emailR);
        txtNumero = findViewById(R.id.txt_numeroR);
        txtContrasena = findViewById(R.id.txt_contrasenaR);
        btnRegistro = findViewById(R.id.btn_registroR);
        labelLogin = findViewById(R.id.lbl_loginClaseR);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        btnRegistro.setOnClickListener(view -> {
            crearUsuario();
        });

        labelLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLoginActivity();
            }
        });

    }


    public void abrirLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void crearUsuario() {

        String name = txtUsuario.getText().toString();
        String mail = txtCorreo.getText().toString();
        String phone = txtNumero.getText().toString();
        String password = txtContrasena.getEditText().getText().toString();

        if (TextUtils.isEmpty(name)) {
            txtUsuario.setError("Ingrese un Nombre");
            txtUsuario.requestFocus();
        } else if (TextUtils.isEmpty(mail)) {
            txtCorreo.setError("Ingrese un Correo");
            txtCorreo.requestFocus();
        } else if (TextUtils.isEmpty(phone)) {
            txtNumero.setError("Ingrese un Teléfono");
            txtNumero.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            txtContrasena.setError("Ingrese una Contraseña");
            txtContrasena.requestFocus();
        } else {

            mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        usuarioID = mAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = db.collection("usuarios").document(usuarioID);



                        Map<String, Object> user = new HashMap<>();
                        user.put("Nombre", name);
                        user.put("Correo", mail);
                        user.put("Teléfono", phone);
                        user.put("Contraseña", password);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d("TAG", "onSucces: Datos registrados" + usuarioID);
                            }
                        });
                        Toast.makeText(RegistroActivity.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(RegistroActivity.this, "Usuario no registrado" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
