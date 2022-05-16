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


        //(Para cambiar el color del icono)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        setContentView(R.layout.activity_login);
    }

    public void onLoginClick (View view){
        startActivity(new Intent(this, RegistroActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }

}