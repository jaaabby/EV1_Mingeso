package com.example.demo;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.repositories.EstudianteRepository;
import com.example.demo.services.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class EstudianteTest {
    @Autowired
    EstudianteService estudianteService;
    @Autowired
    EstudianteRepository estudianteRepository;

    EstudianteEntity estudiante = new EstudianteEntity();
    @Test
    void guardarEstudiante(){
        estudianteService.guardarEstudiante("20533473-4","Vergara Torres",
                "Julieta Aneley", LocalDate.of(2000,9,9),"SUBVENCIONADO",
                "CNSC",2020,"CONTADO",0);
        ArrayList<EstudianteEntity> estudiantes = (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
        estudiante = estudiantes.get(estudiantes.size()-1);
        assertEquals("20532473-5",estudiante.getRut());
        assertEquals("Vergara Torres",estudiante.getApellidos());
        assertEquals("Julieta Aneley",estudiante.getNombres());
        assertEquals(LocalDate.of(2000,9,9),estudiante.getFecha_nac());
        assertEquals("SUBVENCIONADO",estudiante.getTipo_colegio());
        assertEquals("CNSC",estudiante.getNombre_colegio());
        assertEquals(2020,estudiante.getAño_egreso());
        assertEquals("CONTADO",estudiante.getTipo_pago());
        assertEquals(0,estudiante.getCant_cuotas());
        estudianteService.eliminarEstudiante(estudiante.getRut());
    }

    @Test
    void obtenerCantCuotas(){
        estudianteService.guardarEstudiante("20547473-5","Vergara Torres",
                "Julieta Aneley", LocalDate.of(2000,9,9),"SUBVENCIONADO",
                "CNSC",2020,"CUOTAS",5);
        Integer cantCuotas = estudianteService.obtenerCantCuotas("20547473-5");
        assertEquals(5,cantCuotas,0.0);
        estudianteService.eliminarEstudiante("20547473-5");
    }

    @Test
    void findByRut(){
        estudianteService.guardarEstudiante("20547483-5","Vergara Torres",
                "Colomba Pascale", LocalDate.of(2000,9,9),"SUBVENCIONADO",
                "CNSC",2020,"CUOTAS",5);
        estudiante = estudianteService.findByRut("20547483-5");

        assertEquals("20547483-5",estudiante.getRut());
        assertEquals("Vergara Torres",estudiante.getApellidos());
        assertEquals("Colomba Pascale",estudiante.getNombres());
        assertEquals(LocalDate.of(2000,9,9),estudiante.getFecha_nac());
        assertEquals("SUBVENCIONADO",estudiante.getTipo_colegio());
        assertEquals("CNSC",estudiante.getNombre_colegio());
        assertEquals(2020,estudiante.getAño_egreso());
        assertEquals("CUOTAS",estudiante.getTipo_pago());
        assertEquals(5,estudiante.getCant_cuotas());
        estudianteService.eliminarEstudiante(estudiante.getRut());
    }
    
}
