package pucmm.practica13.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.practica13.service.MensajeServiceImpl;

import java.time.LocalDate;
import java.util.*;

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


}
