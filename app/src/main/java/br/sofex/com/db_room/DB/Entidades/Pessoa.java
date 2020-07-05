package br.sofex.com.db_room.DB.Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pessoa")
public class Pessoa {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    Long CodigoPessoa;

    @NonNull
    @ColumnInfo(name = "Nome")
    private String Nome;


    @NonNull
    @ColumnInfo(name = "TipoDeDocumento")
    private String TipoDeDocumento;

    @NonNull
    @ColumnInfo(name = "ValorDoDOcumento")
    private String ValorDoDOcumento;

    @NonNull
    @ColumnInfo(name = "Nascionalidade")
    private String Nascionalidade;

    @NonNull
    @ColumnInfo(name = "Etinia")
    private String  Etinia;

    @NonNull
    @ColumnInfo(name = "Sexo")
    private String  Sexo;

    @NonNull
    @ColumnInfo(name = "FotoPessoa")
    private byte[]  FotoPessoa;


    @NonNull
    @ColumnInfo(name = "TelefoneFixo")
    private String  TelefoneFixo;

    @NonNull
    @ColumnInfo(name = "TelefoneCelular")
    private String  TelefoneCelular;

    @NonNull
    @ColumnInfo(name = "Email")
    private String  Email;

    @NonNull
    @ColumnInfo(name = "CEP")
    private String  CEP;


    @NonNull
    @ColumnInfo(name = "Endereco")
    private String  Endereco;

    @NonNull
    @ColumnInfo(name = "Complemento")
    private String  Complemento;

    @NonNull
    @ColumnInfo(name = "Numero")
    private String  Numero;

    @NonNull
    @ColumnInfo(name = "Bairro")
    private String  Bairro;

    @NonNull
    @ColumnInfo(name = "Municipio")
    private String  Municipio;

    @NonNull
    @ColumnInfo(name = "Estado")
    private String  Estado;


    @NonNull
    public Long getCodigoPessoa() {
        return CodigoPessoa;
    }

    public void setCodigoPessoa(@NonNull Long codigoPessoa) {
        CodigoPessoa = codigoPessoa;
    }

    @NonNull
    public String getNome() {
        return Nome;
    }

    public void setNome(@NonNull String nome) {
        Nome = nome;
    }

    @NonNull
    public String getTipoDeDocumento() {
        return TipoDeDocumento;
    }

    public void setTipoDeDocumento(@NonNull String tipoDeDocumento) {
        TipoDeDocumento = tipoDeDocumento;
    }

    @NonNull
    public String getValorDoDOcumento() {
        return ValorDoDOcumento;
    }

    public void setValorDoDOcumento(@NonNull String valorDoDOcumento) {
        ValorDoDOcumento = valorDoDOcumento;
    }

    @NonNull
    public String getNascionalidade() {
        return Nascionalidade;
    }

    public void setNascionalidade(@NonNull String nascionalidade) {
        Nascionalidade = nascionalidade;
    }

    @NonNull
    public String getEtinia() {
        return Etinia;
    }

    public void setEtinia(@NonNull String etinia) {
        Etinia = etinia;
    }

    @NonNull
    public String getSexo() {
        return Sexo;
    }

    public void setSexo(@NonNull String sexo) {
        Sexo = sexo;
    }

    @NonNull
    public byte[] getFotoPessoa() {
        return FotoPessoa;
    }

    public void setFotoPessoa(@NonNull byte[] fotoPessoa) {
        FotoPessoa = fotoPessoa;
    }

    @NonNull
    public String getTelefoneFixo() {
        return TelefoneFixo;
    }

    public void setTelefoneFixo(@NonNull String telefoneFixo) {
        TelefoneFixo = telefoneFixo;
    }

    @NonNull
    public String getTelefoneCelular() {
        return TelefoneCelular;
    }

    public void setTelefoneCelular(@NonNull String telefoneCelular) {
        TelefoneCelular = telefoneCelular;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }

    @NonNull
    public String getCEP() {
        return CEP;
    }

    public void setCEP(@NonNull String CEP) {
        this.CEP = CEP;
    }

    @NonNull
    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(@NonNull String endereco) {
        Endereco = endereco;
    }

    @NonNull
    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(@NonNull String complemento) {
        Complemento = complemento;
    }

    @NonNull
    public String getNumero() {
        return Numero;
    }

    public void setNumero(@NonNull String numero) {
        Numero = numero;
    }

    @NonNull
    public String getBairro() {
        return Bairro;
    }

    public void setBairro(@NonNull String bairro) {
        Bairro = bairro;
    }

    @NonNull
    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(@NonNull String municipio) {
        Municipio = municipio;
    }

    @NonNull
    public String getEstado() {
        return Estado;
    }

    public void setEstado(@NonNull String estado) {
        Estado = estado;
    }
}
