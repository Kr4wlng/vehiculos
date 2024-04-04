package com.codigo.vehiculos.infraestructure.repository;

import com.codigo.vehiculos.infraestructure.entity.VehiculosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculosRepository extends JpaRepository<VehiculosEntity, Long> {
    List<VehiculosEntity> findByEstado(@Param("estado") Integer estado);
}
