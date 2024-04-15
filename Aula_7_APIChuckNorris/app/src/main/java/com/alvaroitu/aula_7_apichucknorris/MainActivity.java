package com.alvaroitu.aula_7_apichucknorris;

import android.os.AsyncTask;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
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


    LinearLayout linearLayout;
    Button botaoRecuperar;
    TextView textoResultado;
    ListView listCategories;
    String categoriaSelecionada;
    String[] categories = {"animal",
            "career",
            "celebrity",
            "dev",
            "explicit",
            "fashion",
            "food",
            "history",
            "money",
            "movie",
            "music",
            "political",
            "religion",
            "science",
            "sport",
            "travel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoRecuperar = findViewById(R.id.botaoRecuperar);
        textoResultado = findViewById(R.id.textoResultado);
        listCategories = findViewById(R.id.listCategories);
        linearLayout = findViewById(R.id.linearLayout);

        linearLayout.setBackgroundColor(getResources().getColor(R.color.black));

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                categories
        );

        listCategories.setAdapter(adaptador);

        listCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                categoriaSelecionada = listCategories.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, categoriaSelecionada, Toast.LENGTH_SHORT).show();
            }
        });

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyTask task = new MyTask();
                String chuckNorris = "https://api.chucknorris.io/jokes/random?category=" + categoriaSelecionada;
                Toast.makeText(MainActivity.this, chuckNorris, Toast.LENGTH_LONG).show();
                task.execute(chuckNorris);
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

            JSONArray categories = null;
            String value = null;

            try {
                JSONObject jsonObject = new JSONObject(resultado);
                categories = jsonObject.getJSONArray("categories");



            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                textoResultado.setText("Categoria: " + categories.getString(0) +
                        "\n Conselho: " + value);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}