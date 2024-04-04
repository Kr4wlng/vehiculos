package com.codigo.vehiculos.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoVehiculoDTO {
    private Long idTipoVehiculo;
    private String codigo;
    private String descripcion;
    private Integer estado;
}
