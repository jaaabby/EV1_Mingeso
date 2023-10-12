package com.example.demo;

import com.example.demo.entities.CuotaEntity;
import com.example.demo.repositories.CuotaRepository;
import com.example.demo.services.CuotaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CuotaTest {
    @Autowired
    CuotaService cuotaService;
    @Autowired
    CuotaRepository cuotaRepository;

    @Test
    void guardarCuota(){
        cuotaService.guardarCuota(1,270000.0,"PENDIENTE","20533473-4");
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        CuotaEntity cuota = cuotas.get(cuotas.size()-1);

        assertEquals(cuota.getNro_cuota(),1,0);
        assertEquals(cuota.getMonto(),270000.0,0.0);
        assertEquals(cuota.getEstado(),"PENDIENTE");
        assertEquals(cuota.getRut(),"20533473-4");

    }

    /*@Test
    void generarCuotas(){
        String rut = "20533473-4";

    }*/
}
