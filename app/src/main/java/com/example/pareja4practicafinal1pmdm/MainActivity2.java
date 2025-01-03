package com.example.pareja4practicafinal1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class MainActivity2 extends AppCompatActivity {
    private EditText nombreJugador;
    private Spinner clases;
    private Button habilidades;
    private Button estadisticas;
    private ArrayList<String> seleccionHabilidades = new ArrayList<>();
    private ArrayList<Integer> seleccionEstadisticas = new ArrayList<>();
    private ArrayList<String> tipoEstadistica = new ArrayList<>();
    private int[] imagenesJobs = {R.drawable.mago, R.drawable.brujo, R.drawable.explorador, R.drawable.monje, R.drawable.hechicero, R.drawable.barbaro, R.drawable.guerrero, R.drawable.paladin, R.drawable.druida, R.drawable.bardo, R.drawable.clerigo, R.drawable.picaro};
    String[] jobs = {"Mago", "Brujo", "Explorador", "Monje", "Hechicero", "Barbaro", "Guerrero", "Paladín", "Druida", "Bardo", "Clerigo", "Pícaro"};
    ActivityResultLauncher<Intent> startForLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            seleccionHabilidades = result.getData().getStringArrayListExtra("seleccionHabilidades");
        }
    });
    ActivityResultLauncher<Intent> startForLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            seleccionEstadisticas = result.getData().getIntegerArrayListExtra("seleccionEstadisticas");
            tipoEstadistica = result.getData().getStringArrayListExtra("tipoEstadistica");
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombreJugador = findViewById(R.id.nombrePersonaje);
        estadisticas = findViewById(R.id.estadisticas);
        habilidades = findViewById(R.id.habilidades);
        String nombreReal = getIntent().getStringExtra("nombreReal");
        JobsAdapter adaptador = new JobsAdapter(this, imagenesJobs, jobs);
        clases = findViewById(R.id.spinner);
        clases.setAdapter(adaptador);
    }
    public void guardarPersonaje(View view){
        Intent intent = new Intent();
        String nombreReal = getIntent().getStringExtra("nombreReal");
        intent.putExtra("nombreReal", nombreReal.toString());
        intent.putExtra("nombreJugador", nombreJugador.getText().toString());
        intent.putExtra("oficio", jobs[clases.getSelectedItemPosition()]);
        intent.putExtra("seleccionHabilidades", seleccionHabilidades);
        intent.putExtra("tipoEstadistica", tipoEstadistica);
        intent.putExtra("seleccionEstadisticas", seleccionEstadisticas);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void habilidades(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
        startForLauncher.launch(intent);
        habilidades.setEnabled(false);
        habilidades.setVisibility(View.GONE);
    }
    public void estadisticas(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
        startForLauncher1.launch(intent);
        estadisticas.setEnabled(false);
        estadisticas.setVisibility(View.GONE);
    }
}
class JobsAdapter extends BaseAdapter {
    private MainActivity2 mainActivity2;
    private int[] imagenesJobs;
    private String[] jobs;

    public JobsAdapter(MainActivity2 mainActivity2, int[] imagenesJobs, String[] jobs) {
        this.mainActivity2 = mainActivity2;
        this.imagenesJobs = imagenesJobs;
        this.jobs = jobs;
    }

    @Override
    public int getCount() {
        return jobs.length;
    }

    @Override
    public Object getItem(int i) {
        return jobs[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mainActivity2).inflate(R.layout.spinner_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);
        imageView.setImageResource(imagenesJobs[position]);
        textView.setText(jobs[position]);
        return convertView;
    }
    /*
    Es un método que reutiliza la lógica del método anterior que es la vista del spinner y lo que
    podemos hacer con este método es facilitar la personlaizacion posterior de los huecos en el interior del spinner.
    */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}