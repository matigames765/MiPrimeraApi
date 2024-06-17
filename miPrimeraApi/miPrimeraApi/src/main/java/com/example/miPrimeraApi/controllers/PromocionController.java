package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Promocion;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.PromocionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promociones")
public class PromocionController extends BaseController<Promocion,Long>{

    public PromocionController(PromocionService promocionService) {
        super(promocionService);
    }
}
