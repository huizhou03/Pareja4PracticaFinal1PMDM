package com.example.pareja4practicafinal1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTitular;
    private TextView textView2Nombre;
    private Button botonCrear;
    private EditText editTextTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewTitular = findViewById(R.id.TextViewTitular);
        textView2Nombre = findViewById(R.id.TextView2Nombre);
        botonCrear = findViewById(R.id.BotonCrear);
        editTextTextNombre = findViewById(R.id.EditTextTextNombre);
    }
    public void crearPersonaje(View view){
        Intent intent = new Intent();
        intent.putExtra("NombreAlumno", editTextTextNombre.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}