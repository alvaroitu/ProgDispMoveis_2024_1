package com.alvaroitu.aula_4_intents;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText idade;
    Button salvar;
    TextView valoresSalvos;
    Button enviar;
    String nomeSalvo;
    Integer idadeSalva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextNome);
        idade = findViewById(R.id.editTextIdade);
        salvar = findViewById(R.id.buttonSalvar);
        valoresSalvos = findViewById(R.id.textViewValoresSalvos);
        enviar = findViewById(R.id.buttonEnviar);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nomeSalvo = nome.getText().toString();
                    idadeSalva = Integer.parseInt(idade.getText().toString());
                    valoresSalvos.setText("Nome: " + nomeSalvo + " idade: " + idadeSalva);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Entre com valores",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nome",nomeSalvo);
                intent.putExtra("idade", idadeSalva);
                startActivity(intent);
            }
        });
    }
}