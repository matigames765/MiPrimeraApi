package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.DetallePedido;
import com.example.miPrimeraApi.entities.Domicilio;
import com.example.miPrimeraApi.repositories.DomicilioRepository;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController extends BaseController<Domicilio,Long>{

    @Autowired
    private DomicilioService domicilioService;

    public DomicilioController(DomicilioService domicilioService) {
        super(domicilioService);
    }

    @GetMapping("/localidad/{id}")
    public ResponseEntity<List<Domicilio>> listarPorLocalidad(@PathVariable Long idLocalidad) throws Exception{
        List<Domicilio> domicilios = domicilioService.listarPorLocalidad(idLocalidad);
        return ResponseEntity.ok(domicilios);
    }
}
