package com.codigo.vehiculos.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "tipo_vehiculo")
public class TipoVehiculoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_tipo_vehiculo")
    private Long idTipoVehiculo;
    @Column (name = "codigo")
    private String codigo;
    @Column (name = "descripcion")
    private String descripcion;
    @Column (name = "estado")
    private Integer estado;
}
