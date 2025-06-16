package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean deleteReserva() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement deleteReserva = conndb.prepareStatement("DELETE FROM reservas WHERE id = ?");
            deleteReserva.setInt(1,1);

            int linhaAfetada = deleteReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao deletar a reservas" + erro);
            return false;
        }
    }

    public boolean alterarReservas() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement reservaAlterado = conndb.prepareStatement("update reservas Set  where id = ?");


            reservaAlterado.setInt(5,6);

            int linhaAlterada = reservaAlterado.executeUpdate();
            conndb.close();
            return linhaAlterada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao alterar reservas" + erro);
            return false;
        }
    }

    public void pesquisarReservas() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarReserva = conndb.prepareStatement("select  from Reservas where id = ?");
            buscarReserva.setInt(1,1);
            ResultSet resultado = buscarReserva.executeQuery();

            while (resultado.next()){

                System.out.println();
            }
            conndb.close();
        }
        catch (Exception erro){
            System.out.println("Erro ao pesquisar a reserva" + erro);
        }
    }

    public void pesquisarReserva() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarReservas = conndb.prepareStatement("select  from reservas where ");
            buscarReservas.setInt(1,1);
            ResultSet resultado = buscarReservas.executeQuery();

            while (resultado.next()){

            }
            conndb.close();
        }
        catch (Exception erro){
            System.out.println("Erro ao pesquisar a reserva" + erro);
        }
    }
}
