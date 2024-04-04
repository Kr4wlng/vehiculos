package com.codigo.vehiculos.infraestructure.repository;

import com.codigo.vehiculos.infraestructure.entity.TipoCombustibleEntity;
import com.codigo.vehiculos.infraestructure.entity.TipoVehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TipoCombustibleRepository extends JpaRepository<TipoCombustibleEntity, Long> {
    TipoCombustibleEntity findByEstado(@Param("estado") Integer estado);

}
