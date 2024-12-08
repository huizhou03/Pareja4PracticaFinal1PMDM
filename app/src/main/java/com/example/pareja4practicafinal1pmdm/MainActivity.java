package com.example.pareja4practicafinal1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView pantalla1;
    private TextView titulo;
    private Button botonCrear;
    private EditText nombre;
    private ArrayList<String> seleccionHabilidades = new ArrayList<>();
    private ArrayList<Integer> seleccionEstadisticas = new ArrayList<>();
    private ArrayList<String> tipoEstadistica = new ArrayList<>();
    ActivityResultLauncher<Intent> startForLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getData() != null) {
                String nombreReal = result.getData().getStringExtra("nombreReal");
                String nombreJugador = result.getData().getStringExtra("nombreJugador");
                String oficio = result.getData().getStringExtra("oficio");
                seleccionHabilidades = result.getData().getStringArrayListExtra("seleccionHabilidades");
                seleccionEstadisticas = result.getData().getIntegerArrayListExtra("seleccionEstadisticas");
                tipoEstadistica = result.getData().getStringArrayListExtra("tipoEstadistica");

                Log.d("MainActivity2", "Nombre del jugador: " + nombreReal);
                Log.d("MainActivity2", "Nombre del personaje: "+ nombreJugador);
                Log.d("MainActivity2", "Oficio del jugador: "+ oficio);
                if(seleccionHabilidades != null){
                    for (String habilidades: seleccionHabilidades) {
                        Log.d("MainActivity2", "Habilidades recibidas: "+ habilidades);
                    }
                }else{
                    Log.d("MainActivity2", "No se recibieron habilidades.");
                }
                if(seleccionEstadisticas != null){
                    for(int i = 0; i< seleccionEstadisticas.size(); i++){
                        Log.d("MainActivity2", "Estadísticas recibidas: "+ tipoEstadistica.get(i) + ": " + seleccionEstadisticas.get(i));
                    }
                }else{
                    Log.d("MainActivity2", "No se recibieron estadísticas.");
                }

            }else{
                Log.d("MainActivity2", "Intent de resultado es nulo.");
            }
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
        nombre = findViewById(R.id.EditTextTextNombre);

        String nombre = getIntent().getStringExtra("nombreReal");
        if(nombre == null){
            Toast.makeText(this, "Por favor, introduce un nombre", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
        }
    }
    public void crearPersonaje(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("nombreReal", nombre.getText().toString());
        startForLauncher.launch(intent);
        nombre.setText("");
    }

}