package com.example.miPrimeraApi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articulos")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class Articulo extends Base{

    @Column(name = "denominacion")
    protected String denominacion;

    @Column(name = "precio_venta")
    protected Double precioVenta;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "imagenes_articulos_id")
    Set<Imagen> imagenesArticulos = new HashSet<Imagen>();

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    protected Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fk_unidad_medida")
    protected UnidadMedida unidadMedida;


}
