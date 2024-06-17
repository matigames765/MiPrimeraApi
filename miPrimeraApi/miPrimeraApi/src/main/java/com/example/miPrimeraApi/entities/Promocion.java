package com.example.miPrimeraApi.entities;

import com.example.miPrimeraApi.entities.enums.TipoPromocion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promociones")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocion extends Base{

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "fecha_desde")
    private LocalDate fechaDesde;

    @Column(name = "fecha_hasta")
    private LocalDate fechaHasta;

    @Column(name = "hora_desde")
    private LocalTime horaDesde;

    @Column(name = "hora_hasta")
    private LocalTime horaHasta;

    @Column(name = "descripcion_descuento")
    private String descripcionDescuento;

    @Column(name = "precio_promocional")
    private Double precioPromocional;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_promocion")
    private TipoPromocion tipoPromocion;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "imagen_promocion_id")
    Set<Imagen> imagenesPromociones = new HashSet<Imagen>();


}
