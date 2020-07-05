package br.sofex.com.db_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.sofex.com.db_room.Adapter.CustomAdapterList;
import br.sofex.com.db_room.DATA.InsertPessoa;
import br.sofex.com.db_room.DATA.RecuperarDados;
import br.sofex.com.db_room.DATA.RecuperarDadosCriteria;
import br.sofex.com.db_room.Entidades.Pessoa;

public class MainActivity extends AppCompatActivity {

    EditText nome,endereco,cp_update_pesquisa;
    TextView cp1,cp2;

    Button btn_Salvar;
    Button btn_Alterar;
    Button btn_Excluir;
    Button Btn_mostar;

    Button btn_updatePessoa;
    ListView lv_update;

    ImageButton btn_add;
    ImageButton btn_update;
    ImageButton btn_del;
    ImageButton Btn_list;
    ImageButton btn_search_update;

    ListView lv_01;
    HashMap<String, String> map1 = new HashMap<>();
    Cursor cursor;

    LinearLayout lin_insert;
    LinearLayout lin_update;
    LinearLayout lin_delete;
    LinearLayout lin_listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome        = findViewById(R.id.cp_nome);
        endereco    = findViewById(R.id.cp_endereco);
        cp_update_pesquisa = findViewById(R.id.cp_update_pesquisa);

        btn_add      = findViewById(R.id.btn_add);
        btn_update   = findViewById(R.id.btn_update);
        btn_del      = findViewById(R.id.btn_delete);
        Btn_list     = findViewById(R.id.btn_list);

        btn_Salvar         = findViewById(R.id.btn_salvar);
        btn_updatePessoa   = findViewById(R.id.btn_updatevalue);
        btn_search_update  = findViewById(R.id.btn_search_update);
        lv_update          = findViewById(R.id.lv_update);

        lin_insert   = findViewById(R.id.lin_insert);
        lin_update   = findViewById(R.id.lin_update);
        lin_delete   = findViewById(R.id.lin_excluir);
        lin_listar   = findViewById(R.id.lin_listar);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alteracao.class);
                startActivity(intent);
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exclusao.class);
                startActivity(intent);
            }
        });
        Btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Listar.class);
                startActivity(intent);
            }
        });




        //TODO: Update
        btn_search_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list1 = new ArrayList<>();
                list1 = RecuperarDadosCriteria(1,cp_update_pesquisa.getText().toString());
                final List<String> finalList = list1;
                lv_update.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, finalList.get(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        lin_insert.setVisibility(View.GONE);
        lin_update.setVisibility(View.GONE);
        lin_delete.setVisibility(View.GONE);
        lin_listar.setVisibility(View.GONE);

        btn_Salvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               Pessoa pessoa = new Pessoa();
               pessoa.setNome(nome.getText().toString());pessoa.setEndereco(endereco.getText().toString());
               insertPessoa(MainActivity.this,pessoa,1);
            }
        });

        //RecuperarDados();
        /*map1.clear();
        RecuperarDadosCriteria(1,nome.getText().toString());*/

    }

    //TODO: CRUD
    public void insertPessoa(Context context, Pessoa pessoa, Integer Option)
    {
       InsertPessoa insert = new InsertPessoa(context,pessoa,Option);
       try {insert.execute().get();nome.setText(null);endereco.setText(null);}
       catch (ExecutionException e) {
         Toast.makeText(context, "ExecutionException "+e, Toast.LENGTH_SHORT).show();
         e.printStackTrace();
       }
       catch (InterruptedException e) {
         Toast.makeText(context,
         "InterruptedException "+e, Toast.LENGTH_SHORT).show();
         e.printStackTrace();
       }
   }
    public void UpdatePessoa(String Nome ,String Endereco)
    {

    }

    public void RecuperarDados()
    {
        List<Pessoa> list1 = new ArrayList<>();

        try {list1 = new RecuperarDados(MainActivity.this).execute().get();}
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

        final CustomAdapterList adapter = new CustomAdapterList(MainActivity.this, map1);
        lv_01.setAdapter(adapter);
    }

    public List<String> RecuperarDadosCriteria(Integer Option, String Valor_de_Pesquisa)
    {
        List<Pessoa> list1 = new ArrayList<>(); List<String> Result = new ArrayList<>();
        try {list1 = new RecuperarDadosCriteria(MainActivity.this,Option,Valor_de_Pesquisa).execute().get();}
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

        final CustomAdapterList adapter = new CustomAdapterList(MainActivity.this, map1);
        lv_update.setAdapter(adapter);
        return Result;
    }

    public void DeleteData()
    {
        List<Pessoa> list1 = new ArrayList<>();

        try {new RecuperarDados(MainActivity.this).execute().get();}
        catch (ExecutionException e)
        {e.printStackTrace();}
        catch (InterruptedException e)
        {e.printStackTrace();}

    }
}
