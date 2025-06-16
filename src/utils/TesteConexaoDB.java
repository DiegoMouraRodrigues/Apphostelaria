package utils;

//Dentro do package util, criar a classe TesteConexao.java, segue código abaixo:

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import dao.*;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");

            try {
                //  UsuariosDAO usuariosDAO = new UsuariosDAO();
                // usuariosDAO.inserirUsuarios();

                //  UsuariosDAO usuariosDAO = new UsuariosDAO();
                // usuariosDAO.alterarUsuarios();

               // UsuariosDAO usuariosDAO = new UsuariosDAO();
               // usuariosDAO.pesquisarUsuarios();
              //  System.out.println("Usuario Inserido com sucesso!");

                //UsuariosDAO usuariosDAO = new UsuariosDAO();
                //usuariosDAO.deleteUsuarios();

                // ClientesDAO clientesDAO = new ClientesDAO();
                // clientesDAO.inserirCliente();

                // ClientesDAO clientesDAO = new ClientesDAO();
                //clientesDAO.alterarClientes();

                //ClientesDAO clientesDAO = new ClientesDAO();
                //clientesDAO.pesquisarClientes();

                //ClientesDAO clientesDAO = new ClientesDAO();
                //clientesDAO.deletarCliente();

                //  QuartosDAO quartosDAO = new QuartosDAO();
                //  quartosDAO.inserirQuartos();

                // QuartosDAO quartosDAO = new QuartosDAO();
                 //quartosDAO.alterarQuartos();

                //QuartosDAO quartosDAO = new QuartosDAO();
                //quartosDAO.pesquisarQuartos();

               // QuartosDAO quartosDAO = new QuartosDAO();
                //quartosDAO.deletaQuartos();

                //  PermissaoDAO permissaoDAO = new PermissaoDAO();
                //  permissaoDAO.inserirPermissao();

                //  PermissaoDAO permissaoDAO = new PermissaoDAO();
                //  permissaoDAO.alterarPermissao();

               // PermissaoDAO permissaoDAO = new PermissaoDAO();
                //permissaoDAO.pesquisarpermissao();

                 //AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                 //adicionaisDAO.deletarAdicionais();

                // AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                //adicionaisDAO.alterarAdicionais();

               // AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
               // adicionaisDAO.pesquisarAdicionais();

                //AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                //adicionaisDAO.deletarAdicionais();

                //PedidosDAO pedidosDAO = new PedidosDAO();
                //pedidosDAO.inserirPedidos();

                //PedidosDAO pedidosDAO = new PedidosDAO();
                //pedidosDAO.alterarPedidos();

                //PedidosDAO pedidosDAO = new PedidosDAO();
                //pedidosDAO.pesquisarPedidos();

                //PedidosDAO pedidosDAO = new PedidosDAO();
                //pedidosDAO.deleteUsuarios();

                

                System.out.println("Conexão encerrada!");
            }

            catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}

