package com.example.miPrimeraApi.entities;

import com.example.miPrimeraApi.entities.enums.FormaPago;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "facturas")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends Base{

    @Column(name = "fecha_facturacion")
    private LocalDate fechaFacturacion;

    @Column(name = "id_pago_mp")
    private Integer mpPaymentId;

    @Column(name = "id_orden_comercial_mp")
    private Integer mpMerchantOrderId;

    @Column(name = "id_preferencia_mp")
    private String mpPreferenceId;

    @Column(name = "tipo_pago_mp")
    private String mpPaymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "total_venta")
    private Double totalVenta;
}
