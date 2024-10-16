package com.example.filmotecafinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button boton_uno;
    private Button boton_dos;
    private Button boton_tres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boton_uno = (Button) findViewById(R.id.boton_uno);

        boton_uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accesoWeb = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.movistar.es/"));
                startActivity(accesoWeb);
            }
        });

        boton_dos = (Button) findViewById(R.id.boton_dos);

        boton_dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent correo = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("mailto:veronicapersonal1995@gmail.com"));
                startActivity(correo);
            }
        });

        boton_tres = (Button) findViewById(R.id.boton_tres);

        boton_tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}