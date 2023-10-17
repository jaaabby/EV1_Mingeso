package com.example.demo.contollers;

import com.example.demo.entities.ExamenEntity;
import com.example.demo.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping("/listado-examenes")
    public String examenes(Model model){
        List<ExamenEntity> examenes = examenService.findAll();
        model.addAttribute("examenes", examenes);
        return "listado-examenes";
    }

    @GetMapping("/importar-notas")
    public String importar(){return "importar-notas";}

    @PostMapping("/importar-notas")
    public String importar(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        examenService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        examenService.leerCsv(file.getOriginalFilename());
        return "redirect:/importar-notas";
    }
}
