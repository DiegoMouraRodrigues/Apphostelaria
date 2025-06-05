package dao;

import model.Usuarios;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {

    //objeto para instanciar classe conexao para requisitar acesso ao db

    private Conexao conexao  = new Conexao();

    public boolean inserirUsuarios() {

        try{
            Connection conndb = conexao.conectar();

            PreparedStatement novoUsuario = conndb.prepareStatement("insert into Usuarios(nome, email, senha, id_perm_fk) values(?,?,md5(?), ?)");
            //setar os parametros
            novoUsuario.setString(1,"Matheus");
            novoUsuario.setString(2,"matheus@hotmail.com");
            novoUsuario.setString(3,"123");
            novoUsuario.setInt(4,1);

            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("erro ao inserir usuarios" + erro);
            return false;
        }
    }
}
