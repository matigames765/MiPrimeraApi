package com.example.miPrimeraApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sucursales")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal extends Base{

    @Column(name = "nombre_sucursal")
    private String nombre;

    @Column(name = "horario_apertura")
    private LocalTime horarioApertura;

    @Column(name = "horario_cierre")
    private LocalTime horarioCierre;

    @Column(name = "casa_matriz")
    private Boolean casaMatriz;

    @ManyToOne
    @JoinColumn(name = "fk_empresa")
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @ManyToMany
    @JoinTable(name = "sucursal_promocion",joinColumns = @JoinColumn(name = "sucursal_id"),inverseJoinColumns = @JoinColumn(name = "promocion_id"))
    @Builder.Default
    Set<Promocion> promociones = new HashSet<Promocion>();

    @ManyToMany
    @JoinTable(name = "sucursal_categoria",joinColumns = @JoinColumn(name = "sucursal_id"),inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    Set<Categoria> categorias = new HashSet<Categoria>();

}
