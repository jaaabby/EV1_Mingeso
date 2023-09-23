package com.example.demo.contollers;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/listar")
    public String listar(Model model){
        ArrayList<EstudianteEntity>estudiante=estudianteService.obtenerEstudiantes();
        model.addAttribute("estudiante",estudiante);
        return "index";
    }
}
