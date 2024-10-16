package com.example.filmotecafinal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FilmEditActivity extends AppCompatActivity {

    private Button botonGuardar;
    private Button botonCancelar;
    private ImageView imagenPelicula;
    private int drawableId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_film_edit);

        Bundle bundle = this.getIntent().getExtras();

        imagenPelicula = (ImageView) findViewById(R.id.imagenPeliculaEdit);

        botonGuardar = (Button) findViewById(R.id.guardarFilm);

        imagenPelicula.setImageDrawable(getResources().getDrawable(bundle.getInt("imagen")));

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(FilmEditActivity.RESULT_OK);
                finish();

            }
        });

        botonCancelar = (Button) findViewById(R.id.cancelar);

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(FilmEditActivity.RESULT_CANCELED);
                finish();
            }
        });

    }


}