package dao;

import model.Usuarios;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

    //objeto para instanciar classe conexao para requisitar acesso ao db

    private Conexao conexao = new Conexao();

    public boolean inserirUsuarios() {

        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novoUsuario = conndb.prepareStatement("insert into Usuarios(nome, email, senha, id_perm_fk) values(?,?,md5(?), ?)");
            //setar os parametros
            novoUsuario.setString(1, "luis");
            novoUsuario.setString(2, "luis@hotmail.com");
            novoUsuario.setString(3, "1234");
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close(); //Encerrar conexão apos insersão
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("erro ao inserir usuarios" + erro);
            return false;
        }
    }

    public boolean deleteUsuarios() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement removeUsuarios = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            removeUsuarios.setInt(1, 6);


            int linhaAfetada = removeUsuarios.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuarios" + erro);
            return false;
        }
    }

    public boolean alterarUsuarios() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement usuarioAlterado = conndb.prepareStatement("update usuarios Set nome = ?, email = ?, senha = md5(?), id_perm_fk = ? where id = ?");

            usuarioAlterado.setString(1, "beatrice");
            usuarioAlterado.setString(2, "beatrice@hotmail.com");
            usuarioAlterado.setString(3, "1235");
            usuarioAlterado.setInt(4, 1);
            usuarioAlterado.setInt(5, 6);

            int linhaAlterada = usuarioAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar usuarios" + erro);
            return false;
        }
    }

    //query Select
    public void pesquisarUsuarios() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarUsuario = conndb.prepareStatement("select nome, email from usuarios where id_perm_fk = ?");
            buscarUsuario.setInt(1, 1);
            ResultSet resultado = buscarUsuario.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                System.out.println("nome: " + nome + " email: " + email);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario" + erro);
        }
    }

    public boolean autenticarUsuario(Usuarios usuario) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement stmt = conndb.prepareStatement("SELECT nome FROM usuarios WHERE email = ? AND senha = md5(?);");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet resultado = stmt.executeQuery();

            boolean acessoAutenticado = resultado.next();
                String nome = resultado.getString("nome");
                System.out.println("ola, seja bem vindo " + nome );
            conndb.close();
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao autenticar usuario" + erro);
            return false;
        }
    }
}
