package com.example.demo.contollers;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/ingresar-estudiante")
    public String estudiante() {return "ingresar-estudiante";}
    @PostMapping("/ingresar-estudiante")
    public String nuevoEstudiante(@RequestParam("rut") String rut,
                                  @RequestParam("apellidos") String apellidos,
                                  @RequestParam("nombres") String nombres,
                                  @RequestParam("fecha_nac") LocalDate fecha_nac,
                                  @RequestParam("tipo_colegio") String tipo_colegio,
                                  @RequestParam("nombre_colegio") String nombre_colegio,
                                  @RequestParam("año_egreso") Integer año_egreso,
                                  @RequestParam("tipo_pago") String tipo_pago,
                                  @RequestParam("cant_cuotas") Integer cant_cuotas){
        estudianteService.guardarEstudiante(rut,apellidos,nombres,fecha_nac,tipo_colegio,nombre_colegio,año_egreso,tipo_pago,cant_cuotas);
        return "redirect:/ingresar-estudiante";
    }

}
