package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

            PreparedStatement removeUsuarios = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            removeUsuarios.setInt(1,1);

            int linhaAfetada = removeUsuarios.executeUpdate();
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
}
