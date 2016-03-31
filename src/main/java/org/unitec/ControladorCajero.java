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
public class ControladorCajero {
    
    @CrossOrigin
    @RequestMapping(value="/cajero/{nombre}/{aPaterno}/{aMaterno}/{sueldo}",method = RequestMethod.POST,headers = {"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable String nombre,@PathVariable String aPaterno,@PathVariable String aMaterno,@PathVariable Float sueldo)throws Exception{
        DAOCajero daoc= new DAOCajero();
        Cajero c = new Cajero();
        c.setNombre(nombre);
        c.setAPaterno(aPaterno);
        c.setAMaterno(aMaterno);
        c.setSueldo(sueldo);
        daoc.guardarCajero(c);
        return "Cajero registrado con Exito";
    }
    
    @CrossOrigin
    @RequestMapping(value="/cajero/{idCajero}/{nombre}/{aPaterno}/{aMaterno}/{sueldo}",method = RequestMethod.PUT,headers = {"Accept=text/html"})
    @ResponseBody String actualizarCajero(@PathVariable Integer idCajero,@PathVariable String nombre,@PathVariable String aPaterno,@PathVariable String aMaterno,@PathVariable Float sueldo)throws Exception{
        DAOCajero daoc= new DAOCajero();
        Cajero c = new Cajero();
        c.setIdCajero(idCajero);
        c.setNombre(nombre);
        c.setAPaterno(aPaterno);
        c.setAMaterno(aMaterno);
        c.setSueldo(sueldo);
        daoc.actualizarCajero(c);
        return "Cajero actualizado con Exito";
    }
    
    @CrossOrigin
    @RequestMapping(value="/cajero/{idCajero}",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscarCajero(@PathVariable Integer idCajero)throws Exception{
        DAOCajero daoc= new DAOCajero();
        Cajero c = daoc.buscarPorIdCajero(idCajero);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(c);
    }
    
    
     @CrossOrigin
    @RequestMapping(value="/cajero",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscarTodosCajeros()throws Exception{
        DAOCajero daoc= new DAOCajero();
        ArrayList<Cajero> cajeros = daoc.buscarTodosCajero();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cajeros);
    }
    
     @CrossOrigin
    @RequestMapping(value="/cajero/{idCajero}",method = RequestMethod.DELETE,headers = {"Accept=text/html"})
    @ResponseBody String borrarCajero(@PathVariable Integer idCajero)throws Exception{
        DAOCajero daoc= new DAOCajero();
        daoc.eliminarCajero(idCajero);
        return "Cajero Eliminado";
    }
    
    
    
}
