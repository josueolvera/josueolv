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
public class ControladorVenta {
     @CrossOrigin
    @RequestMapping(value="/venta/{idVenta}/{numTransaccion}/{ventasUnidades}/{idProducto}/{idFecha}/{idAlmacen}/{idCajero}",method = RequestMethod.POST,headers = {"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Integer numTransaccion,@PathVariable Integer ventasUnidades,@PathVariable Producto idProducto, @PathVariable Fecha idFecha,@PathVariable Almacen idAlmacen, @PathVariable Cajero idCajero)throws Exception{
     DAOVenta d=new DAOVenta();
     Venta v=new Venta();
     v.setNumTransaccion();
        v.setIdProducto(new Producto(idProducto));
        v.setIdAlmacen(new Almacen(1));
      
        d.guardarVenta(v);
        return "Fecha registrado con Exito";
    }
    
    
}
