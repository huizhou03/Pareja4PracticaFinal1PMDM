package com.example.pareja4practicafinal1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private TextView TVFuerza = findViewById(R.id.Fuerza);
    private TextView TVDestreza= findViewById(R.id.Destreza);
    private TextView TVConstrucion = findViewById(R.id.Constitucion);
    private TextView TVInteligencia = findViewById(R.id.Inteligencia);
    private  TextView TVSabiduria = findViewById(R.id.Sabiduria);
    private TextView TVCarisma = findViewById(R.id.Carisma);

    private ImageView DadoF [] = {findViewById(R.id.Dado1F), findViewById(R.id.Dado2F), findViewById(R.id.Dado3F)};
    private ImageView DadoD [] = {findViewById(R.id.Dado1D), findViewById(R.id.Dado2D), findViewById(R.id.Dado3D)};
    private ImageView DadoC [] = {findViewById(R.id.Dado1C), findViewById(R.id.Dado2C), findViewById(R.id.Dado3C)};
    private ImageView DadoI [] = {findViewById(R.id.Dado1I), findViewById(R.id.Dado2I), findViewById(R.id.Dado3I)};
    private ImageView DadoS [] = {findViewById(R.id.Dado1S), findViewById(R.id.Dado2S), findViewById(R.id.Dado3S)};
    private ImageView DadoCA [] = {findViewById(R.id.Dado1CA), findViewById(R.id.Dado2CA), findViewById(R.id.Dado3CA)};

    private Button BotonF = findViewById(R.id.B1);
    private Button BotonFD = findViewById(R.id.B2);
    private Button BotonC = findViewById(R.id.B3);
    private Button BotonI = findViewById(R.id.B4);
    private Button BotonS = findViewById(R.id.B5);
    private Button BotonCA = findViewById(R.id.B6);

    private TextView ResultadoF = findViewById(R.id.ResultadoF);
    private TextView ResultadoD = findViewById(R.id.ResultadoD);
    private TextView ResultadoC= findViewById(R.id.ResultadoC);
    private TextView ResultadoI = findViewById(R.id.ResultadoI);
    private TextView ResultadoS = findViewById(R.id.ResultadoS);
    private TextView ResultadoCA = findViewById(R.id.ResultadoCA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    int numero1 = 0;
    int numero2 = 0;
    int numero3 = 0;
    int numero4 = 0;
    int numero5 = 0;
    int numero6 = 0;
    int salir = 0;

    public final int ImagenDado [] = {R.mipmap.dado1, R.mipmap.dado2, R.mipmap.dado3, R.mipmap.dado4, R.mipmap.dado5, R.mipmap.dado6};
}