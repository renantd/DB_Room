package br.sofex.com.db_room.Entidades;

import androidx.room.Dao;

public class Sqlite  {

    public String SetNomeBancoDeDados(String NomeDataBase)
    {return NomeDataBase;}

    public Object ClasseDAO(Dao ClasseNome){
        return ClasseNome;
    }

}
