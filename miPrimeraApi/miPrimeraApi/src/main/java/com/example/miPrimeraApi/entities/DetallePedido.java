package com.example.miPrimeraApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalles_pedidos")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends Base{

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "sub_total")
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "fk_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
