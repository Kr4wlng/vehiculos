package com.codigo.vehiculos.domain.ports.in;

import com.codigo.vehiculos.domain.aggregates.dto.VehiculosDTO;

import java.util.List;
import java.util.Optional;

public interface VehiculosServiceIn {
    VehiculosDTO crearVehiculoIn(VehiculosDTO vehiculosDTO);
    VehiculosDTO obtenerVehiculoIn(Long id);
    List<VehiculosDTO> obtenerTodosIn();
    VehiculosDTO actualizarIn(Long id, VehiculosDTO vehiculosDTO);
    VehiculosDTO deleteIn(Long id, String usuario);
}
