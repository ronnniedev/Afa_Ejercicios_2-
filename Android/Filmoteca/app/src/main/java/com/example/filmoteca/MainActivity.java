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
    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnEntrar =(Button) findViewById(R.id.boton_tres);
        btnWeb = (Button) findViewById(R.id.boton_uno);
        txtNombre = (EditText) findViewById(R.id.nameText);

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