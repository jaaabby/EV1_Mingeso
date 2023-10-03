package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;

@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteEntity {
    @Id
    @Column(unique = true,nullable = false)
    private String rut;
    private String apellidos;
    private String nombres;
    private Date fecha_nac;
    private String tipo_colegio;
    private String nombre_colegio;
    private Integer año_egreso;
    private String tipo_pago;
    private Integer cant_cuotas;
}
