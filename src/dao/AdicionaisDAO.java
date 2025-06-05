package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {

        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novoAdicional = conndb.prepareStatement("insert into adicionais (nome,preco) values(?,?);");

            novoAdicional.setString(1,"cafe da manhã");
            novoAdicional.setDouble(2,60.00);

            int linhaAfetada = novoAdicional.executeUpdate();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("erro ao inserir os adicionais");
            return false;
        }
    }


}
