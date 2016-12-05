package com.example.josep.aplicaciomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = (ListView) findViewById(R.id.list);




        String[] values = new String[] { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete","Ocho",

        "Nueve", "Diez", "Once"};

        ArrayAdapter <String> adaptador =new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,values);

        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 valor    = (String) list.getItemAtPosition(position);

                registerForContextMenu(view);
            }


        });


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,  View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case R.id.editar:
                Toast.makeText(this,valor+ ": sera editado" , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.compartir:
                Toast.makeText(this,valor+ ": sera compartido" , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eliminar:
                Toast.makeText(this,valor+ ": sera eliminado" , Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
