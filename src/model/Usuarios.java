package model;

public class Usuarios extends Pessoa {
    private int id, id_perm_fk;
    private String nome,email,senha;

    public Usuarios(String nome, String email, String senha, int id_perm_fk) {
        super(nome,email);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id_perm_fk = id_perm_fk;

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

    public int getId_perm_fk() {return id_perm_fk;}

    public void setId_perm_fk(int id_perm_fk) {}

}
