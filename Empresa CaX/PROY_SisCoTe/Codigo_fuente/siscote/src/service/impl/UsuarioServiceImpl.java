/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dominio.Usuario;
import java.util.ArrayList;
import service.UsuarioService;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
public class UsuarioServiceImpl implements UsuarioService{
    UsuarioDao usuarioDao = new UsuarioDaoImpl();

    public Usuario agregar(Usuario usuario) {
        return usuarioDao.agregar(usuario);
    }

    public ArrayList<Usuario> mostrar() {
        return usuarioDao.mostrar();
    }

    public boolean Validar(String username, String password) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        return usuarioDao.Validar(usuario);
    }
}
