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
import android.widget.ImageView;
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
        final ImageView imgButton = findViewById(R.id.imageView);
        final EditText txtName = findViewById(R.id.txtNome);
        final EditText txtAltura = findViewById(R.id.txtAltura);
        final EditText txtDataNascimento = findViewById(R.id.txtDataNascimento);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtCidade = findViewById(R.id.txtCidade);
        final EditText txtPeso = findViewById(R.id.txtPeso);
        final EditText txtPhone = findViewById(R.id.txtPhone);

        final Spinner spinnerSexo = findViewById(R.id.spinnerSexo);
        final Spinner spinnerEstadoCivil = findViewById(R.id.spinnerEstadoCivil);
        final Spinner spinnerEstado = findViewById(R.id.spinnerEstado);

        final Button btSalvarCadastro = findViewById(R.id.btSaveCadastro);

        final String[] array_sexo = new String[]{"Sexo", "Feminino", "Masculino"};
        final String[] array_estadoCivil = new String[]{"Estado civil", "Solteiro(a)", "Casado(a)", "Separado(a)", "Divorciado(a)", "Viúvo(a)",
                "União estável"};
        final String[] array_estado = new String[]{"Estado", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
                "Espirito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná",
                "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina",
                "São Paulo", "Sergipe", "Tocantins"};

        final List<String> sexoList = new ArrayList<>(Arrays.asList(array_sexo));
        final List<String> estadoCivilList = new ArrayList<>(Arrays.asList(array_estadoCivil));
        final List<String> estadoList = new ArrayList<>(Arrays.asList(array_estado));


        /**
         * Inicializando um ArrayAdapter para Sexo
         */
        final ArrayAdapter<String> spinnerArrayAdapterSexo = new ArrayAdapter<String>(
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
        spinnerArrayAdapterSexo.setDropDownViewResource(R.layout.spinner_item);
        spinnerSexo.setAdapter(spinnerArrayAdapterSexo);

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        /**
         * Inicializando um ArrayAdapter para Estado Civil
         */
        final ArrayAdapter<String> spinnerArrayAdapterEstadoCivil = new ArrayAdapter<String>(
                this,R.layout.spinner_item,estadoCivilList){
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
        spinnerArrayAdapterEstadoCivil.setDropDownViewResource(R.layout.spinner_item);
        spinnerEstadoCivil.setAdapter(spinnerArrayAdapterEstadoCivil);

        spinnerEstadoCivil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        /**
         * Inicializando um ArrayAdapter para Estado
         */
        final ArrayAdapter<String> spinnerArrayAdapterEstado = new ArrayAdapter<String>(
                this,R.layout.spinner_item,estadoList){
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
        spinnerArrayAdapterEstado.setDropDownViewResource(R.layout.spinner_item);
        spinnerEstado.setAdapter(spinnerArrayAdapterEstado);

        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


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

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        final DadosPessoais dadosPessoais = new DadosPessoais();

        btSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCampoVazio(txtName) || (spinnerSexo.getSelectedItem().toString().equals("Sexo")) || (isCampoVazio(txtDataNascimento)) ||
                        (isCampoVazio(txtAltura)) || (isCampoVazio(txtPeso)) || (isCampoVazio(txtCidade)) ||
                        (spinnerEstadoCivil.getSelectedItem().toString().equals("Estado civil")) || isCampoVazio(txtEmail) ||
                        (spinnerEstado.getSelectedItem().toString().equals("Estado")) || (isCampoVazio(txtPhone))){
                    Toast.makeText(getApplicationContext(), "Campo obrigatório!", Toast.LENGTH_LONG).show();
                } else {
                    dadosPessoais.setNome(txtName.getText().toString());
                    dadosPessoais.setDataNascimento(txtDataNascimento.getText().toString());
                    dadosPessoais.setAltura(Double.parseDouble(txtAltura.getText().toString()));
                    dadosPessoais.setPeso(Double.parseDouble(txtPeso.getText().toString().replace(',', '.')));
                    dadosPessoais.setCidade(txtCidade.getText().toString());
                    dadosPessoais.setEmail(txtEmail.getText().toString());
                    dadosPessoais.setTelefone(txtPhone.getText().toString());

                    dadosPessoais.setSexo(spinnerSexo.getSelectedItem().toString());
                    dadosPessoais.setEstadoCivil(spinnerEstadoCivil.getSelectedItem().toString());
                    dadosPessoais.setEstado(spinnerEstado.getSelectedItem().toString());

                    Log.d(TAG, "Nome: " + dadosPessoais.getNome() + "\n" +
                            "Sexo: " + dadosPessoais.getSexo() + "\n" +
                            "Data de Nascimento: " + dadosPessoais.getDataNascimento() + "\n" +
                            "Altura: " + dadosPessoais.getAltura() + "\n" +
                            "Peso: " + dadosPessoais.getPeso() + "\n" +
                            "Cidade: " + dadosPessoais.getCidade() + "\n" +
                            "Estado Civil: " + dadosPessoais.getEstadoCivil() + "\n" +
                            "Estado: "+ dadosPessoais.getEstado() + "\n" +
                            "Email: " + dadosPessoais.getEmail() + "\n" +
                            "Telefone: "+ dadosPessoais.getTelefone() + "\n");
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
