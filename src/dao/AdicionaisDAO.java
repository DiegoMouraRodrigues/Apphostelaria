package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {

        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novoAdicional = conndb.prepareStatement("insert into adicionais (nome,preco) values(?,?);");

            novoAdicional.setString(1,"cafe da manhã");
            novoAdicional.setDouble(2,60.00);

            int linhaAfetada = novoAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("erro ao inserir os adicionais");
            return false;
        }
    }

    public boolean deletarAdicionais() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement deletaAdicionais = conndb.prepareStatement("DELETE FROM adicionais WHERE id = ?");
            deletaAdicionais.setInt(1,4);

            int linhaAfetada = deletaAdicionais.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar usuarios" + erro);
            return false;
        }
    }
    public boolean alterarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement adicionaisAlterado = conndb.prepareStatement("update adicionais Set nome = ?, preco = ? where id = ?");

            adicionaisAlterado.setString(1,"jantar");
            adicionaisAlterado.setDouble(2, 50.00);
            adicionaisAlterado.setInt(3,3);

            int linhaAlterada = adicionaisAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao alterar os adicionais" + erro);
            return false;
        }
    }

    public void pesquisarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarAdicionais = conndb.prepareStatement("SELECT nome, preco FROM adicionais where id = ?");
            buscarAdicionais.setInt(1,3);
            ResultSet resultado = buscarAdicionais.executeQuery();

            while (resultado.next()){
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                System.out.println("nome: " + nome + " preco: " + preco);
            }
            conndb.close();
        }
        catch (Exception erro){
            System.out.println("Erro ao pesquisar o adicional " + erro);
        }
    }
}
