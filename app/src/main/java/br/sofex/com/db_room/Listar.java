package br.sofex.com.db_room;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.sofex.com.db_room.Adapter.CustomAdapterList;
import br.sofex.com.db_room.DATA.RecuperarDados;
import br.sofex.com.db_room.Entidades.Pessoa;

public class Listar extends AppCompatActivity {

    ListView lv_01;
    HashMap<String, String> map1 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        lv_01 = findViewById(R.id.lv_listar);
        RecuperarDados();
    }


    public void RecuperarDados()
    {
        List<Pessoa> list1 = new ArrayList<>();

        try {list1 = new RecuperarDados(Listar.this).execute().get();}
        catch (ExecutionException e)
        {e.printStackTrace();}
        catch (InterruptedException e)
        {e.printStackTrace();}

        for(Pessoa pessoa : list1)
        {
            if(pessoa.getNome() != null && pessoa.getEndereco() != null)
            {
                Log.e("App1","Result : "+pessoa.getNome()+" / "+pessoa.getEndereco());
                map1.put(pessoa.getNome(),pessoa.getEndereco());
            }

        }

        final CustomAdapterList adapter = new CustomAdapterList(Listar.this, map1);
        lv_01.setAdapter(adapter);
    }

}
