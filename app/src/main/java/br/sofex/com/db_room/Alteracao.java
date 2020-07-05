package br.sofex.com.db_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.sofex.com.db_room.Adapter.CustomAdapterList;
import br.sofex.com.db_room.DATA.RecuperarDados;
import br.sofex.com.db_room.DATA.RecuperarDadosCriteria;
import br.sofex.com.db_room.Entidades.Pessoa;

public class Alteracao extends AppCompatActivity {

    AutoCompleteTextView cp_search_pesquisa;
    Button btn_updatePessoa;
    ImageButton btn_search_update;
    ListView lv_update;
    HashMap<String, String> map1 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao);

        cp_search_pesquisa = findViewById(R.id.cp_search_pesquisa);
        btn_updatePessoa   = findViewById(R.id.btn_updatevalue);
        btn_search_update  = findViewById(R.id.btn_search_update);
        lv_update          = findViewById(R.id.lv_update);

        //TODO: Update
       /* btn_search_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list1;
                list1 = RecuperarDadosCriteria(1,cp_search_pesquisa.getText().toString());
                final List<String> finalList = list1;
                lv_update.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Alteracao.this, finalList.get(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, RecuperarListaNomes());
        cp_search_pesquisa.setAdapter(adapter);
        cp_search_pesquisa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(RecuperarListaNomes().contains(parent.getItemAtPosition(position).toString()))
                {
                    List<Pessoa> list1 = new ArrayList<>();
                    try {list1 = new RecuperarDadosCriteria(Alteracao.this,1,parent.getItemAtPosition(position).toString()).execute().get();}
                    catch (ExecutionException e)
                    {e.printStackTrace();}
                    catch (InterruptedException e)
                    {e.printStackTrace();}

                    map1.clear();
                    for(Pessoa pessoa : list1)
                    {
                        if(pessoa.getNome() != null && pessoa.getEndereco() != null)
                        {
                            Log.e("App1","Result : "+pessoa.getNome()+" / "+pessoa.getEndereco());
                            map1.put(pessoa.getNome(),pessoa.getEndereco());
                        }

                    }
                    final CustomAdapterList adapter = new CustomAdapterList(Alteracao.this, map1);
                    lv_update.setAdapter(adapter);
                }
            }
        });

    }

    public List<String> RecuperarDadosCriteria(Integer Option, String Valor_de_Pesquisa)
    {
        List<Pessoa> list1 = new ArrayList<>(); List<String> Result = new ArrayList<>();
        try {list1 = new RecuperarDadosCriteria(Alteracao.this,Option,Valor_de_Pesquisa).execute().get();}
        catch (ExecutionException e)
        {e.printStackTrace();}
        catch (InterruptedException e)
        {e.printStackTrace();}

        for(Pessoa pessoa : list1)
        {
            if(pessoa.getNome() != null && pessoa.getEndereco() != null)
            {
                Log.e("App1","Nome : "+pessoa.getNome()+" Endereço "+pessoa.getEndereco());
                map1.put(pessoa.getNome(),pessoa.getEndereco());
                Result.add(pessoa.getNome() +" / "+ pessoa.getEndereco());
            }

        }

        final CustomAdapterList adapter = new CustomAdapterList(Alteracao.this, map1);
        lv_update.setAdapter(adapter);
        return Result;
    }

    public List<String> RecuperarListaNomes()
    {
        List<Pessoa> list1 = new ArrayList<>(); List<String> Result = new ArrayList<>();

        try {list1 = new RecuperarDados(Alteracao.this).execute().get();}
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
                Result.add(pessoa.getNome());
            }

        }

        final CustomAdapterList adapter = new CustomAdapterList(Alteracao.this, map1);
        lv_update.setAdapter(adapter);
        return Result;
    }

}
