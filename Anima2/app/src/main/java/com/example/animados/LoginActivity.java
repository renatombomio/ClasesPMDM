package com.example.animados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void onLoginClick (View view){
        startActivity(new Intent(this, RegistroActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }

}