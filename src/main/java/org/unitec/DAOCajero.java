/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JOSUE
 */
public class DAOCajero {
      SessionFactory fac;
    Session ses;
    Transaction tranza;
    
    public DAOCajero(){
        fac= HibernateUtilidades.getSessionFactory();
        ses = fac.openSession();
        tranza = ses.beginTransaction();
        
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    public void guardarCajero(Cajero p) throws Exception{
        ses.save(p);
        cerrarSesion();
    }
    
    public void actualizarCajero(Cajero p) throws Exception{
        ses.update(p);
        cerrarSesion();
    }
    
    public Cajero buscarPorIdCajero(Integer id) throws Exception{
        Cajero p = (Cajero) ses.createCriteria(Cajero.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return p;
    }
    
    public void eliminarCajero(Integer id)throws Exception{
        Cajero p = (Cajero) ses.createCriteria(Cajero.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(p);
        cerrarSesion();
    }
    
    public ArrayList<Cajero> buscarTodosCajero() throws Exception{
        Criteria cri = ses.createCriteria(Cajero.class);
        ArrayList<Cajero> cajeros = (ArrayList<Cajero>) cri.list();
        cerrarSesion();
        return cajeros;
    }
    
    
}
