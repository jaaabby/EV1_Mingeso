package com.example.demo.services;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public boolean existeEstudiante(String rut){
        ArrayList<EstudianteEntity> estudiantes = (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
        boolean existe = false;
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getRut().equals(rut)){
                existe = true;
            }
        }
        return existe;
    }
    public void guardarEstudiante(String rut, String apellidos, String nombres, LocalDate fecha_nac,
                                  String tipo_colegio, String nombre_colegio, Integer año_egreso,
                                  String tipo_pago, Integer cant_cuotas){
        if(!existeEstudiante(rut)){
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
    }

    public int obtenerCantCuotas(String rut){
        if (existeEstudiante(rut)){
            return estudianteRepository.findCantCuotas(rut);
        }
        return 0;
    }

    public EstudianteEntity findByRut(String rut){
        if (existeEstudiante(rut)){
            return estudianteRepository.findByRut(rut);
        }
        return null;
    }

    public void eliminarEstudiante(String rut){
        EstudianteEntity estudiante = findByRut(rut);
        estudianteRepository.delete(estudiante);
    }
}
