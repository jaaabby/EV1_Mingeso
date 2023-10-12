package com.example.demo;

import com.example.demo.entities.CuotaEntity;
import com.example.demo.entities.EstudianteEntity;
import com.example.demo.repositories.EstudianteRepository;
import com.example.demo.services.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EstudianteTest {

    @Autowired
    EstudianteService estudianteService;
    @Autowired
    EstudianteRepository estudianteRepository;

    /*@Test
    void guardarEstudiante(){
        estudianteService.guardarEstudiante("20533473-5","Vergara Torres",
                "Julieta Aneley",new Date(2000,9,9),"SUBVENCIONADO",
                "CNSC",2020,"CONTADO",0);
        ArrayList<EstudianteEntity> estudiantes = (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
        EstudianteEntity estudiante = estudiantes.get(estudiantes.size()-1);

        assertEquals(estudiante.getRut(),"20533473-5");
        assertEquals(estudiante.getApellidos(),"Vergara Torres");
        assertEquals(estudiante.getNombres(),"Julieta Aneley");
        assertEquals(estudiante.getFecha_nac(),new Date(2000,9,9));
        assertEquals(estudiante.getTipo_colegio(),"SUBVENCIONADO");
        assertEquals(estudiante.getNombre_colegio(),"CNSC");
        assertEquals(estudiante.getAño_egreso(),2020);
        assertEquals(estudiante.getTipo_pago(),"CONTADO");
        assertEquals(estudiante.getCant_cuotas(),0);
    }*/
}
