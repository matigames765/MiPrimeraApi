package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Factura;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.FacturaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facturas")
public class FacturaController extends BaseController<Factura,Long>{

    public FacturaController(FacturaService facturaService) {
        super(facturaService);
    }
}
