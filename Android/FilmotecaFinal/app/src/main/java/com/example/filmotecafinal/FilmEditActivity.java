package com.example.filmotecafinal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FilmEditActivity extends AppCompatActivity {

    private Button botonGuardar;
    private Button botonCancelar;
    private ImageView imagenPelicula;
    private int drawableId;
    private Spinner spinner;

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

        spinner = (Spinner) findViewById(R.id.vueltas);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSeleccionado = (String) adapterView.getItemAtPosition(i);

                Toast.makeText(FilmEditActivity.this,itemSeleccionado
                        , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(FilmEditActivity.this,"nada"
                        , Toast.LENGTH_LONG).show();
            }
        });




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