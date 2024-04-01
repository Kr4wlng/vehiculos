package com.codigo.vehiculos.infraestructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "tipo_combustible")
public class TipoCombustibleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_tipo_combustible")
    private Long idTipoCombustible;
    @Column (name = "codigo")
    private String codigo;
    @Column (name = "descripcion")
    private String descripcion;
    @Column (name = "estado")
    private Integer estado;
}
