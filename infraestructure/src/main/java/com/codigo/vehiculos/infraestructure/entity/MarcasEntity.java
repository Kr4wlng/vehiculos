package com.codigo.vehiculos.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "marcas")
public class MarcasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_marca")
    private Long idMarca;
    @Column (name = "codigo")
    private String codigo;
    @Column (name = "descripcion")
    private String descripcion;
    @Column (name = "estado")
    private Integer estado;
}
