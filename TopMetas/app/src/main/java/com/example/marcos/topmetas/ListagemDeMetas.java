package com.example.marcos.topmetas;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Date;
import java.util.Locale;


public class ListagemDeMetas extends ActionBarActivity {

    SQLiteDatabase meuBanco;
    ListView listaMetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_de_metas);

        Meta [] metas = new Meta[]{
                new Meta(new Date(new Date().getTime()+1000), 10, "ler livro", 50, 50),
                new Meta(new Date(new Date().getTime()+2000), 20, "comer", 50, 25)
        };

        final MetaAdapter adapter = new MetaAdapter(this,  R.layout.listview_item_row, metas);

        listaMetas = (ListView) findViewById(R.id.listagem_metas);
        /*

         Fotos fotos_data[] = new Fotos[]
                {
                        new Fotos(R.drawable.dog1, "Lulu da Silva"),
                        new Fotos(R.drawable.dog2, "Max Silviano"),
                        new Fotos(R.drawable.dog3, "Bob Mark"),
                        new Fotos(R.drawable.dog4, "Maylon Personal"),
                        new Fotos(R.drawable.dog5, "Joca Melonderio"),
                        new Fotos(R.drawable.dog6, "Tob Juquiciano"),
                        new Fotos(R.drawable.dog7, "Pom Pet")
                };

        final FotosAdapter adapter = new FotosAdapter(this,  R.layout.listview_item_row, fotos_data);


        listView1 = (ListView)findViewById(R.id.listView_exemplo);

        //View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        //listView1.addHeaderView(header);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fotos item = (Fotos) adapter.getItem(position);
                Log.v("App","Item Clicado:");
                Log.v("App",item.icon + "");
                Log.v("App",item.title);
            }
        });


         */




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
