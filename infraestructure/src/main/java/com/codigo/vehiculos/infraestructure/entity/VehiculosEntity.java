package com.codigo.vehiculos.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@NamedQuery(name = "VeiculosEntity.findByEstado", query = "SELECT a FROM VehiculosEntity a where a.estado=:estado")
@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class VehiculosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "placa")
    private String placa;
    @Column (name = "asientos")
    private Integer asientos;
    @Column (name = "anio_fabricacion")
    private Integer anioFabricacion;
    @Column (name = "color")
    private String color;
    @Column (name = "transmision")
    private Integer transmision;
    @Column (name = "id_tipo_vehiculo")
    private Integer idTipoVehiculo;
    @Column (name = "id_marca")
    private Integer idMarca;
    @Column (name = "costo_alquiler")
    private Float costoAlquiler;
    @Column (name = "estado")
    private Integer estado;
    @Column (name = "usuario_create")
    private String usuarioCreate;
    @Column (name = "date_create")
    private Timestamp dateCreate;
    @Column (name = "usuario_update")
    private String usuarioUpdate;
    @Column (name = "date_update")
    private Timestamp dateUpdate;
    @Column(name = "usuario_delete")
    private String usuarioDelete;
    @Column (name = "date_delete")
    private Timestamp dateDelete;
}
