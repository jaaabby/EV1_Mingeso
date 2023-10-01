package com.example.demo.services;

import com.example.demo.entities.CuotaEntity;
import com.example.demo.repositories.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuotaService {
    @Autowired
    CuotaRepository cuotaRepository;

    public void guardarCuota(Integer nro_cuota, Double monto, String estado, String rut){
        CuotaEntity cuota = new CuotaEntity();
        cuota.setNro_cuota(nro_cuota);
        cuota.setMonto(monto);
        cuota.setEstado(estado);
        cuota.setRut(rut);
        cuotaRepository.save(cuota);
    }
}
