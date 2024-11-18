package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

public class Saludo extends AppCompatActivity {
    Button botonAccion;
    TextView tSaludo;
    ImageView visionadorImagen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saludo);

        Bundle b = this.getIntent().getExtras();

        tSaludo = (TextView) findViewById(R.id.tSaludo);
        tSaludo.setText("Hola " + b.get("Nombre").toString());

        botonAccion = (Button) findViewById(R.id.bImplicito);
        visionadorImagen = (ImageView) findViewById(R.id.iMostrarImagen);

        botonAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recogerImagen = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(recogerImagen,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            // data get data recoger el uri obtenido en la action
            visionadorImagen.setImageURI(data.getData());
        }
    }
}