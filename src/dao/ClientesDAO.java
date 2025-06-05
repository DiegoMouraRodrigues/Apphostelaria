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

            novoClientes.setString(1,"diego");
            novoClientes.setString(2,"diegomoura@hotmail.com");
            novoClientes.setString(3,"123.456.789-12");
            novoClientes.setString(4,"(15)98835-4165");

            int linhaAfetada = novoClientes.executeUpdate();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro: ao inserir os clientes " + erro);
            return false;
        }
    }
}
