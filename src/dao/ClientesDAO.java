package dao;

import model.Clientes;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novoClientes = conndb.prepareStatement("insert into Clientes(nome,email,cpf,telefone) values(?,?,?,?)");

            novoClientes.setString(1,"maria");
            novoClientes.setString(2,"maria@hotmail.com");
            novoClientes.setString(3,"123.687.789-14");
            novoClientes.setString(4,"(15)98834-6765");

            int linhaAfetada = novoClientes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro: ao inserir os clientes " + erro);
            return false;
        }
    }

    public boolean deletarCliente() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement removeUsuarios = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            removeUsuarios.setInt(1,1);

            int linhaAfetada = removeUsuarios.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar os clientes" + erro);
            return false;
        }
    }

    public boolean alterarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clienteAlterado = conndb.prepareStatement("update cliente Set nome = ?, email = ?, cpf = ?, telefone = ? where id = ?");

            clienteAlterado.setString(1,"marcio");
            clienteAlterado.setString(2,"marcio@hotmail.com");
            clienteAlterado.setString(3,"567.234.987-18");
            clienteAlterado.setString(4,"(15)98887-7755");
            clienteAlterado.setInt(5,3);

            int linhaAlterada = clienteAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao alterar os clientes" + erro);
            return false;
        }
    }
}
