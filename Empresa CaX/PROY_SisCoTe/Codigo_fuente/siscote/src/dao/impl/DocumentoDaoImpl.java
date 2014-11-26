/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Util.HibernateUtil;
import dao.DocumentoDao;
import dominio.Documento;
import java.util.ArrayList;
import java.util.List;
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
@Repository("documentoDao")
@Transactional
public class DocumentoDaoImpl implements DocumentoDao{

    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public Documento agregar(Documento documento) {
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(documento);
            session.beginTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return documento;
    }

    public ArrayList<Documento> mostrar() {
        ArrayList<Documento> documentos = new ArrayList<Documento>();
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Documento");            
            documentos = new ArrayList<Documento>((List<Documento>) query.list());
            session.close();
            
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        return documentos;
    }
    
    public void update(Documento documento){
        
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(documento);
            
            System.out.println("Cambio "+documento.isEstado()+ documento.getIdDocumento());
            
            tx.commit();
            session.close();
            
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }        
    }

    public boolean Validar(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
