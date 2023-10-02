package com.example.demo.repositories;

import com.example.demo.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, String> {

    @Query(value = "select e.cant_cuotas from estudiante as e where e.rut = :rut",
            nativeQuery = true)
    Integer findCantCuotas(@Param("rut") String rut);

    @Query(value = "select * from estudiante as e where e.rut = :rut",
            nativeQuery = true)
    EstudianteEntity findByRut(@Param("rut")String rut);

}
