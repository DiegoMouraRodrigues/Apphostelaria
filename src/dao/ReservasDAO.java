package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean deleteUsuarios() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement removeUsuarios = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            removeUsuarios.setInt(1,1);

            int linhaAfetada = removeUsuarios.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar a reservas" + erro);
            return false;
        }
    }
}
