package com.example.demo.contollers;

import com.example.demo.services.CuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CuotaController {
    @Autowired
    private CuotaService cuotaService;

    @GetMapping("/generar-cuotas")
    public String estudiante() {return "generar-cuotas";}

    @PostMapping("/generar-cuotas")
    public String generarCuotasEstudiante(@RequestParam("rut") String rut){
        cuotaService.generarCuotas(rut);
        return "redirect:/generar-cuotas";
    }
}
