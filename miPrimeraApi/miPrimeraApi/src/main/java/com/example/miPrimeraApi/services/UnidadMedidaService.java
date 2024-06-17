package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.UnidadMedida;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.UnidadMedidaRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService extends BaseService<UnidadMedida,Long>{

    public UnidadMedidaService(UnidadMedidaRepository unidadMedidaRepository) {
        super(unidadMedidaRepository);
    }
}
