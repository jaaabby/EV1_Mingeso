package com.example.demo;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.services.AdministradorService;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministradorTest {

    AdministradorService administradorService = new AdministradorService();
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
        estudiante.setTipo_pago("CUOTAS");
        estudiante.setCant_cuotas(5);

        double descuento = administradorService.calcularDescuentoPorTipoPago(estudiante);
        assertEquals(0,descuento,0.0);
    }
}
