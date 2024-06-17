package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Imagen;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.ImagenRepository;
import org.springframework.stereotype.Service;

@Service
public class ImagenService extends BaseService<Imagen,Long>{

    public ImagenService(ImagenRepository imagenRepository) {
        super(imagenRepository);
    }
}
