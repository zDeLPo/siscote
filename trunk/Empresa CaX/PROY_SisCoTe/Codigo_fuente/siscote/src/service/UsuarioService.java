/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
public interface UsuarioService {
    public Usuario agregar(Usuario usuario);
    public ArrayList<Usuario> mostrar();
    public boolean Validar(String username, String password);
}
