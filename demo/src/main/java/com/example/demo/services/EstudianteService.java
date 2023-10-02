package com.example.demo.services;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    /*public ArrayList<EstudianteEntity> obtenerEstudiantes(){
        return (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
    }*/
    public void guardarEstudiante(String rut, String apellidos, String nombres, Date fecha_nac,
                                  String tipo_colegio, String nombre_colegio, Integer año_egreso,
                                  String tipo_pago, Integer cant_cuotas){
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setRut(rut);
        estudiante.setApellidos(apellidos);
        estudiante.setNombres(nombres);
        estudiante.setFecha_nac(fecha_nac);
        estudiante.setTipo_colegio(tipo_colegio);
        estudiante.setNombre_colegio(nombre_colegio);
        estudiante.setAño_egreso(año_egreso);
        estudiante.setTipo_pago(tipo_pago);
        estudiante.setCant_cuotas(cant_cuotas);
        estudianteRepository.save(estudiante);
    }

    public int obtenerCantCuotas(String rut){return estudianteRepository.findCantCuotas(rut);}

    public EstudianteEntity findByRut(String rut){return estudianteRepository.findByRut(rut);}
}
