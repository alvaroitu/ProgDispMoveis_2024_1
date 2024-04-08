package com.alvaroitu.aula_2_calculadora;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText valor1;
    EditText valor2;
    Button botaoSoma;
    Button botaoSub;
    Button botaoMulti;
    Button botaoDiv;
    TextView valorSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.numero1);
        valor2 = findViewById(R.id.numero2);
        botaoSoma = findViewById(R.id.soma);
        botaoSub = findViewById(R.id.sub);
        botaoMulti = findViewById(R.id.multi);
        botaoDiv = findViewById(R.id.div);
        valorSaida = findViewById(R.id.resultado);

        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double valorRecebido1 = Double.parseDouble(valor1.getText().toString());
                Double valorRecebido2 = Double.parseDouble(valor2.getText().toString());

                Double resultado = valorRecebido1 + valorRecebido2;

                valorSaida.setText("Valor da soma: " + resultado);
            }
        });

        botaoSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double valorRecebido1 = Double.parseDouble(valor1.getText().toString());
                Double valorRecebido2 = Double.parseDouble(valor2.getText().toString());

                Double resultado = valorRecebido1 - valorRecebido2;

                valorSaida.setText("Valor da subtração: " + resultado);

            }
        });

        botaoMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double valorRecebido1 = Double.parseDouble(valor1.getText().toString());
                Double valorRecebido2 = Double.parseDouble(valor2.getText().toString());

                Double resultado = valorRecebido1 * valorRecebido2;

                valorSaida.setText("Valor da multiplicação: " + resultado);

            }
        });

        botaoDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double valorRecebido1 = Double.parseDouble(valor1.getText().toString());
                Double valorRecebido2 = Double.parseDouble(valor2.getText().toString());

                if (valorRecebido2 == 0) {
                    Toast.makeText(MainActivity.this, "Não existe divisão por Zero", Toast.LENGTH_SHORT).show();
                } else {
                    Double resultado = valorRecebido1 / valorRecebido2;
                    valorSaida.setText("Valor da divisão: " + resultado);
                }
            }
        });
    }
}