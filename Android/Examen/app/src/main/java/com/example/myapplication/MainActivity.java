package com.example.myapplication;

import android.content.Intent;
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

    EditText tNombre;
    Button bIrSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tNombre = (EditText) findViewById(R.id.eNombre);
        bIrSaludo = (Button) findViewById(R.id.BotonEntrarSaludo);

        bIrSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent moverse = new Intent(MainActivity.this,Saludo.class);
                    String nombre = tNombre.getText().toString();
                    Bundle b = new Bundle();
                    b.putString("Nombre",nombre);
                    moverse.putExtras(b);
                    startActivity(moverse);
            }
        });

    }
}