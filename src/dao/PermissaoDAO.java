package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PermissaoDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPermissao() {
        try{
            Connection connection = conexao.conectar();
            PreparedStatement newPermissao = connection.prepareStatement("INSERT INTO permissao(nome) VALUES(?);");
            newPermissao.setString(1, "Dono");
            int linhaAfetada = newPermissao.executeUpdate();
            newPermissao.close();
            return linhaAfetada > 0;
        }catch (Exception e){
            System.out.println("Erro ao inserir permissao" + e.getMessage());
            return false;
        }
    }

    public boolean deletarPermissao() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement deletaPermissao = conndb.prepareStatement("DELETE FROM permissao WHERE id = ?");
            deletaPermissao.setInt(1,1);

            int linhaAfetada = deletaPermissao.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar a permissão" + erro);
            return false;
        }
    }

    public boolean alterarPermissao() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement permissaoAlterado = conndb.prepareStatement("update permissao Set nome = ? where id = ?");

            permissaoAlterado.setString(1,"novo adm");
            permissaoAlterado.setInt(2,3);

            int linhaAlterada = permissaoAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao alterar as permissão" + erro);
            return false;
        }
    }

    public void pesquisarpermissao() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarPermissao = conndb.prepareStatement("select nome from Permissao where id = ?");
            buscarPermissao.setInt(1,1);
            ResultSet resultado = buscarPermissao.executeQuery();

            while (resultado.next()){
                String nome = resultado.getString("nome");
                System.out.println("nome: " + nome);
            }
            conndb.close();
        }
        catch (Exception erro){
            System.out.println("Erro ao pesquisar a permissão" + erro);
        }
    }
}
