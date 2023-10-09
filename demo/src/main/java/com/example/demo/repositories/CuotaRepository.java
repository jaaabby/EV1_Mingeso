package com.example.demo.repositories;

import com.example.demo.entities.CuotaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface CuotaRepository extends CrudRepository<CuotaEntity,Long> {

    @Query(value = "select * from cuota as c where c.rut = :rut",
            nativeQuery = true)
    ArrayList<CuotaEntity> findCuotasEstudiante(@Param("rut") String rut);

    @Query(value = "update cuota set estado = :estado where rut = :rut and nro_cuota = :nro_cuota",
            nativeQuery = true)
    void cambiarEstadoCuota(@Param("estado") String estado,@Param("rut") String rut,@Param("nro_cuota") Integer nro_cuota);

}
