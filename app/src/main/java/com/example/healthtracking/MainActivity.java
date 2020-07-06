package com.example.healthtracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Main activity start");

        Button btCadastro = findViewById(R.id.btCadastro);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DadosPessoaisActivity.class);
                startActivity(intent);
            }
        });

        /*ControleBanco crud = new ControleBanco(getBaseContext());
        Cursor cursor = crud.carregaDados();

        if (cursor.moveToFirst()) {
            String str = cursor.getString(cursor.getColumnIndex("content"));
            Log.d(TAG, "String: "+str);
        }*/






    }
}
