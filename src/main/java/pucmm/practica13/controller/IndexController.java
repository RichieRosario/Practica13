package pucmm.practica13.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.practica13.model.Mensaje;
import pucmm.practica13.service.MensajeServiceImpl;

import java.time.LocalDate;
import java.util.*;

import static pucmm.practica13.Practica13.dispositivo1;
import static pucmm.practica13.Practica13.dispositivo2;

@Controller
public class IndexController {


    @Autowired
    MensajeServiceImpl mensajeService;

    @RequestMapping(value = "/")
    public String index(Model model)
    {



        model.addAttribute("practicas");

        return "index";
    }

    @GetMapping("/temp1")
    @ResponseBody
    public Mensaje getTemperatura1() {
        List<Mensaje> todos = mensajeService.BuscarTodos();
        List<Mensaje> m1 = new ArrayList<>();
        for(Mensaje m : todos){
            if(Integer.toString(m.getIdDispositivo()).equals(dispositivo1)){
                    m1.add(m);
            }
        }

        Mensaje last1 = m1.get(m1.size()-1);
        return last1;
    }


    @GetMapping("/temp2")
    @ResponseBody
    public Mensaje getTemperatura2() {
        List<Mensaje> todos = mensajeService.BuscarTodos();
        List<Mensaje> m2 = new ArrayList<>();
        for(Mensaje m : todos){
            if(Integer.toString(m.getIdDispositivo()).equals(dispositivo2)){
                m2.add(m);
            }
        }

        Mensaje last2 = m2.get(m2.size()-1);
        return last2;
    }



}
