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
public class DAOAlmacen {
      SessionFactory fac;
    Session ses;
    Transaction tranza;
    
    public DAOAlmacen(){
        fac= HibernateUtilidades.getSessionFactory();
        ses = fac.openSession();
        tranza = ses.beginTransaction();
        
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    public void guardarAlmacen(Almacen p) throws Exception{
        ses.save(p);
        cerrarSesion();
    }
    
    public void actualizarAlmacen(Almacen p) throws Exception{
        ses.update(p);
        cerrarSesion();
    }
    
    public Almacen buscarPorIdAlmacen(Integer id) throws Exception{
        Almacen p = (Almacen) ses.createCriteria(Almacen.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return p;
    }
    
    public void eliminarAlmacen(Integer id)throws Exception{
        Almacen p = (Almacen) ses.createCriteria(Almacen.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(p);
        cerrarSesion();
    }
    
    public ArrayList<Almacen> buscarTodosAlmacen() throws Exception{
        Criteria cri = ses.createCriteria(Almacen.class);
        ArrayList<Almacen> almacenes = (ArrayList<Almacen>) cri.list();
        cerrarSesion();
        return almacenes;
    }
    
    
}
