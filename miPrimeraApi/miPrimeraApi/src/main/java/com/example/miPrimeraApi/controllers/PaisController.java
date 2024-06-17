package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Pais;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.PaisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController extends BaseController<Pais,Long>{

    public PaisController(PaisService paisService) {
        super(paisService);
    }
}
