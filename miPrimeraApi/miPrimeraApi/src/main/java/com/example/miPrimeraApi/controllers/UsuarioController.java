package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Base;
import com.example.miPrimeraApi.entities.Usuario;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario,Long> {

    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
    }
}
