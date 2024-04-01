package com.codigo.vehiculos.infraestructure.mapper;

import com.codigo.vehiculos.domain.aggregates.dto.VehiculosDTO;
import com.codigo.vehiculos.infraestructure.entity.VehiculosEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehiculosMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public VehiculosMapper(){
        modelMapper.getConfiguration().setSkipNullEnabled(true);
    }

    public VehiculosDTO mapTopDto(VehiculosEntity vehiculosEntity){
        return modelMapper.map(vehiculosEntity, VehiculosDTO.class);
    }

    public VehiculosEntity mapToEntity(VehiculosDTO vehiculosDTO){
        return modelMapper.map(vehiculosDTO, VehiculosEntity.class);
    }
}
