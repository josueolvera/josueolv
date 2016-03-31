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
public class DAOProducto {
    SessionFactory fac;
    Session ses;
    Transaction tranza;
    
    public DAOProducto(){
        fac= HibernateUtilidades.getSessionFactory();
        ses = fac.openSession();
        tranza = ses.beginTransaction();
        
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    public void guardarProducto(Producto p) throws Exception{
        ses.save(p);
        cerrarSesion();
    }
    
    public void actualizarProducto(Producto p) throws Exception{
        ses.update(p);
        cerrarSesion();
    }
    
    public Producto buscarPorIdProducto(Integer id) throws Exception{
        Producto p = (Producto) ses.createCriteria(Producto.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return p;
    }
    
    public void eliminarProducto(Integer id)throws Exception{
        Producto p = (Producto) ses.createCriteria(Producto.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(p);
        cerrarSesion();
    }
    
    public ArrayList<Producto> buscarTodosProducto() throws Exception{
        Criteria cri = ses.createCriteria(Producto.class);
        ArrayList<Producto> productos = (ArrayList<Producto>) cri.list();
        cerrarSesion();
        return productos;
    }
    
    
    
}
