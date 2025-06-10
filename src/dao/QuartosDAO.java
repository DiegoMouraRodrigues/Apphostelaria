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
            conndb.close();
            return linhaAfetada > 0;

        }
        catch (Exception erro){
            System.out.println("erro ao inserir quartos" + erro);
            return false;
        }
    }

    public boolean deletaQuartos() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement removeUsuarios = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            removeUsuarios.setInt(1,1);

            int linhaAfetada = removeUsuarios.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar os quartos" + erro);
            return false;
        }
    }

    public boolean alterarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado = conndb.prepareStatement("update usuarios Set nome = ?, numero = ?, camaSolteiro = ?, camaCasado = ?, disponivel = ?, preco where id = ?");

           quartoAlterado.setString(1,"quarto de casal ");
           quartoAlterado.setString(2,"3");
           quartoAlterado.setInt(3,0);
           quartoAlterado.setInt(4,2);
           quartoAlterado.setInt(5,1);
           quartoAlterado.setDouble(6,80.00);
           quartoAlterado.setInt(7,2);

            int linhaAlterada = quartoAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao alterar usuarios" + erro);
            return false;
        }
    }
}
