package com.codigo.vehiculos.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculosDTO {
    private Long idVehiculo;
    private String codigo;
    private String placa;
    private Integer asientos;
    private Integer anioFabricacion;
    private String color;
    private Integer transmision;
    private Integer idTipoVehiculo;
    private Integer idMarca;
    private Float costoAlquiler;
    private Integer estado;
    private String usuarioCreate;
    private Timestamp dateCreate;
    private String usuarioUpdate;
    private Timestamp dateUpdate;
    private String usuarioDelete;
    private Timestamp dateDelete;
}
