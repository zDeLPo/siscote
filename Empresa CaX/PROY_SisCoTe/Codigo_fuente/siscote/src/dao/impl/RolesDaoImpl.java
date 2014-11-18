/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Util.HibernateUtil;
import dao.RolesDao;
import dominio.Roles;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
public class RolesDaoImpl implements RolesDao{

    Session session = HibernateUtil.getSessionFactory().openSession();
    public Roles agregar(Roles rol) {
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(rol);
            session.beginTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return rol;
    }

    public ArrayList<Roles> mostrar() {
        ArrayList<Roles> roles = new ArrayList<Roles>();
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Roles");            
            roles = new ArrayList<Roles>((List<Roles>) query.list());           
            session.close();
            
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return roles;
    }

    public boolean Validar(Roles rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
