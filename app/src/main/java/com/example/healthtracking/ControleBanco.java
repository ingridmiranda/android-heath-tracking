package com.example.healthtracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ControleBanco {
    private SQLiteDatabase db;
    private CriarBancoDeDados banco;

    public ControleBanco(Context context){
        banco = new CriarBancoDeDados(context);
    }

    public String insereDado(String nome, String sexo, int idade){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBancoDeDados.NOME_PESSOA, nome);
        valores.put(CriarBancoDeDados.SEXO, sexo);
        valores.put(CriarBancoDeDados.IDADE, idade);

        resultado = db.insert(CriarBancoDeDados.TABELA, null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro!";
        } else{
            return "Registro inserido com sucesso!";
        }
    }


    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME_PESSOA};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}

