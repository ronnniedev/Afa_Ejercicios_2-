package com.example.actdos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SaludoActivity extends AppCompatActivity {

    private Button botonVolver;
    private TextView textoSaludo;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saludo);
        botonVolver = (Button)findViewById(R.id.botonVolver);
        textoSaludo = (TextView) findViewById(R.id.textView);

        Bundle bundle = this.getIntent().getExtras();
        textoSaludo.setText("El nombre es: " + bundle.get("nombre"));
        /*
        Listener que monitoriza si clickeamos en el boton
         */
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(SaludoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}