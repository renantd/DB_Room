package br.sofex.com.db_room.DATA;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.sofex.com.db_room.DB.DataBaseCliente.DatabaseClient;
import br.sofex.com.db_room.Entidades.Pessoa;

public class RecuperarDadosCriteria  extends AsyncTask<Void, Void, List<Pessoa>> {

    Context mContext;
    Integer Option;
    String Value;

    public RecuperarDadosCriteria(Context context,Integer Option,String Value)
    {this.mContext = context; this.Option = Option; this.Value = Value;}


    @Override
    protected List<Pessoa> doInBackground(Void... voids) {

        List<Pessoa> list1 = new ArrayList<>();
        switch(Option){
            case 1:
                list1 = DatabaseClient.getInstance(mContext).getAppDatabase().pessaoDao().getPessoa_ByNome(Value);
            break;

            case 2:
                list1 = DatabaseClient.getInstance(mContext).getAppDatabase().pessaoDao().getPessoa_ByEndereco(Value);
            break;

            case 3:
                list1 = DatabaseClient.getInstance(mContext).getAppDatabase().pessaoDao().ListaNomes();
            break;


        }
        return list1;
    }

    @Override
    protected void onPostExecute(List<Pessoa> aVoid) {
        super.onPostExecute(aVoid);
    }


}
