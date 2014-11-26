/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Documento;
import java.util.ArrayList;

/**
 *
 * @author CENTRO PRODUCCIÓN
 */
public interface DocumentoDao {
    public Documento agregar(Documento documento);
    public ArrayList<Documento> mostrar();
    public boolean Validar(Documento documento);
    public void update(Documento documento);
}
