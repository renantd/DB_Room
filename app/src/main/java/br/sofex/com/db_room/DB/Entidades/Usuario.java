package br.sofex.com.db_room.DB.Entidades;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Usuario")
public class Usuario {

    @NonNull
    @ColumnInfo(name = "CodUsuario")
    @PrimaryKey(autoGenerate = true)
    Long CodUsuario;

    @NonNull
    @ColumnInfo(name = "NomeUsuario")
    String NomeUsuario;

    @NonNull
    @ColumnInfo(name = "Login")
    String Login;

    @NonNull
    @ColumnInfo(name = "Senha")
    String Senha;

    @NonNull
    @ColumnInfo(name = "Email")
    String Email;

    @NonNull
    @ColumnInfo(name = "FotoUsuario")
    byte[] FotoUsuario;

    @NonNull
    @ColumnInfo(name = "CodUsuario")
    String FotoUsuarioNome;

    @NonNull
    public Long getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(@NonNull Long codUsuario) {
        CodUsuario = codUsuario;
    }

    @NonNull
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(@NonNull String nomeUsuario) {
        NomeUsuario = nomeUsuario;
    }

    @NonNull
    public String getLogin() {
        return Login;
    }

    public void setLogin(@NonNull String login) {
        Login = login;
    }

    @NonNull
    public String getSenha() {
        return Senha;
    }

    public void setSenha(@NonNull String senha) {
        Senha = senha;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }

    @NonNull
    public byte[] getFotoUsuario() {
        return FotoUsuario;
    }

    public void setFotoUsuario(@NonNull byte[] fotoUsuario) {
        FotoUsuario = fotoUsuario;
    }

    @NonNull
    public String getFotoUsuarioNome() {
        return FotoUsuarioNome;
    }

    public void setFotoUsuarioNome(@NonNull String fotoUsuarioNome) {
        FotoUsuarioNome = fotoUsuarioNome;
    }
}
