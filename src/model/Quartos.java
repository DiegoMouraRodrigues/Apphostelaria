package model;

public class Quartos {
    private int id, qtd_cama_casal,qtd_cama_solt;
    private String nome;
    private String numero;
    private Double preco;
    private Boolean disponivel;

    public Quartos(String nome,String numero,int qtd_cama_casal,int qtd_cama_solt,Double preco,Boolean disponivel) {
        this.nome = nome;
        this.numero = numero;
        this.preco = preco;
        this.disponivel = disponivel;
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solt = qtd_cama_solt;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd_cama_casal() {
        return qtd_cama_casal;
    }

    public void setQtd_cama_casal(int qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }

    public int getQtd_cama_solt() {
        return qtd_cama_solt;
    }

    public void setQtd_cama_solt(int qtd_cama_solt) {
        this.qtd_cama_solt = qtd_cama_solt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
