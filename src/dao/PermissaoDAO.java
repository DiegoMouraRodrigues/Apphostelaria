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
            return linhaAfetada > 0;
        }catch (Exception e){
            System.out.println("Erro ao inserir permissao" + e.getMessage());
            return false;
        }
    }
}
