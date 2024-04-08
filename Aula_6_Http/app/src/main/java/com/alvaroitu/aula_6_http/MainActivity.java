package com.alvaroitu.aula_6_http;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText textoDigitado;
    Button botaoRecuperar;
    TextView textoResultado;
    String paisBuscado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoDigitado = findViewById(R.id.textoDigitado);
        botaoRecuperar = findViewById(R.id.botaoRecuperar);
        textoResultado = findViewById(R.id.textoResultado);

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyTask task = new MyTask();
                String urlBlockChain = "https://blockchain.info/ticker";
                String cep = textoDigitado.getText().toString();
                String urlCep = "https://viacep.com.br/ws/" + cep + "/json/";
                task.execute(urlBlockChain);
            }
        });
    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;
            try {
                URL url = new URL(stringUrl);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                // Recupera os dados em Bytes
                inputStream = conexao.getInputStream();

                //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                inputStreamReader = new InputStreamReader( inputStream );

                //Objeto utilizado para leitura dos caracteres do InpuStreamReader
                BufferedReader reader = new BufferedReader( inputStreamReader );
                buffer = new StringBuffer();
                String linha = "";

                while((linha = reader.readLine()) != null){
                    buffer.append( linha );
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);

            String cep = null;
            String logradouro = null;
            String bairro = null;
            String localidade = null;
            String uf = null;
            String pais = null;
            String buy = null;
            String symbol = null;
            String info = null;
            String blockchain = null;

            try {
                JSONObject jsonObject = new JSONObject(resultado);
                cep = jsonObject.getString("cep");
                uf = jsonObject.getString("uf");
                logradouro = jsonObject.getString("logradouro");
                bairro = jsonObject.getString("bairro");
                localidade = jsonObject.getString("localidade");

//                pais = jsonObject.getString("BRL");
//                JSONObject jsonObject1 = new JSONObject(pais);
//                buy = jsonObject1.getString("buy");
//                symbol = jsonObject1.getString("symbol");
//                JSONObject objectPais = jsonObject.getJSONObject("BRL");
//                info = objectPais.getString("buy");



            } catch (JSONException e) {
                e.printStackTrace();
            }

//            textoResultado.setText(info);

            textoResultado.setText(logradouro + "\n" + bairro + "\n" +
                    localidade + "\n" + uf  + "\n" + cep );

        }
    }
}