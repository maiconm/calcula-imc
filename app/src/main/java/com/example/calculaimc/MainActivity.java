package com.example.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText peso;
    EditText altura;
    TextView imcResult;
    Button btnCalcular;
    Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        imcResult = findViewById(R.id.imcResult);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
    }

    public void calcular(View v) {
        try {
            Double valorPeso = Double.parseDouble(peso.getText().toString());
            Double valorAltura = Double.parseDouble(altura.getText().toString());
            Double imc = valorPeso / (Math.pow(valorAltura, 2));
            imcResult.setText(imc.toString());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            Toast.makeText(this, R.string.informe_valores_validos, Toast.LENGTH_SHORT).show();
        }

    }

    public void limpar(View v) {
        peso.getText().clear();
        altura.getText().clear();
        imcResult.setText("0.0");
    }
}