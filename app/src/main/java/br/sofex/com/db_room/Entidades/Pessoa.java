package br.sofex.com.db_room.Entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pessoa")
public class Pessoa {


    @PrimaryKey(autoGenerate = true)
    Long CodigoPessoa;

    @ColumnInfo(name = "Nome")
    private String Nome;

    @ColumnInfo(name = "Endereco")
    private String  Endereco;


    public Long getCodigoPessoa() {
        return CodigoPessoa;
    }

    public void setCodigoPessoa(Long codigoPessoa) {
        CodigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

}
