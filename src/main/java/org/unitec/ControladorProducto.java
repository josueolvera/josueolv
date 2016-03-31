/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JOSUE
 */
@Controller
@RequestMapping("/")
public class ControladorProducto {
    @CrossOrigin
    @RequestMapping(value="/producto/{descripcion}/{marca}/{categoria}/{precio}", method = RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable String descripcion, @PathVariable String marca,@PathVariable String categoria,@PathVariable Float precio)throws Exception{
        DAOProducto daop = new DAOProducto();
        Producto p = new Producto();
        p.setDescripcion(descripcion);
        p.setMarca(marca);
        p.setCategoria(categoria);
        p.setPrecio(precio);
        
        daop.guardarProducto(p);
        return "Producto Guardado con Exito";
        
        
       
    }
    
    @CrossOrigin
    @RequestMapping(value="/producto/{idProducto}/{descripcion}/{marca}/{categoria}/{precio}",method= RequestMethod.PUT, headers={"Accept=text/html"})
    
    @ResponseBody String actualizar (@PathVariable Integer idProducto,@PathVariable String descripcion, @PathVariable String marca,@PathVariable String categoria,@PathVariable Float precio)throws Exception{
        DAOProducto daop = new DAOProducto();
        Producto p = new Producto();
        p.setIdProducto(idProducto);
         p.setDescripcion(descripcion);
        p.setMarca(marca);
        p.setCategoria(categoria);
        p.setPrecio(precio);
        
        daop.actualizarProducto(p);
        
        
        return "Producto Actualizado con Exito ";
    
    }
    @CrossOrigin
    @RequestMapping(value="/producto/{idProducto}", method= RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscarProducto(@PathVariable Integer idProducto)throws Exception{
        DAOProducto daop = new DAOProducto();
        Producto p = daop.buscarPorIdProducto(idProducto);
       ObjectMapper mapper = new ObjectMapper();
       return mapper.writeValueAsString(p);
        
    }
    @CrossOrigin
    @RequestMapping(value="/producto", method= RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscarTodosProducto()throws Exception{
        DAOProducto daop = new DAOProducto();
       ArrayList<Producto> productos = daop.buscarTodosProducto();
       ObjectMapper mapper = new ObjectMapper();
       return mapper.writeValueAsString(productos);
        
    }
    
    @CrossOrigin
    @RequestMapping(value="/producto/{idProducto}", method= RequestMethod.GET,headers={"Accept=text/html"})
    @ResponseBody String borrarProducto(@PathVariable Integer idProducto)throws Exception{
        DAOProducto daop = new DAOProducto();
        daop.eliminarProducto(idProducto);
    
       return "Objeto borrado con exito";
        
    }
    
 
    
    
    
    
}
