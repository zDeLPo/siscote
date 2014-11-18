/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.RolesDao;
import dao.impl.RolesDaoImpl;
import dominio.Roles;
import java.util.ArrayList;
import service.RolesService;

/**
 *
 * @author Sony Laptop
 */
public class RolesServiceImpl implements RolesService{

    RolesDao rolesDao = new RolesDaoImpl();
    public Roles agregar(Roles rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Roles> mostrar() {
        return rolesDao.mostrar();
    }

    public boolean Validar(Roles rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
