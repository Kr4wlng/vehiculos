package com.codigo.vehiculos.domain.ports.out;

import com.codigo.vehiculos.domain.aggregates.dto.VehiculosDTO;

import java.util.List;
import java.util.Optional;

public interface VehiculosServiceOut {
    VehiculosDTO crearVehiculoOut(VehiculosDTO vehiculosDTO);
    Optional<VehiculosDTO> obtenerVehiculoOut(Long id);
    List<VehiculosDTO> obtenerTodosOut();
    VehiculosDTO actualizarOut(Long id, VehiculosDTO vehiculosDTO);
    VehiculosDTO deleteOut(Long id, String usuario);
}
