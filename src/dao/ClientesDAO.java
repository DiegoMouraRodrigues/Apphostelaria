package dao;

import model.Clientes;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

            PreparedStatement deletaCliente = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?");
            deletaCliente.setInt(1,1);

            int linhaAfetada =deletaCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar os clientes" + erro);
            return false;
        }
    }

    public boolean alterarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clienteAlterado = conndb.prepareStatement("update clientes Set nome = ?, email = ?, cpf = ?, telefone = ? where id = ?");

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

    public void pesquisarClientes() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarCliente = conndb.prepareStatement("SELECT nome, email, cpf, telefone FROM clientes WHERE id = ?;");
            buscarCliente.setInt(1,3); //
            ResultSet resultado = buscarCliente.executeQuery();

            while (resultado.next()){
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String cpf = resultado.getString("cpf");
                String telefone = resultado.getString("telefone");
                System.out.println("nome: " + nome + " email: " + email + " cpf: " + cpf + " telefone: " + telefone);
            }
            conndb.close();
        }catch (Exception erro){
            System.out.println("Erro ao pesquisar os cliente" + erro.getMessage());
        }
    }
}
