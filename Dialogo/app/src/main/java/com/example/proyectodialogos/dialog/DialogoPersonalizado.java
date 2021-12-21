package com.example.proyectodialogos.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.dialogo.R;
import com.example.proyectodialogos.utils.Persona;

public class DialogoPersonalizado extends DialogFragment {

    private Context context;
    private View view;
    private Button botonLogin;
    private EditText editUser, editPass;
    private CheckBox checkSession;
    private OnDialogoPersoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.listener = (OnDialogoPersoListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_login,
                null,false);
        alertDialog.setView(view);
        instancias();
        acciones();
        return alertDialog.create();
    }

    private void acciones() {
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onPersonaSelected(new Persona("",""));
                //Toast.makeText(context,"Pulsado login", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }

    private void instancias() {
        botonLogin = view.findViewById(R.id.boton_login);
        editPass = view.findViewById(R.id.edit_pass);
        editUser = view.findViewById(R.id.edit_usuario);
        checkSession = view.findViewById(R.id.check_sesion);
    }

    /*@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialogo_login,null,false);
        return view;
    }*/

    public interface OnDialogoPersoListener{
        void onPersonaSelected(Persona persona);
    }
}
