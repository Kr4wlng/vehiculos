package com.codigo.vehiculos.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/* @NamedQuery(name = "VeiculosEntity.findByEstado", query = "SELECT a FROM VehiculosEntity a where a.estado=:estado") */
@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class VehiculosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "placa", nullable = false)
    private String placa;
    @Column (name = "asientos", nullable = false)
    private Integer asientos;
    @Column (name = "anio_fabricacion", nullable = false)
    private Integer anioFabricacion;
    @Column (name = "color", length = 10)
    private String color;
    @Column (name = "transmision", nullable = false)
    private Integer transmision;
    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo")
    private TipoVehiculoEntity tipoVehiculo;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private MarcasEntity marca;
    @Column (name = "costo_alquiler", nullable = false)
    private Float costoAlquiler;
    @Column (name = "estado")
    private Integer estado;
    @Column (name = "usuario_create", length = 10)
    private String usuarioCreate;
    @Column (name = "date_create")
    private Timestamp dateCreate;
    @Column (name = "usuario_update", length = 10)
    private String usuarioUpdate;
    @Column (name = "date_update")
    private Timestamp dateUpdate;
    @Column(name = "usuario_delete", length = 10)
    private String usuarioDelete;
    @Column (name = "date_delete")
    private Timestamp dateDelete;
    @Builder.Default
    @ManyToMany
    @JoinTable(name = "vehiculos_tipo_combustible", joinColumns = @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo"), inverseJoinColumns = @JoinColumn(name = "id_tipo_combustible", referencedColumnName = "id_tipo_combustible"))
    private Set<TipoCombustibleEntity> listTipoCombustible = new HashSet<>();
}
