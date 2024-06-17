package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Promocion;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.PromocionRepository;
import org.springframework.stereotype.Service;

@Service
public class PromocionService extends BaseService<Promocion,Long>{

    public PromocionService(PromocionRepository promocionRepository) {
        super(promocionRepository);
    }
}
