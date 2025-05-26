package model;

public class Roles {
    private int id;
    private String nome;
    public  Roles(String nome) {
        this.nome = nome;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
