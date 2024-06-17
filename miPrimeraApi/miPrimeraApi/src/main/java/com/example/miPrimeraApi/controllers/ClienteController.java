package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Cliente;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController<Cliente, Long>{

    public ClienteController(ClienteService clienteService) {
        super(clienteService);
    }
}
