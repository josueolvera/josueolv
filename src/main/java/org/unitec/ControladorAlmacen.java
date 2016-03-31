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
public class ControladorAlmacen {
     @CrossOrigin
    @RequestMapping(value="/almacen/{numero}/{nombre}/{estado}/{municipio}",method = RequestMethod.POST,headers = {"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Integer numero,@PathVariable String nombre,@PathVariable String estado,@PathVariable String municipio)throws Exception{
        DAOAlmacen daoa= new DAOAlmacen();
        Almacen a = new Almacen();
        a.setNumero(numero);
        a.setNombre(nombre);
        a.setEstado(estado);
        a.setMunicipio(municipio);
        daoa.guardarAlmacen(a);
        return "Almacen registrado con Exito";
    }
    
    @CrossOrigin
    @RequestMapping(value="/almacen/{idAlmacen}/{numero}/{nombre}/{estado}/{municipio}",method = RequestMethod.PUT,headers = {"Accept=text/html"})
    @ResponseBody String actualizarAlmacen(@PathVariable Integer idAlmacen,@PathVariable Integer numero,@PathVariable String nombre,@PathVariable String estado,@PathVariable String municipio)throws Exception{
        
      DAOAlmacen daoa= new DAOAlmacen();
        Almacen a = new Almacen();
        a.setIdAlmacen(idAlmacen);
        a.setNumero(numero);
        a.setNombre(nombre);
        a.setEstado(estado);
        a.setMunicipio(municipio);
        daoa.actualizarAlmacen(a);
        return "Almacen actualizado con Exito";
    }
    
    @CrossOrigin
    @RequestMapping(value="/almacen/{idAlmacen}",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscarAlmacen(@PathVariable Integer idAlmacen)throws Exception{
        DAOAlmacen daoa= new DAOAlmacen();
        Almacen a = daoa.buscarPorIdAlmacen(idAlmacen);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(a);
    }
    
    
     @CrossOrigin
    @RequestMapping(value="/almacen",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscarTodosAlmacens()throws Exception{
        DAOAlmacen daoa= new DAOAlmacen();
        ArrayList<Almacen> almacens = daoa.buscarTodosAlmacen();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(almacens);
    }
    
     @CrossOrigin
    @RequestMapping(value="/almacen/{idAlmacen}",method = RequestMethod.DELETE,headers = {"Accept=text/html"})
    @ResponseBody String borrarAlmacen(@PathVariable Integer idAlmacen)throws Exception{
        DAOAlmacen daoa= new DAOAlmacen();
        daoa.eliminarAlmacen(idAlmacen);
        return "Almacen Eliminado";
    }
    
    
    
}

    

