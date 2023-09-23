package com.example.demo.entities;

import jakarta.persistence.*;
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
    /*@GeneratedValue(strategy = GenerationType.IDENTITY) para generar los valores en forma automatica*/
    @Column(unique = true,nullable = false)
    private Integer rut_estud;

    private String apellidos_estud;
    private String nombres_estud;
    private Date fecha_nac;
    private String tipo_colegio;
    private String nombre_colegio;
    private Integer año_egreso;
}
