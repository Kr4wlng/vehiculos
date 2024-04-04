package com.codigo.vehiculos.infraestructure.repository;

import com.codigo.vehiculos.infraestructure.entity.TipoVehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculoEntity, Long> {
    TipoVehiculoEntity findByEstado(@Param("estado") Integer estado);
}
