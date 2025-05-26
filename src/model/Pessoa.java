package model;

//declaração de variaveis com modificador de acesso e tipagem
public class Pessoa {
    private String nome;
    private String email;

    //construtor: inicializa a classe quando um objeto é criado
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getemail() {
        return email;
    }

    public void setRg(String rg) {
        this.email = email;
    }
}
