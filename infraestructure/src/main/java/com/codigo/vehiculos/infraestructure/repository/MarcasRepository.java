package com.codigo.vehiculos.infraestructure.repository;

import com.codigo.vehiculos.infraestructure.entity.MarcasEntity;
import com.codigo.vehiculos.infraestructure.entity.TipoVehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MarcasRepository extends JpaRepository<MarcasEntity, Long> {
    MarcasEntity findByidMarca(@Param("idMarca") Long idMarca);

}
