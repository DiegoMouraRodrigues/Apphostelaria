package dao;

import model.Pedidos;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {

    private Conexao conexao = new Conexao();
    public boolean inserirPedidos() {

        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novosPedidos = conndb.prepareStatement("insert into Pedidos(id_usuario_fk, id_cliente_fk, pagamento) values (?,?,?);");

            novosPedidos.setInt(1,3);
            novosPedidos.setInt(2,2);
            novosPedidos.setString(3,"pix");

            int linhaAfetada = novosPedidos.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("erro ao inserir o pedidos" + erro);
            return false;
        }
    }

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
            System.out.println("Erro ao deletar os pedidos " + erro);
            return false;
        }
    }

    public boolean alterarPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pedidoAlterado = conndb.prepareStatement("update pedidos Set id_usuario_fk = ?, id_cliente_fk = ?, pagamento = ? where id = ?");

            pedidoAlterado.setInt(1,3);
            pedidoAlterado.setInt(2,2);
            pedidoAlterado.setString(3,"debito");
            pedidoAlterado.setInt(4,1);


            int linhaAlterada = pedidoAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao alterar os pedidos" + erro);
            return false;
        }
    }

    public void pesquisarPedidos() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarPedidos = conndb.prepareStatement("select pagamento from Pedidos  where id_usuario_fk = ?, id_cliente_fk = ? ");
            buscarPedidos.setInt(1,1);
            ResultSet resultado = buscarPedidos.executeQuery();

            while (resultado.next()){
                String pagamento = resultado.getString("pagamento");
                System.out.println("pagamento: " + pagamento);
            }
            conndb.close();
        }
        catch (Exception erro){
            System.out.println("Erro ao pesquisar o pedido" + erro);
        }
    }
}
