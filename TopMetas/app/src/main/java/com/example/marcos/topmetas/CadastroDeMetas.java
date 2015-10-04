package com.example.marcos.topmetas;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Locale;

public class CadastroDeMetas extends ActionBarActivity {

    SQLiteDatabase meuBanco;
    EditText edit_text_descricao;
    EditText edit_text_tempo;
    EditText edit_text_dataFinal;
    EditText edit_text_horaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_de_metas);

        meuBanco = openOrCreateDatabase("bancoDeMetas.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        meuBanco.setVersion(3);
        meuBanco.setLocale(Locale.getDefault());
        String sqlCreate = "CREATE TABLE IF NOT EXISTS META ( id INTEGER primary key autoincrement , descricao TEXT, tempo INTEGER, porcentagem REAL, dataFim TEXT ) ";
        meuBanco.execSQL(sqlCreate);

        edit_text_descricao = (EditText) findViewById(R.id.edit_text_descricao);
        edit_text_tempo = (EditText) findViewById(R.id.edit_text_tempo);
        edit_text_dataFinal = (EditText) findViewById(R.id.edit_text_dataFinal);
        edit_text_horaFinal = (EditText) findViewById(R.id.edit_text_horaFinal);

        ImageView bt_confirm = (ImageView) findViewById(R.id.confirm);
        bt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarMetas();
            }
        });

    }

    private void salvarMetas() {
        String tempo = edit_text_tempo.getText().toString();
        String descricao = edit_text_descricao.getText().toString();
        String dataFinal = edit_text_dataFinal.getText().toString();
        String horaFinal = edit_text_horaFinal.getText().toString();

        if(descricao.length() < 2){
            mostrarMensagem("Informe uma descrição");
        } else {
            ContentValues values = new ContentValues();
            values.put("tempo", tempo);
            values.put("descricao", descricao);
            values.put("datafim", dataFinal);
            values.put("datafim", horaFinal);
        }



    }
    public void mostrarMensagem(String msg){
        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
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
