/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
public interface UsuarioDao {
    public Usuario agregar(Usuario usuario);
    public ArrayList<Usuario> mostrar();
    public boolean Validar(Usuario usuario);
    public void update(Usuario usuario);
}
