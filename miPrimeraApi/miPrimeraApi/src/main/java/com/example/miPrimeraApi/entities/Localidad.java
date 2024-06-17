package com.example.miPrimeraApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localidades")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localidad extends Base{

    @Column(name = "nombre_localidad")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_provincia")
    private Provincia provincia;

}
