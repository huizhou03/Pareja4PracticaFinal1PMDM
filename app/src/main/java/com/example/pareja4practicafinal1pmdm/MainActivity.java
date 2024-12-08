package com.example.pareja4practicafinal1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView pantalla1;
    private TextView titulo;
    private Button botonCrear;
    ActivityResultLauncher<Intent> startForLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            String nombre = result.getData().getStringExtra("nombreDato");
        }
    });

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

        titulo = findViewById(R.id.TextViewTitular);
        pantalla1 = findViewById(R.id.TextView2Nombre);
        botonCrear = findViewById(R.id.BotonCrear);

        String nombre = getIntent().getStringExtra("NombreAutor");
        if(nombre == null){
            Toast.makeText(this, "Por favor, introduce un nombre", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
        }
    }
    public void crearPersonaje(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startForLauncher.launch(intent);
    }
}