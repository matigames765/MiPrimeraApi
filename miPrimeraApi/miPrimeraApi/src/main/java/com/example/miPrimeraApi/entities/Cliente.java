package com.example.miPrimeraApi.entities;

import com.example.miPrimeraApi.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "clientes")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends Base{

    @Column(name = "nombre_cliente")
    private String nombre;

    @Column(name = "apellido_cliente")
    private String apellido;

    @Column(name = "telefono_cliente")
    private String telefono;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "fecha_nacimiento_cliente")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_cliente")
    private Rol rolCliente;

    @OneToOne
    @JoinColumn(name = "fk_usuario_cliente")
    private Usuario usuarioCliente;

    @OneToOne
    @JoinColumn(name = "fk_imagen_cliente")
    private Imagen imagenCliente;

    @ManyToMany
    @JoinTable(name = "clientes_domicilios",joinColumns = @JoinColumn(name = "cliente_id"),inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<Domicilio>();

}
