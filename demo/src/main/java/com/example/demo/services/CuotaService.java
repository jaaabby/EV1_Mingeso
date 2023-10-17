package com.example.demo.services;

import com.example.demo.entities.CuotaEntity;
import com.example.demo.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class CuotaService {
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    AdministradorService administradorService;
    @Autowired
    EstudianteService estudianteService;

    public void guardarCuota(Integer nro_cuota, Double monto, String estado, String rut){
        CuotaEntity cuota = new CuotaEntity();
        cuota.setNro_cuota(nro_cuota);
        cuota.setMonto(monto);
        cuota.setEstado(estado);
        cuota.setRut(rut);
        cuotaRepository.save(cuota);
    }

    public void generarCuotas(String rut){
        int cantCuotas = estudianteService.obtenerCantCuotas(rut);
        double monto = administradorService.calcularValorPorCuota(estudianteService.findByRut(rut));
        for (int i = 1; i <= cantCuotas; i = i + 1){
            guardarCuota(i,monto,"PENDIENTE",rut);
        }
    }

    public ArrayList<CuotaEntity> obtenerCuotasEstudiante(String rut) {
        return (ArrayList<CuotaEntity>) cuotaRepository.findCuotasEstudiante(rut);
    }

    public void registrarPago(String rut){
        int diaActual = LocalDate.now().getDayOfMonth();
        if(diaActual >= 17 && diaActual <= 20){
            ArrayList<CuotaEntity> cuotasEstudiante = obtenerCuotasEstudiante(rut);
            for (int i = 0; i < cuotasEstudiante.size();i++){
                CuotaEntity cuota = cuotasEstudiante.get(i);
                if (cuota.getEstado().equals("PENDIENTE")){
                    cuota.setEstado("PAGADO");
                    cuotaRepository.save(cuota);
                    break;
                }
            }
        }
    }

    public void eliminarCuota(CuotaEntity cuota){
        cuotaRepository.delete(cuota);
    }
}
