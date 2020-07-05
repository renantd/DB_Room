package br.sofex.com.db_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.sofex.com.db_room.DATA.InsertPessoa;
import br.sofex.com.db_room.Entidades.Pessoa;

public class Cadastro extends AppCompatActivity {

    EditText cp_nome,cp_endereco;
    TableRow tr_btn_salvar;
    Button btn_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cp_nome       = findViewById(R.id.cp_nome);
        cp_endereco   = findViewById(R.id.cp_endereco);
        tr_btn_salvar = findViewById(R.id.tr_btn_salvar);
        btn_salvar    = findViewById(R.id.btn_salvar);
        //tr_btn_salvar.setVisibility(View.GONE);


        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cp_nome.getText().toString().isEmpty() && !cp_endereco.getText().toString().isEmpty())
                {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(cp_nome.getText().toString());pessoa.setEndereco(cp_endereco.getText().toString());
                    insertPessoa(Cadastro.this,pessoa,1);
                }
            }
        });

    }

    public void insertPessoa(Context context, Pessoa pessoa, Integer Option)
    {
        InsertPessoa insert = new InsertPessoa(context,pessoa,Option);
        try {insert.execute().get();cp_nome.setText(null);cp_endereco.setText(null);}
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

}
