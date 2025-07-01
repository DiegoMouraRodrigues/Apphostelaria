package controller;

import dao.UsuariosDAO;
import model.Usuarios;

public class UsuariosController {
    private final UsuariosDAO usuariosDao;


    //Contrutor para inicializar objeto
    //Ao inicializa-lo, o construtor de UsuariosDao() sera executado
    //o que significa quea a camada de controle estara verificando se os parametros
    //necessarios foram informados para que sejam enviadas as requisitos (package DAO -data Acess Object)

    public UsuariosController() {
        this.usuariosDao = new UsuariosDAO();
    }

    //metodo para verificar se os parametros necessarios para autentificação
    //estao presentes, ou seja não podem ser vazios ou nulos; se estiverem um
    //objeto de Usuarios e inicializado como uma instancia

    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false; }
            Usuarios usuarios = new Usuarios("", email, senha, 0);
            return usuariosDao.autenticarUsuario(usuarios);
        }
    }

