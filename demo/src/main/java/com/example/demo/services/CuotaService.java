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

    public boolean existeCuota(String rut){
        ArrayList<CuotaEntity> cuotas = (ArrayList<CuotaEntity>) cuotaRepository.findAll();
        boolean existe = false;
        for(int i = 0; i < cuotas.size(); i++){
            if(cuotas.get(i).getRut().equals(rut)){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void generarCuotas(String rut){
        if(!existeCuota(rut)){
            int cantCuotas = estudianteService.obtenerCantCuotas(rut);
            double monto = administradorService.calcularValorPorCuota(estudianteService.findByRut(rut));
            for (int i = 1; i <= cantCuotas; i = i + 1){
                guardarCuota(i,monto,"PENDIENTE",rut);
            }
        }
    }

    public ArrayList<CuotaEntity> obtenerCuotasEstudiante(String rut) {
        return (ArrayList<CuotaEntity>) cuotaRepository.findCuotasEstudiante(rut);
    }

    public void registrarPago(String rut){
        int diaActual = LocalDate.now().getDayOfMonth();
        if(diaActual >= 5 && diaActual <= 10){
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
