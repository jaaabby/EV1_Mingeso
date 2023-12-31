package com.example.demo.services;

import com.example.demo.entities.EstudianteEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AdministradorService {

    //Calcula el descuento según el tipo de pago
    //CONTADO: 50% de descuento; caso contrario 0%
    public double calcularDescuentoPorTipoPago(EstudianteEntity estudiante){
        double descuentoPorTipoPago = 0;
        if(estudiante.getTipo_pago().equals("CONTADO")){
            descuentoPorTipoPago = 0.5;
        }
        return descuentoPorTipoPago;
    }

    //Calcula el descuento según el tipo de colegio
    //MUNICIPAL: 20% de descuento
    //SUBVENCIONADO: 10% de descuento
    //PRIVADO: 0% de descuento
    public double calcularDescuentoPorTipoColegio(EstudianteEntity estudiante){
        double descuentoPorTipoColegio = 0;
        if(estudiante.getTipo_pago().equals("CONTADO")){
            return descuentoPorTipoColegio;
        }else{
            if(estudiante.getTipo_colegio().equals("MUNICIPAL")){
                descuentoPorTipoColegio = 0.2;
            } else if (estudiante.getTipo_colegio().equals("SUBVENCIONADO")) {
                descuentoPorTipoColegio = 0.1;
            }
        }
        return descuentoPorTipoColegio;
    }

    public double calcularDescuentoPorAñosDeEgreso(EstudianteEntity estudiante){
        int cantidadAñosDeEgreso = LocalDateTime.now().getYear() - estudiante.getAño_egreso();
        double descuentoPorAñosDeEgreso = 0;
        if(estudiante.getTipo_pago().equals("CONTADO")){
            return descuentoPorAñosDeEgreso;
        }else{
            if (cantidadAñosDeEgreso == 0){
                descuentoPorAñosDeEgreso = 0.15;
            } else if (cantidadAñosDeEgreso == 1 || cantidadAñosDeEgreso == 2) {
                descuentoPorAñosDeEgreso = 0.08;
            } else if (cantidadAñosDeEgreso == 3 || cantidadAñosDeEgreso == 4) {
                descuentoPorAñosDeEgreso = 0.04;
            }
        }
        return descuentoPorAñosDeEgreso;
    }

    public double calcularValorPorCuota(EstudianteEntity estudiante){
        double descuentoTotal = calcularDescuentoPorTipoPago(estudiante) +
                                calcularDescuentoPorTipoColegio(estudiante) +
                                calcularDescuentoPorAñosDeEgreso(estudiante);
        double valorPorCuota = (1500000 - 1500000*descuentoTotal)/estudiante.getCant_cuotas();
        return valorPorCuota;
    }

}
