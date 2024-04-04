package com.codigo.vehiculos.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoCombustibleDTO {
    private Long idTipoCombustible;
    private String codigo;
    private String descripcion;
    private Integer estado;
}
