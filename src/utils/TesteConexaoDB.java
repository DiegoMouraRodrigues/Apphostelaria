package utils;

//Dentro do package util, criar a classe TesteConexao.java, segue código abaixo:

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import dao.*;
import model.Adicionais;
import model.Clientes;
import model.Usuarios;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");

            try {
               // UsuariosDAO usuariosDAO = new UsuariosDAO();
              //  usuariosDAO.inserirUsuarios();

                 ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirCliente();

                 QuartosDAO quartosDAO = new QuartosDAO();
                 quartosDAO.inserirQuartos();

                PermissaoDAO permissaoDAO = new PermissaoDAO();
                permissaoDAO.inserirPermissao();

                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicionais();



                System.out.println("Usuario Inserido com sucesso!");
                condb.close();
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

