package com.example.miPrimeraApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "articulos_manufacturados")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("ARTICULO MANUFACTURADO")
public class ArticuloManufacturado extends Articulo{

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tiempo_estimado_minutos")
    private Integer tiempoEstimadoMinutos;

    @Column(name = "preparacion")
    private String preparacion;
}
