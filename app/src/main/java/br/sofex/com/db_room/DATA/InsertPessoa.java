package br.sofex.com.db_room.DATA;

import android.content.Context;
import android.os.AsyncTask;

import br.sofex.com.db_room.DB.DataBaseCliente.DatabaseClient;
import br.sofex.com.db_room.Entidades.Pessoa;

public class InsertPessoa extends AsyncTask<Void, Void, Void> {

    Context mContext;
    Integer Option;
    Pessoa pessoa;

    public InsertPessoa(Context context,Pessoa pessoa,Integer Option)
    {this.mContext = context; this.pessoa = pessoa;  this.Option = Option;}


    @Override
    protected Void doInBackground(Void... voids) {

        switch(Option)
        {
            case 1 :
                insertPessoa(pessoa);
            break;
        }

        insertPessoa(pessoa);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


    public void insertPessoa(Pessoa pessoa)
    {
        //creating a task
        pessoa.setNome(pessoa.getNome());
        pessoa.setEndereco(pessoa.getEndereco());
        //adding to database
        DatabaseClient.getInstance(mContext).getAppDatabase().pessaoDao().insertPessoa(pessoa);
    }
}
