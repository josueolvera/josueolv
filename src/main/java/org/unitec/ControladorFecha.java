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

public class ControladorFecha {
    
     @CrossOrigin
    @RequestMapping(value="/fecha/{dia}/{mes}/{anio}",method = RequestMethod.POST,headers = {"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Integer dia,@PathVariable Integer mes,@PathVariable Integer anio)throws Exception{
        DAOFecha daof= new DAOFecha();
        Fecha f = new Fecha();
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);
        daof.guardarFecha(f);
        return "Fecha registrado con Exito";
    }
    
    @CrossOrigin
    @RequestMapping(value="/fecha/{idFecha}/{dia}/{mes}/{anio}",method = RequestMethod.PUT,headers = {"Accept=text/html"})
    @ResponseBody String actualizarFecha(@PathVariable Integer idFecha,@PathVariable Integer dia,@PathVariable Integer mes,@PathVariable Integer anio)throws Exception{
        
      DAOFecha daof= new DAOFecha();
        Fecha f = new Fecha();
        f.setIdFecha(idFecha);
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);
        daof.actualizarFecha(f);
        return "Fecha actualizado con Exito";
    }
    
    @CrossOrigin
    @RequestMapping(value="/fecha/{idFecha}",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscarFecha(@PathVariable Integer idFecha)throws Exception{
        DAOFecha daof= new DAOFecha();
        Fecha a = daof.buscarPorIdFecha(idFecha);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(a);
    }
    
    
     @CrossOrigin
    @RequestMapping(value="/fecha",method = RequestMethod.GET,headers = {"Accept=application/json"})
    @ResponseBody String buscarTodosFechas()throws Exception{
        DAOFecha daof= new DAOFecha();
        ArrayList<Fecha> fechas = daof.buscarTodosFecha();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(fechas);
    }
    
     @CrossOrigin
    @RequestMapping(value="/fecha/{idFecha}",method = RequestMethod.DELETE,headers = {"Accept=text/html"})
    @ResponseBody String borrarFecha(@PathVariable Integer idFecha)throws Exception{
        DAOFecha daof= new DAOFecha();
        daof.eliminarFecha(idFecha);
        return "Fecha Eliminado";
    }
    
    
}
