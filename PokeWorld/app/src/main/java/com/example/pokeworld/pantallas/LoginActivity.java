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

import com.example.pokeworld.MainActivity;
import com.example.pokeworld.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmail;
    private TextInputLayout txtContrasena;
    private Button btnLogin;
    private TextView labelRegistro;
    private FirebaseAuth mAuth;
    private String mCustomToken;
    FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseDatabase = FirebaseDatabase.getInstance("https://pokeworld-17508-default-rtdb.europe-west1.firebasedatabase.app/");
        txtEmail = findViewById(R.id.txt_email);
        txtContrasena = findViewById(R.id.txt_contrasena);
        labelRegistro = findViewById(R.id.label_registro);
        btnLogin = findViewById(R.id.btn_login);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            usuarioLogin();
        });

        labelRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistroActivity();
            }
        });
    }

    public void openRegistroActivity() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void usuarioLogin() {
        String email = txtEmail.getText().toString();
        String contrasena = txtContrasena.getEditText().getText().toString();

        if (TextUtils.isEmpty(email)){
            txtEmail.setError("Ingrese un correo");
            txtEmail.requestFocus();
        }else if (TextUtils.isEmpty(contrasena)){
            Toast.makeText(LoginActivity.this, "Ingrese una contrase??a", Toast.LENGTH_SHORT).show();
            txtContrasena.requestFocus();
        }else {

            mAuth.signInWithEmailAndPassword(email,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Bienvenid@", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                    }else {
                        Log.w("TAG", "Error", task.getException());
                    }
                }
            });

        }

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {

    }




}
