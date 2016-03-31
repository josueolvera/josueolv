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
public class DAOFecha {
      SessionFactory fac;
    Session ses;
    Transaction tranza;
    
    public DAOFecha(){
        fac= HibernateUtilidades.getSessionFactory();
        ses = fac.openSession();
        tranza = ses.beginTransaction();
        
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    public void guardarFecha(Fecha p) throws Exception{
        ses.save(p);
        cerrarSesion();
    }
    
    public void actualizarFecha(Fecha p) throws Exception{
        ses.update(p);
        cerrarSesion();
    }
    
    public Fecha buscarPorIdFecha(Integer id) throws Exception{
        Fecha p = (Fecha) ses.createCriteria(Fecha.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return p;
    }
    
    public void eliminarFecha(Integer id)throws Exception{
        Fecha p = (Fecha) ses.createCriteria(Fecha.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(p);
        cerrarSesion();
    }
    
    public ArrayList<Fecha> buscarTodosFecha() throws Exception{
        Criteria cri = ses.createCriteria(Fecha.class);
        ArrayList<Fecha> fechas = (ArrayList<Fecha>) cri.list();
        cerrarSesion();
        return fechas;
    }
    
    
}
