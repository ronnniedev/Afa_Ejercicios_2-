package com.example.actdos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText textNombre;
    private Button botonSalida;
    private Button botonWeb;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        /*
        Creacion del boton
         */
        setContentView(R.layout.activity_main);
        botonWeb = (Button)findViewById(R.id.botonWeb);
        botonSalida = (Button)findViewById(R.id.botonSalida);

        botonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.google.es/"));
                //Añadimos la informacion al intent
                startActivity(intent);
            }
        });
        
        /*
        Listener que monitoriza si clickeamos en el boton
         */
        botonSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putString("Saludos ",textNombre.getText().toString());
                Intent salida = new Intent(MainActivity.this,SaludoActivity.class);
                //Añadimos la informacion al intent
                salida.putExtras(b);
                startActivity(salida);
            }
        });

    }
}