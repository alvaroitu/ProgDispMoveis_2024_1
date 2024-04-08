package com.alvaroitu.aula_4_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView valorRecebido;
    String nomeRecebido;
    Integer idadeRecebido;
    Button botaoGoogle;
    Button botaoEmail;
    Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        valorRecebido = findViewById(R.id.textViewValorRecebido);
        botaoGoogle  = findViewById(R.id.buttonGoogle);
        botaoEmail = findViewById(R.id.buttonEmail);
        botaoVoltar = findViewById(R.id.buttonVoltar);

        Bundle dados = getIntent().getExtras();
        nomeRecebido = dados.getString("nome");
        idadeRecebido = dados.getInt("idade");

        valorRecebido.setText("Nome recebido: " + nomeRecebido + " idade recebida: " + idadeRecebido);

        botaoGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirNavegador = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.br"));
                startActivity(abrirNavegador);
            }
        });

        botaoEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirEmail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
                        "abc@gmail.com", null));
                abrirEmail.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
                abrirEmail.putExtra(Intent.EXTRA_TEXT, "BODY");
                startActivity(Intent.createChooser(abrirEmail, "Enviar email"));
            }
        });

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}