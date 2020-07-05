package br.sofex.com.db_room.DB.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.sofex.com.db_room.Entidades.Pessoa;

@Dao
public interface PessoaDao {

    //TODO Select
    @Query("SELECT * FROM Pessoa")
    List<Pessoa> getAll();

    @Query("SELECT * FROM Pessoa ORDER by CodigoPessoa ASC")
    List<Pessoa> getPessoaAscendente();


    @Query("SELECT * FROM Pessoa  where Nome = :Nome")
    List<Pessoa> getPessoa_ByNome(String Nome);

    @Query("SELECT Nome FROM Pessoa")
    List<Pessoa> ListaNomes();

    @Query("SELECT * FROM Pessoa  where Endereco = :Endereco")
    List<Pessoa> getPessoa_ByEndereco(String Endereco);


    //TODO Delete
    @Query("DELETE from Pessoa")
    void DelPessoaData();



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPessoa(Pessoa... pessoa);


}
