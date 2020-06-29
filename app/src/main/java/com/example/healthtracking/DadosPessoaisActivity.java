package com.example.healthtracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class DadosPessoaisActivity extends Activity {

    private static final String TAG = "DadosPessoaisActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_dados_pessoais);
        Log.d(TAG, "Cadastro de dados");

        final EditText txtName = findViewById(R.id.txtNome);
        final Button btSalvarCadastro = findViewById(R.id.btSaveCadastro);

        final DadosPessoais dadosPessoais = new DadosPessoais();



        btSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dadosPessoais.setNome(txtName.getText().toString());
                String name = dadosPessoais.getNome();

                Log.d(TAG,  "nome: " + name);
                if (isCampoVazio(txtName)){
                    Toast.makeText(getApplicationContext(), "Campo obrigatório!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Obrigada por se cadastrar!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }


    public boolean isCampoVazio(EditText campo){
        if (campo.getText().toString().trim().equals("")){
            return true;
        } else {
            return false;
        }
    }

}
