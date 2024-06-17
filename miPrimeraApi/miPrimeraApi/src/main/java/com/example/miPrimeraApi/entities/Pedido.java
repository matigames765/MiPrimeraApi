package com.example.miPrimeraApi.entities;

import com.example.miPrimeraApi.entities.enums.Estado;
import com.example.miPrimeraApi.entities.enums.FormaPago;
import com.example.miPrimeraApi.entities.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "pedidos")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends Base{

    @Column(name = "hora_estimada_finalizacion")
    private LocalTime horaEstimadaFinalizacion;

    @Column(name = "total")
    @Builder.Default
    private Double total = 0.0;

    @Column(name = "total_costo")
    private Double totalCosto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_envio")
    private TipoEnvio tipoEnvio;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "fk_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "fk_factura")
    private Factura factura;

}
