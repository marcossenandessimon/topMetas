package com.example.marcos.topmetas;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;


public class ListagemDeMetas extends ActionBarActivity {

    SQLiteDatabase meuBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_de_metas);

        meuBanco = openOrCreateDatabase("bancoDeMetas.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        meuBanco.setVersion(3);
        meuBanco.setLocale(Locale.getDefault());
        String sqlCreate = "CREATE TABLE IF NOT EXISTS META ( id INTEGER primary key autoincrement , descricao TEXT, tempo INTEGER, porcentagem REAL, dataFim TEXT ) ";
        meuBanco.execSQL( sqlCreate );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listagem_de_metas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
