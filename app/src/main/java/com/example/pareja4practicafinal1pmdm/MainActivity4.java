package com.example.pareja4practicafinal1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Queue;

public class MainActivity4 extends AppCompatActivity {
    private ArrayList<CheckBox> listaHabilidades = new ArrayList<>();
    private ArrayList<String> seleccion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listaHabilidades.add(findViewById(R.id.Atletismo));
        listaHabilidades.add(findViewById(R.id.Acrobacias));
        listaHabilidades.add(findViewById(R.id.JuegoDeManos));
        listaHabilidades.add(findViewById(R.id.Sigilo));
        listaHabilidades.add(findViewById(R.id.Arcano));
        listaHabilidades.add(findViewById(R.id.Historia));
        listaHabilidades.add(findViewById(R.id.Investigacion));
        listaHabilidades.add(findViewById(R.id.Naturaleza));
        listaHabilidades.add(findViewById(R.id.Religion));
        listaHabilidades.add(findViewById(R.id.Medicina));
        listaHabilidades.add(findViewById(R.id.Percepcion));
        listaHabilidades.add(findViewById(R.id.Perspicacia));
        listaHabilidades.add(findViewById(R.id.Supervivencia));
        listaHabilidades.add(findViewById(R.id.TratoConAnimales));
        listaHabilidades.add(findViewById(R.id.deception));
        listaHabilidades.add(findViewById(R.id.Intimidacion));
        listaHabilidades.add(findViewById(R.id.Interpretacion));
        listaHabilidades.add(findViewById(R.id.Persuasion));

        for (CheckBox checkBox: listaHabilidades) {
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                int contador = contarCheck();
                if (contador == 3){
                    Intent intent = new Intent();
                    intent.putExtra("seleccionHabilidades", seleccion);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }
    public int contarCheck(){
        int contador = 0;
        for (CheckBox checkBox : listaHabilidades) {
            if (checkBox.isChecked()){
                contador++;
            }
        }
        return contador;
    }
    public void seleecionHabilidades(View view){
        for (CheckBox checkBox : listaHabilidades) {
            if (checkBox.isChecked()){
                seleccion.add(checkBox.getText().toString());
            }
        }
    }
}