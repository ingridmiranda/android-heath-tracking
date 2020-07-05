package com.example.healthtracking;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.pattern.MaskPattern;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

        final Spinner spinnerSexo = findViewById(R.id.spinnerSexo);

        final String[] array_sexo = new String[]{"Sexo", "Feminino", "Masculino"};
        final List<String> sexoList = new ArrayList<>(Arrays.asList(array_sexo));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,sexoList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerSexo.setAdapter(spinnerArrayAdapter);

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexo_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSexo.setAdapter(adapter);
*/

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
                dadosPessoais.setDataNascimento(txtDataNascimento.getText().toString());
                dadosPessoais.setEmail(txtEmail.getText().toString());
                dadosPessoais.setCidade(txtCidade.getText().toString());
                dadosPessoais.setTelefone(txtPhone.getText().toString());

                dadosPessoais.setSexo(spinnerSexo.getSelectedItem().toString());

                String name = dadosPessoais.getNome();
                Log.d(TAG,  "nome: " + name);
                Log.d(TAG, dadosPessoais.getCidade() + dadosPessoais.getDataNascimento() + dadosPessoais.getEmail() + dadosPessoais.getTelefone()
                        + dadosPessoais.getSexo());
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
