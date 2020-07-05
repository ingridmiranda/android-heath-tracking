package com.example.healthtracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.pattern.MaskPattern;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;


public class DadosPessoaisActivity extends Activity {

    private static final String TAG = "DadosPessoaisActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_dados_pessoais);
        Log.d(TAG, "Cadastro de dados");

        final EditText txtName = findViewById(R.id.txtNome);
        final EditText txtAltura = findViewById(R.id.txtAltura);
        final EditText txtDataNascimento = findViewById(R.id.txtDataNascimento);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtCidade = findViewById(R.id.txtCidade);
        final EditText txtPeso = findViewById(R.id.txtPeso);
        final EditText txtPhone = findViewById(R.id.txtPhone);
        final Button btSalvarCadastro = findViewById(R.id.btSaveCadastro);

        /**
        * Criação de máscara para data de nascimento
        * */
        MaskPattern mp03 = new MaskPattern("[0-3]");
        MaskPattern mp09 = new MaskPattern("[0-9]");
        MaskPattern mp02 = new MaskPattern("[0-2]");
        MaskPattern mp01 = new MaskPattern("[0-1]");

        MaskFormatter mfData = new MaskFormatter("[0-3][0-9]/[0-1][0-9]/[0-2][0-9][0-9][0-9]");

        mfData.registerPattern(mp01);
        mfData.registerPattern(mp03);
        mfData.registerPattern(mp02);
        mfData.registerPattern(mp09);

        MaskTextWatcher mtwData = new MaskTextWatcher(txtDataNascimento, mfData);
        txtDataNascimento.addTextChangedListener(mtwData);

        /**
         * Criação de máscara para altura
         */
        MaskFormatter mfAltura = new MaskFormatter("[0-2].[0-9][0-9]");

        mfAltura.registerPattern(mp02);
        mfAltura.registerPattern(mp09);

        MaskTextWatcher mtwAltura = new MaskTextWatcher(txtAltura, mfAltura);
        txtAltura.addTextChangedListener(mtwAltura);

        /**
        * Criação de máscara para telefone
        * */
        SimpleMaskFormatter smfPhone = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtwPhone = new MaskTextWatcher(txtPhone, smfPhone);
        txtPhone.addTextChangedListener(mtwPhone);


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
