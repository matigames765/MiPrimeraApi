package com.example.miPrimeraApi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "articulos_manufacturados_detalles")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticuloManufacturadoDetalle extends Base{

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "fk_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne
    @JoinColumn(name = "fk_articulo_insumo")
    private ArticuloInsumo articuloInsumo;
}
