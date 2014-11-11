/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Util.HibernateUtil;
import dao.UsuarioDao;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
@Repository("usuarioDao")
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{

    Session session = HibernateUtil.getSessionFactory().openSession();
    public Usuario agregar(Usuario usuario) {
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(usuario);
            session.beginTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return usuario;
    }

    public ArrayList<Usuario> mostrar() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Usuario");            
            usuarios = new ArrayList<Usuario>((List<Usuario>) query.list());
            for(Usuario u : usuarios){
                Hibernate.initialize(u.getRoles());
            }
           
            session.close();
            
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return usuarios;
    }
    
    public void update(Usuario usuario){
        
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(usuario);
            System.out.println("Cambio "+usuario.isEstado()+ usuario.getIdUsuario());
            tx.commit();
            session.close();
            
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }        
    }

    public boolean Validar(Usuario usuario) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Usuario WHERE username=:username AND"
                    + " password=:password")
                    .setParameter("username", usuario.getUsername())
                    .setParameter("password", usuario.getPassword());
            if (query.uniqueResult() != null) {
                usuario = (Usuario) query.uniqueResult();
            } else {
                usuario = null;
            }
            session.close();
            if(usuario != null){
                return true;
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
}
