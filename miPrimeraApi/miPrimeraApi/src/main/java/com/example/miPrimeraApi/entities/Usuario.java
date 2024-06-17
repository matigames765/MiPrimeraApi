package com.example.miPrimeraApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario extends Base{

    @Column(name = "auth_id")
    private String auth0Id;

    @Column(name = "nombre_usuario")
    private String userName;
}
