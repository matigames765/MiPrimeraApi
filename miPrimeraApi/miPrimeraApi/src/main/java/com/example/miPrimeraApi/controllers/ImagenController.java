package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Imagen;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.services.BaseService;
import com.example.miPrimeraApi.services.ImagenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagenes")
public class ImagenController extends BaseController<Imagen,Long> {

    public ImagenController(ImagenService imagenService) {
        super(imagenService);
    }
}
