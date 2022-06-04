package com.example.animados;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.animados.adaptador.RecyclerAdapter;
import com.example.animados.pantallas.AnadirActivity;
import com.example.animados.pantallas.PerfilActivity;
import com.example.animados.utils.ItemLista;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView listaMascotas;
    private RecyclerAdapter adapter;
    private List<ItemLista> items;
    private SearchView searchView;

    BottomNavigationView bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarLista();
        iniciarValores();
        searchView.setOnQueryTextListener(this);

        bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.inicio:
                        return true;
                    case R.id.añadir:
                        startActivity(new Intent(getApplicationContext(), AnadirActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void mostrarToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }



    private void iniciarLista() {
        listaMascotas = findViewById(R.id.mascotasLista);
        searchView = findViewById(R.id.buscador);
    }

    private void iniciarValores(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(manager);

        items = getItems();
        adapter= new RecyclerAdapter(items, getApplicationContext());
        listaMascotas.setAdapter(adapter);
    }



    private List <ItemLista> getItems(){
        List <ItemLista> itemListas = new ArrayList<>();
        itemListas.add(new ItemLista("Garp","En adopción","Macho", "21kg","Mestizo","Coslada, Madrid", "3 años",R.drawable.garp,"es un mestizo de Gran Danes de 3 años. Macho, castrado en adopcion.\n" +
                "Es muy sociable con personas y niños, con perros tampoco tiene problemas auqnue es un perro mas apegado a los humanos.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Nala","En adopción","Hembra", "200g","Mestiza","Leganés, Madrid", "2 meses",R.drawable.nala, "Es una gatita de unos 2 meses. Es sociable y rescatada de la calle aunque ya esta desparasitada y vacunada.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Pirata","Busca pareja","Macho", "4kg","Mestizo","Las matas, Madrid", "3 años",R.drawable.pirata,"Es un macho y tiene aproximadamente tres años. Ya ha convivido con otros gatos, le gusta mucho jugar y es bastante cariñoso.","jorge_andres_98@gmail.com","717169456"));
        itemListas.add(new ItemLista("Mina","Busca pareja","Hembra", "28kg","Labrador","Torrejón de ardoz, Madrid", "3 años",R.drawable.mina,"Busca novio","jenniferdelpiero@hotmail.com","666745389"));
        itemListas.add(new ItemLista("Lola","En adopción","Hembra", "12kg","Husky Siberiano","Sabadell, Barcelona", "6 meses",R.drawable.lola,"Hace seis esta con nosotros sin tener exito. Es una perra muy alegre y de unos 12 kg.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Jagger","En adopción","Macho", "400g","Mestizo","Alcorcón, Madrid", "6 meses",R.drawable.jagger,"En adopción! Unos 6 meses, chico mimoso y muy sociable.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Lucy","Busca pareja","Hembra", "2kg","Mestiza","Aracena, Huelva", "2 años", R.drawable.lucy,"Buscamos pareja para tener crias y quedarnoslos","Alvaroiglesiasg@gmai.com","654702157"));
        itemListas.add(new ItemLista("Simba","En adopción","Macho", "3kg","Mestizo","Cazalla, Sevilla", "2 años", R.drawable.simba,"2 años, cariñoso y mimoso, necesito una familia.\n" +
                "Me adoptas?","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Atom","Busca pareja","Macho", "24kg","Galgo","Cazalla, Sevilla", "2 años", R.drawable.atom,"Monta a cambio de algún cachorro o dinero","gutiale1998@gmail.com","670900346"));
        itemListas.add(new ItemLista("Tiza","En adopción","Hembra", "25kg","Mestiza","Cazalla, Sevilla", "2 años", R.drawable.tiza,"tiene 2 años, es una bonachona que es bien grandota, como para dar mimos muy gordos y grandes.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Norton","En adopción","Macho", "27kg","Mestizo","Alcalá de henares, Madrid", "4 meses", R.drawable.norton,"Es el perro más guapo y menos deseado del Refugio. Para todo muy guapo y para nadie es deseado.\n" +
                "Es sociable con perros y personas, ya le habéis visto muchas veces. Nos gustaría una familia con jardín porque aunque no es que sea muy activo, creo q no es un perro para mimar en sofá","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Nieve","Busca pareja","Hembra", "5kg","Mestiza","Fuenlabrada, Madrid", "4 años", R.drawable.nieve,"La separaron de sus crias, esta deprimida, buscamos pareja para que vuelva a tener crias ","adrialvarez95@gmail.com","665893168"));
        itemListas.add(new ItemLista("Oreo","En adopción","Macho", "3kg","Mestizo","Arroyomolinos, Madrid", "3 años", R.drawable.oreo,"Tiene 3 años, hemos estado trabajando el ultimo mes con mucha determinacion sus miedos. Esta mucho mas sociable aunque aún es asustadizo pero ya es cuestión de tiempo.\n" +
                "Pese a sus recelos le gusta mucho los mimos cuando coje confianza.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Milhouse","Busca pareja","Macho", "20kg","Border Collie","Griñón, Madrid", "3 años", R.drawable.milhouse,"Perro muy activo, atletico, busca novia","cris.arbol.provincia@gmail.com","681373389"));
        itemListas.add(new ItemLista("Koffee","Busca pareja","Hembra", "29kg","Mestiza","Elche, Alicante", "2 años",R.drawable.koffee,"Nunca ha tenidoo novio, buscamos novio con buena genetica","lorena.alons@gmail.com","645219760"));
        itemListas.add(new ItemLista("Greta","En adopción","Hembra", "200g","Mestiza","Elche, Alicante", "2 meses",R.drawable.greta,"Tiene 2 meses, es hembray esta esterilizada. Se han deshecho de ella como una basura. Busca un nuevo hogar y mucho cariño.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Mimi","Busca pareja","Hembra", "2,3kg","Mestiza","Lucena, Córdoba", "4 años", R.drawable.mimi,"Buscamos pareja para tener crías y regalarlos a familiares","leslie1998eu@gmail.com","633403788"));
        itemListas.add(new ItemLista("Nico","En adopción","Macho", "16kg","Podenco","Pozoblanco, Córdoba", "4 años", R.drawable.nico,"Un Podenco con algo de sintomas de excesiva timidez que nos habla de un trato cuestionable.\\n\" +\n" +
                "                \"Tendremos que estar un tiempo con ella para valorarle y equilibrarle.","vidaconperros@hotmail.com","916970810"));
        itemListas.add(new ItemLista("Cruella","Busca pareja","Hembra", "22kg","Mestiza","Colmenar, Madrid", "6 años", R.drawable.cruella,"Buscamo novio para tener camada de cachorros","emmanuelmbomio05@gmail.com","666709782"));
        itemListas.add(new ItemLista("Teo","Busca pareja","Macho", "4,7kg","Mestizo","Getafe, Madrid", "6 años", R.drawable.teo,"Buscamos pareja y repartirnos las crías, ya que queremos cuidar a uno o dos al menos","quevedocarmen@hotmail.com","699211092"));

        return itemListas;
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filtrado(newText);
        return false;
    }

}