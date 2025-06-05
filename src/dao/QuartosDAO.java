package dao;

import model.Quartos;
import model.Usuarios;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {

        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO Quartos(nome, numero, camaSolteiro, camaCasal, disponível, preco) VALUES (?,?,?,?,?,?);");

            novoQuarto.setString(1,"quarto individual ");
            novoQuarto.setString(2,"2");
            novoQuarto.setInt(3,1);
            novoQuarto.setInt(4,0);
            novoQuarto.setInt(5,1);
            novoQuarto.setDouble(6,100.00);

            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;

        }
        catch (Exception erro){
            System.out.println("erro ao inserir quartos" + erro);
            return false;
        }
    }
}
