package com.example.filmoteca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SaludoActivity extends AppCompatActivity {

    private Button volver;
    private TextView txtSaludo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saludo);

        volver = (Button) findViewById(R.id.volver);
        txtSaludo = (TextView)findViewById(R.id.saludo);
        Bundle b = this.getIntent().getExtras();
        txtSaludo.setText("Hola " + b.getString("NOMBRE"));
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volviendo =
                        new Intent(SaludoActivity.this,MainActivity.class);
                startActivity(volviendo);
            }
        });
    }
}