/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dominio.Roles;
import java.util.ArrayList;

/**
 *
 * @author Sony Laptop
 */
public interface RolesService {
    public Roles agregar(Roles rol);
    public ArrayList<Roles> mostrar();
    public boolean Validar(Roles rol);
}
