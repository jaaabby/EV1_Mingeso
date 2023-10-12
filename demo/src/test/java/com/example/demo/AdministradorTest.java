package com.example.demo;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.services.AdministradorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdministradorTest {

    @Autowired
    AdministradorService administradorService;
    EstudianteEntity estudiante = new EstudianteEntity();

    @Test
    void calcularDescuentoPorTipoPago(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFecha_nac(new Date(2000,9,16));
        estudiante.setTipo_colegio("SUBVENCIONADO");
        estudiante.setNombre_colegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAño_egreso(2018);
        estudiante.setTipo_pago("CONTADO");
        estudiante.setCant_cuotas(0);

        double descuento = administradorService.calcularDescuentoPorTipoPago(estudiante);
        assertEquals(0.5,descuento,0.0);
    }

    @Test
    void calcularDescuentoPorTipoColegio(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFecha_nac(new Date(2000,9,16));
        estudiante.setTipo_colegio("SUBVENCIONADO");
        estudiante.setNombre_colegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAño_egreso(2018);
        estudiante.setTipo_pago("CONTADO");
        estudiante.setCant_cuotas(0);

        double descuento = administradorService.calcularDescuentoPorTipoColegio(estudiante);
        assertEquals(0,descuento,0.0);
    }

    @Test
    void calcularDescuentoPorAñosDeEgreso(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFecha_nac(new Date(2000,9,16));
        estudiante.setTipo_colegio("SUBVENCIONADO");
        estudiante.setNombre_colegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAño_egreso(2018);
        estudiante.setTipo_pago("CUOTAS");
        estudiante.setCant_cuotas(5);

        double descuento = administradorService.calcularDescuentoPorAñosDeEgreso(estudiante);
        assertEquals(0,descuento,0.0);
    }

    @Test
    void calcularValorPorCuota(){
        estudiante.setRut("20533473-4");
        estudiante.setNombres("Javiera Paz");
        estudiante.setApellidos("Vergara Salinas");
        estudiante.setFecha_nac(new Date(2000,9,16));
        estudiante.setTipo_colegio("SUBVENCIONADO");
        estudiante.setNombre_colegio("Colegio Nuestra Señora del Carmen");
        estudiante.setAño_egreso(2018);
        estudiante.setTipo_pago("CUOTAS");
        estudiante.setCant_cuotas(5);

        double valorPorCuota = administradorService.calcularValorPorCuota(estudiante);
        assertEquals(270000,valorPorCuota,0.0);
    }
}
