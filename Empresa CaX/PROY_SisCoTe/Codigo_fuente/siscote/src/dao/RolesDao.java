/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Roles;
import java.util.ArrayList;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
public interface RolesDao {
    public Roles agregar(Roles rol);
    public ArrayList<Roles> mostrar();
    public boolean Validar(Roles rol);
}
