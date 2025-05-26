package model;

public class Usuarios extends Pessoa {
    private String id;
    private String nome,email,senha,cargo;

    public Usuarios(String nome, String email, String senha, String cargo) {
        super(nome,email);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(String cargo) {this.cargo = cargo;}
}
