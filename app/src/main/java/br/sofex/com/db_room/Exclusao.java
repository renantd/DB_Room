package br.sofex.com.db_room;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.concurrent.ExecutionException;

        import br.sofex.com.db_room.Adapter.CustomAdapterList;
        import br.sofex.com.db_room.DATA.RecuperarDados;
        import br.sofex.com.db_room.DATA.RecuperarDadosCriteria;
        import br.sofex.com.db_room.Entidades.Pessoa;

public class Exclusao extends AppCompatActivity {

    AutoCompleteTextView cp_delete_pesquisa;
    Button btn_deletarPessoa;
    ListView lv_deletar;
    HashMap<String, String> map1 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusao);

        cp_delete_pesquisa = findViewById(R.id.cp_delete_pesquisa);
        btn_deletarPessoa   = findViewById(R.id.btn_deletarPessoa);
        lv_deletar          = findViewById(R.id.lv_deletar);

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
        cp_delete_pesquisa.setAdapter(adapter);
        cp_delete_pesquisa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(RecuperarListaNomes().contains(parent.getItemAtPosition(position).toString()))
                {
                    List<Pessoa> list1 = new ArrayList<>();
                    try {list1 = new RecuperarDadosCriteria(Exclusao.this,1,parent.getItemAtPosition(position).toString()).execute().get();}
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
                    final CustomAdapterList adapter = new CustomAdapterList(Exclusao.this, map1);
                    lv_deletar.setAdapter(adapter);
                }
            }
        });

    }

    public List<String> RecuperarListaNomes()
    {
        List<Pessoa> list1 = new ArrayList<>(); List<String> Result = new ArrayList<>();

        try {list1 = new RecuperarDados(Exclusao.this).execute().get();}
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

        final CustomAdapterList adapter = new CustomAdapterList(Exclusao.this, map1);
        lv_deletar.setAdapter(adapter);
        return Result;
    }

}
