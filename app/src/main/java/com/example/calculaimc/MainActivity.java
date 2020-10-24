package com.example.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
            Double valorPeso = nf.parse(peso.getText().toString()).doubleValue();
            Double valorAltura = nf.parse(altura.getText().toString()).doubleValue();
            Double result;
            if (Locale.getDefault().getLanguage() == "en") {
                result = (valorPeso * 703) / (Math.pow(valorAltura, 2));
            } else {
                result = valorPeso / (Math.pow(valorAltura, 2));
            }
            imcResult.setText(nf.format(result));

        } catch (ParseException ex) {
            ex.printStackTrace();
            Toast.makeText(this, R.string.informe_valores_validos, Toast.LENGTH_SHORT).show();
        }

    }

    public void limpar(View v) {
        peso.getText().clear();
        altura.getText().clear();
        imcResult.setText(R.string.zeros);
    }
}