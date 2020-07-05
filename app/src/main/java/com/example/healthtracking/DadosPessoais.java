package com.example.healthtracking;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;

public class DadosPessoais{
    private String nome,
            sexo,
            estadoCivil,
            dataNascimento,
            cidade,
            estado,
            email,
            telefone;
    private int idade,
            diaNascimento,
            mesNascimento,
            anoNascimento;
    private double altura,
                    peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade(){
        String dataNascimento = getDataNascimento();
        int dia = Integer.parseInt(dataNascimento.substring(0, 2));
        int mes = Integer.parseInt(dataNascimento.substring(3, 5));
        int ano = Integer.parseInt(dataNascimento.substring(6, 10));

        LocalDate nascimento = LocalDate.of(ano, mes, dia);
        LocalDate atual = LocalDate.now();
        Period periodo = Period.between(nascimento, atual);
        int idade = periodo.getYears();

        return idade;
    }

    public double getIMC(){
        double peso = getPeso();
        double altura = getAltura();
        DecimalFormat df = new DecimalFormat("0.00");
        //double imc = peso/(altura*altura);
        double imc = Double.parseDouble(df.format(peso/(altura*altura)));
        return imc;
    }
    //public DadosPessoais(String nome, String sexo, String cidade, String bairro, String estado, String pais, int idade, int diaNascimento, int mesNascimento, int anoNascimento){}

}