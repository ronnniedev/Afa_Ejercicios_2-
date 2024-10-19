package com.example.filmotecafinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class FilmListActivity extends AppCompatActivity {

    private Button botonVerPelicula;
    private Button botonAcercaDe;
    private EditText contenedorTexto;
    private List<String> listFilms = Arrays.asList("regreso al futuro","el padrino");
    private TextView advertencia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fillm_list);

        botonVerPelicula = (Button) findViewById(R.id.verPelicula);
        contenedorTexto = (EditText) findViewById(R.id.campo_texto);
        advertencia = (TextView) findViewById(R.id.warning);

        botonVerPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pelicula = contenedorTexto.getText().toString();
                if(comprobarEnLista(pelicula)){
                    Intent moverse =
                            new Intent(FilmListActivity.this,FilmDataActivity.class);
                    Bundle b = new Bundle();
                    b.putString("Nombre_Pelicula", pelicula);
                    moverse.putExtras(b);
                    startActivity(moverse);
                }else{
                    advertencia.setText("Error: pelicula no encontrada");
                }

            }
        });

        botonAcercaDe = (Button) findViewById(R.id.acercaDe);

        botonAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moverse =
                        new Intent(FilmListActivity.this,MainActivity.class);
                startActivity(moverse);
            }
        });

    }

    public boolean comprobarEnLista(String pelicula){
        pelicula = pelicula.toLowerCase();

        for(String muestra: listFilms){
            if(muestra.compareTo(pelicula) == 0){
                return true;
            }
        }

    return false;
    }
}