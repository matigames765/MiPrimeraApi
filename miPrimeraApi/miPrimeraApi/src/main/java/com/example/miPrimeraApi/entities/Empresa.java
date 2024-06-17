package com.example.miPrimeraApi.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "empresas")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa extends Base{

    @Column(name = "nombre_empresa")
    private String nombre;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuil")
    private Integer cuil;
}
