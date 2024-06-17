package com.example.miPrimeraApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "promociones_detalles")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromocionDetalle extends Base{

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "fk_promocion")
    private Promocion promocion;

    @ManyToOne
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;


}
