package com.codigo.vehiculos.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


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
    private TipoVehiculoDTO tipoVehiculo;
    private MarcasDTO marca;
    private Float costoAlquiler;
    private Integer estado;
    private String usuarioCreate;
    private Timestamp dateCreate;
    private String usuarioUpdate;
    private Timestamp dateUpdate;
    private String usuarioDelete;
    private Timestamp dateDelete;
    private Set<TipoCombustibleDTO> listTipoCombustible = new HashSet<>();
}
