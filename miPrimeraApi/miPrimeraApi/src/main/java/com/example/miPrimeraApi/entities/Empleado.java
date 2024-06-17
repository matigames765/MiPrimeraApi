package com.example.miPrimeraApi.entities;

import com.example.miPrimeraApi.entities.enums.Rol;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado extends Base{

    @Column(name = "nombre_empleado")
    private String nombre;

    @Column(name = "apellido_empleado")
    private String apellido;

    @Column(name = "telefono_empleado")
    private String telefono;

    @Column(name = "email_empleado")
    private String email;

    @Column(name = "fecha_nacimiento_empleado")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_empleado")
    private Rol rolEmpleado;

    @OneToOne
    @JoinColumn(name = "fk_imagen_empleado")
    private Imagen imagenEmpleado;

    @OneToOne
    @JoinColumn(name = "fk_usuario_empleado")
    private Usuario usuarioEmpleado;

    @ManyToOne
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;



}
