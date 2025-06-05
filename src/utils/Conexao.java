package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    //declarar 4 variavel com seu tipo e alocar o valor para cada:

    private String driver;
    private String url;
    private String usuario;
    private String senha;

    /*inicializar um contrutor de modo que quando essa classe
    conexao.java inicializar um objeto, o contrutor sera executar
    e a classe conexao.java inicalizado
     */
    public Conexao() {
        carregarConfiguracoes();
    }

    //metodo com o parametros de configuração das variaveis de ambiente
    private void carregarConfiguracoes() {
        Properties prop = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(inputPropsConfig);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            usuario = prop.getProperty("usuario");
            senha = prop.getProperty("senha");
        } catch (IOException erro) {
            System.out.println("erro ao carregar o arquivo: " + erro.getMessage());
        }
    }


    public Connection conectar() {
        Connection conb = null;

        try {
            //Especifica a rota a ser carregado(jdbc para sgbd Mysql)
            Class.forName(driver);

            //Inicializar o driver ja carregado por meio do metodo getConnection(IP,porta,nome do banco, usuario,senha)
            conb = DriverManager.getConnection(url, usuario, senha);
            return conb;

        } catch (SQLException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados: " + erro);
            return null;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
