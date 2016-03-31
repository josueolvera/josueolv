/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")
public class ControladorInicial {
    @RequestMapping("/")
    public String hola(){
        return "producto.html";
    }
}
