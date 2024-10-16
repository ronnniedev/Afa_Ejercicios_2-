package com.example.filmoteca;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnWeb;
    private Button salir;
    private Button email;
    private EditText txtNombre;
    private Button botonEjercicios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //btnEntrar =(Button) findViewById(R.id.boton_tres);
        btnWeb = (Button) findViewById(R.id.boton_uno);
        email = (Button) findViewById(R.id.boton_dos);
        salir = (Button) findViewById(R.id.boton_tres);
        // botonEjercicios = (Button) findViewById(R.id.boton_dos);
        txtNombre = (EditText) findViewById(R.id.nameText);

        /**
         * Comparte un texto via cualquiera app escogida por el usuario
         */
        /*
         * botonEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ejercicio = new Intent(Intent.ACTION_SEND);
                ejercicio.setType("text/plain");
                startActivity(ejercicio);
                ejercicio.putExtra(Intent.EXTRA_TEXT,"Este es el texto a compartir");
                startActivity(Intent.createChooser(ejercicio,"Compartir via: "));
            }
        });
         */

        /**
         * Crea una nueva actividad donde saludara con el nombre introducido en la caja de texto
         */
        /*
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b =  new Bundle();
                b.putString("NOMBRE",txtNombre.getText().toString());
                Intent abrirSaludo = new Intent(MainActivity.this,SaludoActivity.class);
                abrirSaludo.putExtras(b);
                startActivity(abrirSaludo);
            }
        });
         */

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent correo = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("mailto:correoaqui"));
                startActivity(correo);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        /* visita una pagina web al darle click al boton deseado
         */
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accesoWeb = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.movistar.es/"));
                startActivity(accesoWeb);
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}