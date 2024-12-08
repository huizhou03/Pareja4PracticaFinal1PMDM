package com.example.pareja4practicafinal1pmdm;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    private TextView TVFuerza;
    private TextView TVDestreza;
    private TextView TVConstrucion;
    private TextView TVInteligencia;
    private TextView TVSabiduria;
    private TextView TVCarisma;

    private ImageView[] DadoF;
    private ImageView[] DadoD;
    private ImageView[] DadoC;
    private ImageView[] DadoI;
    private ImageView[] DadoS;
    private ImageView[] DadoCA;

    private Button BotonF;
    private Button BotonD;
    private Button BotonC;
    private Button BotonI;
    private Button BotonS;
    private Button BotonCA;

    private TextView ResultadoF;
    private TextView ResultadoD;
    private TextView ResultadoC;
    private TextView ResultadoI;
    private TextView ResultadoS;
    private TextView ResultadoCA;

    private ArrayList<Integer> resultados;
    public final int ImagenDado [] = {R.mipmap.dado1, R.mipmap.dado2, R.mipmap.dado3, R.mipmap.dado4, R.mipmap.dado5, R.mipmap.dado6};
    public  int contador = 0;

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

        TVFuerza = findViewById(R.id.Fuerza);
        TVDestreza= findViewById(R.id.Destreza);
        TVConstrucion = findViewById(R.id.Constitucion);
        TVInteligencia = findViewById(R.id.Inteligencia);
        TVSabiduria = findViewById(R.id.Sabiduria);
        TVCarisma = findViewById(R.id.Carisma);

        DadoF = new ImageView[]{findViewById(R.id.Dado1F), findViewById(R.id.Dado2F), findViewById(R.id.Dado3F)};
        DadoD = new ImageView[]{findViewById(R.id.Dado1D), findViewById(R.id.Dado2D), findViewById(R.id.Dado3D)};
        DadoC =  new ImageView[]{findViewById(R.id.Dado1C), findViewById(R.id.Dado2C), findViewById(R.id.Dado3C)};
        DadoI =  new ImageView[]{findViewById(R.id.Dado1I), findViewById(R.id.Dado2I), findViewById(R.id.Dado3I)};
        DadoS =  new ImageView[]{findViewById(R.id.Dado1S), findViewById(R.id.Dado2S), findViewById(R.id.Dado3S)};
        DadoCA =  new ImageView[]{findViewById(R.id.Dado1CA), findViewById(R.id.Dado2CA), findViewById(R.id.Dado3CA)};

        BotonF = findViewById(R.id.B1);
        BotonD = findViewById(R.id.B2);
        BotonC = findViewById(R.id.B3);
        BotonI = findViewById(R.id.B4);
        BotonS = findViewById(R.id.B5);
        BotonCA = findViewById(R.id.B6);

        ResultadoF = findViewById(R.id.ResultadoF);
        ResultadoD = findViewById(R.id.ResultadoD);
        ResultadoC= findViewById(R.id.ResultadoC);
        ResultadoI = findViewById(R.id.ResultadoI);
        ResultadoS = findViewById(R.id.ResultadoS);
        ResultadoCA = findViewById(R.id.ResultadoCA);

        //Configuramos listeners para los botones
        configurarListeners();
    };
    private void configurarListeners() {
        BotonF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            generarNumero(DadoF, ResultadoF, BotonF);
            }
        });
        BotonD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generarNumero(DadoD, ResultadoD, BotonD);
            }
        });
        BotonC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generarNumero(DadoC, ResultadoC, BotonC);
            }
        });
        BotonI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generarNumero(DadoI, ResultadoI, BotonI);
            }
        });
        BotonS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generarNumero(DadoS, ResultadoS, BotonS);
            }
        });
        BotonCA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                generarNumero(DadoCA, ResultadoCA, BotonCA);
            }
        });
    };

    public void generarNumero (ImageView[] dados, TextView resultado, Button boton){
        Random numeroAleatorio = new Random();
        int suma = 0;

        //Generamos valores de los dados
        for (ImageView dado : dados) {
            int valor = numeroAleatorio.nextInt(6) + 1; //Valores entre 6 y 1
            dado.setImageResource(ImagenDado[valor - 1]);
            suma += valor;
        }
        resultados.add(suma); // Guardamos el resultado
        resultado.setText(String.valueOf(suma)); // Mostramos resultado en la interfaz
        boton.setEnabled(false); // Desactivamos botón
        boton.setVisibility(View.GONE);
        contador++;
        mandarIntent(suma);
    }

    public void mandarIntent (int suma){
        if(contador == 6){
            Intent intent = new Intent();
            intent.putExtra("estadisticas", resultados);// Pasamos los resultados como array
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}