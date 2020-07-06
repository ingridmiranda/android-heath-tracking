package com.example.healthtracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarBancoDeDados extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "pessoas";
    public static final String ID = "_id";
    public static final String NOME_PESSOA = "nome";
    public static final String SEXO = "sexo";
    public static final String IDADE = "idade";
    public static final int VERSAO = 1;

     public CriarBancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "("
                + ID + " integer primary key autoincrement,"
                + NOME_PESSOA + " text,"
                + SEXO + " text,"
                + IDADE + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABELA);
            onCreate(db);
    }

}
