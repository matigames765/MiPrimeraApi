package com.example.miPrimeraApi.services;

import com.example.miPrimeraApi.entities.Factura;
import com.example.miPrimeraApi.repositories.BaseRepository;
import com.example.miPrimeraApi.repositories.FacturaRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaService extends BaseService<Factura,Long>{

    public FacturaService(FacturaRepository facturaRepository) {
        super(facturaRepository);
    }
}
