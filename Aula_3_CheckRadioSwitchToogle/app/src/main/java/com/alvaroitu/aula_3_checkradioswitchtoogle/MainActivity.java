package com.alvaroitu.aula_3_checkradioswitchtoogle;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextSobrenome;
    Button buttonEnviar;
    Button buttonLimpar;
    TextView textViewResultado;

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    RadioGroup radioGroupSexo;
    RadioButton radioButtonSexo;
//    RadioButton radioButtonMasculino;
//    RadioButton radioButtonFeminino;

    Switch switchButton;
    ToggleButton toggleButton;
    TextView switchResultado;
    TextView toggleResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        textViewResultado = findViewById(R.id.textViewResultado);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
//        radioButtonMasculino = findViewById(R.id.radioButtonMasculino);
//        radioButtonFeminino = findViewById(R.id.radioButtonFeminino);

        switchButton = findViewById(R.id.switchButton);
        toggleButton = findViewById(R.id.toggleButton);
        switchResultado = findViewById(R.id.switchResultado);
        toggleResultado = findViewById(R.id.toggleResultado);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String sobrenome = editTextSobrenome.getText().toString();
                String nomeSobrenome = "Nome é " + nome + " " + sobrenome ;

                String cores = "";
                String sexo = "";

                if(checkBox1.isChecked()){
                    String corSelecionada = checkBox1.getText().toString();
                    cores = corSelecionada + " selecionado - ";
                }

                if(checkBox2.isChecked()){
                    String corSelecionada = checkBox2.getText().toString();
                    cores = cores + corSelecionada + " selecionado - ";
                }

                if(checkBox3.isChecked()){
                    String corSelecionada = checkBox3.getText().toString();
                    cores = cores + corSelecionada + " selecionado - ";
                }

                int radioButtonSelected = radioGroupSexo.getCheckedRadioButtonId();
                radioButtonSexo = findViewById(radioButtonSelected);
                String sexoSelecionado = radioButtonSexo.getText().toString();
                sexo = sexoSelecionado + " selecionado";

                textViewResultado.setText(nomeSobrenome + "\n" + cores + "\n" + sexo);

            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNome.setText("");
                editTextSobrenome.setText("");
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                radioButtonSexo.setChecked(false);
//                radioButtonMasculino.setChecked(false);
//                radioButtonFeminino.setChecked(false);
                textViewResultado.setText("");
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (switchButton.isChecked()){

                    switchResultado.setText("O Palmeiras TEM Mundial!!!");
                } else {

                    switchResultado.setText("O Palmeiras NÃO TEM Mundial!!!");
                }

            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (toggleButton.isChecked()){
                    toggleResultado.setText("Toggle Ligado");
                } else {
                    toggleResultado.setText("Toggle Desligado");
                }

            }
        });

    }
}