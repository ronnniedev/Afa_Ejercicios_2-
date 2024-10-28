package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class SaludoActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView texto;
    private Button bVolver;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saludo);

        Bundle bundle = this.getIntent().getExtras();

        texto = (TextView) findViewById(R.id.contenedorSaludo);
        texto.setText("hola " + bundle.getString("saludo"));
        bVolver = (Button) findViewById(R.id.camara);
        imagen = (ImageView) findViewById(R.id.imagenView);

        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCamara = new Intent(Intent.ACTION_PICK
                        , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(abrirCamara,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && data != null){
            imagen.setImageURI(data.getData());
        }
    }
}