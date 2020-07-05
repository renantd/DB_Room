package br.sofex.com.db_room.DATA;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.sofex.com.db_room.DB.DataBaseCliente.DatabaseClient;
import br.sofex.com.db_room.Entidades.Pessoa;

public class RecuperarDados extends AsyncTask<Void, Void, List<Pessoa>> {

    Context mContext;

    public RecuperarDados(Context context)
    {this.mContext = context;}


    @Override
    protected List<Pessoa> doInBackground(Void... voids) {

        List<Pessoa> taskList = DatabaseClient
          .getInstance(mContext)
          .getAppDatabase()
          .pessaoDao()
          .getPessoaAscendente();
        return taskList;
    }

    @Override
    protected void onPostExecute(List<Pessoa> aVoid) {
        super.onPostExecute(aVoid);
    }

}
