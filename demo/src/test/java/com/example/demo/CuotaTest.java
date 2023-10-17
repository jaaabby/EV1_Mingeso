package com.example.demo;

import com.example.demo.entities.CuotaEntity;
import com.example.demo.repositories.CuotaRepository;
import com.example.demo.services.AdministradorService;
import com.example.demo.services.CuotaService;
import com.example.demo.services.EstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CuotaTest {
    @Autowired
    CuotaService cuotaService;
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    EstudianteService estudianteService;
    @Autowired
    AdministradorService administradorService;

    @Test
    void guardarCuota(){
        cuotaService.guardarCuota(1,270000.0,"PENDIENTE","20533473-4");
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        CuotaEntity cuota = cuotas.get(cuotas.size()-1);

        assertEquals(cuota.getNro_cuota(),1,0);
        assertEquals(cuota.getMonto(),270000.0,0.0);
        assertEquals(cuota.getEstado(),"PENDIENTE");
        assertEquals(cuota.getRut(),"20533473-4");

        cuotaService.eliminarCuota(cuota);
    }

    @Test
    void generarCuotas(){
        estudianteService.guardarEstudiante("20534473-3","Vergara Torres",
                "Julieta Aneley", LocalDate.of(2000,9,9),"SUBVENCIONADO",
                "CNSC",2020,"CUOTAS",5);
        cuotaService.generarCuotas("20534473-3");
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        for (int i = 0; i < cuotas.size(); i++){
            if(cuotas.get(i).getRut().equals("20534473-3")){
                assertEquals(i+1,cuotas.get(i).getNro_cuota());
                assertEquals(258000,cuotas.get(i).getMonto(),0.0);
                assertEquals("PENDIENTE",cuotas.get(i).getEstado());
                cuotaService.eliminarCuota(cuotas.get(i));
            }
        }
        estudianteService.eliminarEstudiante("20534473-3");

    }

    @Test
    void registrarPago(){
        estudianteService.guardarEstudiante("20534473-3","Vergara Torres",
                "Julieta Aneley", LocalDate.of(2000,9,9),"SUBVENCIONADO",
                "CNSC",2020,"CUOTAS",5);
        cuotaService.generarCuotas("20534473-3");
        cuotaService.registrarPago("20534473-3");
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        for(int i = 0; i < cuotas.size(); i++){
            if (cuotas.get(i).getRut().equals("20534473-3") && cuotas.get(i).getNro_cuota() == i + 1){
                assertEquals("PENDIENTE",cuotas.get(i).getEstado());
                break;
            }
        }
        for(int i = 0; i < cuotas.size(); i++){
            if (cuotas.get(i).getRut().equals("20534473-3")){
                cuotaService.eliminarCuota(cuotas.get(i));
            }
        }
        estudianteService.eliminarEstudiante("20534473-3");
    }
}
