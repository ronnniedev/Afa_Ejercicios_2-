package com.example.filmotecafinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FilmDataActivity extends AppCompatActivity {

    private Button botonEditar;
    private Button volverPrincipal;
    private TextView nombrePelicula;
    private ImageView filmView;
    private List<String> listFilms = Arrays.asList("regreso al futuro","el padrino");
    private int drawableId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_film_data);

        Bundle bundle = this.getIntent().getExtras();

        String pelicula = bundle.get("Nombre_Pelicula").toString();

        nombrePelicula = (TextView) findViewById(R.id.contenedorPelicula);

        filmView = (ImageView) findViewById(R.id.imagenPelicula);



        switch (pelicula.toLowerCase()){
            case "regreso al futuro":
                filmView.setImageResource(R.drawable.regreso);
                drawableId = R.drawable.regreso;
                nombrePelicula.setText("Regreso al futuro");
                break;
            case "el padrino":
                filmView.setImageResource(R.drawable.elpadrino);
                drawableId = R.drawable.elpadrino;
                nombrePelicula.setText("El padrino");
                break;
            default:
                break;
                }

        botonEditar = (Button) findViewById(R.id.editarPelicula);


        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moverse =
                        new Intent(FilmDataActivity.this,FilmEditActivity.class);
                moverse.putExtra("imagen",drawableId);
                startActivityForResult(moverse, 1);
            }
        });

        volverPrincipal = (Button) findViewById(R.id.volverPrincipal);

        volverPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moverse =
                        new Intent(FilmDataActivity.this,FilmListActivity.class);
                startActivity(moverse);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            nombrePelicula.setText("Guardado con exito");
        }else{
            nombrePelicula.setText("Cancelado el guardado");
        }
    }
}