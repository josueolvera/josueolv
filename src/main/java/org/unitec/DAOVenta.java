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
public class DAOVenta {
      SessionFactory fac;
    Session ses;
    Transaction tranza;
    
    public DAOVenta(){
        fac= HibernateUtilidades.getSessionFactory();
        ses = fac.openSession();
        tranza = ses.beginTransaction();
        
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    public void guardarVenta(Venta p) throws Exception{
        ses.save(p);
        cerrarSesion();
    }
    
    public void actualizarVenta(Venta p) throws Exception{
        ses.update(p);
        cerrarSesion();
    }
    
    public Venta buscarPorIdVenta(Integer id) throws Exception{
        Venta p = (Venta) ses.createCriteria(Venta.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return p;
    }
    
    public void eliminarVenta(Integer id)throws Exception{
        Venta p = (Venta) ses.createCriteria(Venta.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(p);
        cerrarSesion();
    }
    
    public ArrayList<Venta> buscarTodosVenta() throws Exception{
        Criteria cri = ses.createCriteria(Venta.class);
        ArrayList<Venta> ventas= (ArrayList<Venta>) cri.list();
        cerrarSesion();
        return ventas;
    }
    
    
}
