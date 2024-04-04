package com.codigo.vehiculos.domain.impl;

import com.codigo.vehiculos.domain.aggregates.dto.VehiculosDTO;
import com.codigo.vehiculos.domain.ports.in.VehiculosServiceIn;
import com.codigo.vehiculos.domain.ports.out.VehiculosServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiculosServiceImpl implements VehiculosServiceIn {

    private final VehiculosServiceOut vehiculosServiceOut;

    @Override
    public VehiculosDTO crearVehiculoIn(VehiculosDTO vehiculosDTO) {
        return vehiculosServiceOut.crearVehiculoOut(vehiculosDTO);
    }

    @Override
    public VehiculosDTO obtenerVehiculoIn(Long id) {
        Optional<VehiculosDTO> vehiculosDTO = vehiculosServiceOut.obtenerVehiculoOut(id);
        if (vehiculosDTO.isEmpty()){
            throw new IllegalArgumentException("ID inválido");
        }
        return vehiculosDTO.get();
    }

    @Override
    public List<VehiculosDTO> obtenerTodosIn() {
        return vehiculosServiceOut.obtenerTodosOut();
    }

    @Override
    public VehiculosDTO actualizarIn(Long id, VehiculosDTO vehiculosDTO) {
        return vehiculosServiceOut.actualizarOut(id, vehiculosDTO);
    }

    @Override
    public VehiculosDTO deleteIn(Long id, String usuario) {
        return vehiculosServiceOut.deleteOut(id, usuario);
    }
}
